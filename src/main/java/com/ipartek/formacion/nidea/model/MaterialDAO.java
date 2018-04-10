package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Material;

public class MaterialDAO implements Persistible<Material> {

	private static MaterialDAO INSTANCE = null;

	// Private constructor NO se pueda hacer new y crear N instancias
	private MaterialDAO() {
	}

	// creador synchronized para protegerse de posibles problemas multi-hilo
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MaterialDAO();
		}
	}

	public static MaterialDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	/**
	 * Recupera todos los materiales de la BBDD ordenados por id descendente
	 * 
	 * @param search
	 * 
	 * @return ArrayList<Material> si no existen registros new ArrayList<Material>()
	 */
	@Override
	public ArrayList<Material> getAll() {
		String sql = "";
		ArrayList<Material> lista = new ArrayList<Material>();
		sql = "SELECT id, nombre, precio FROM material ORDER BY `id` ASC LIMIT 500;";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			/*
			 * Class.forName("com.mysql.jdbc.Driver"); final String URL =
			 * "jdbc:mysql://192.168.0.42/spoty?user=alumno&password=alumno"; con =
			 * DriverManager.getConnection(URL);
			 */

			Material m = null;
			while (rs.next()) {
				m = mapper(rs);
				lista.add(m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * finally {
		 * 
		 * try { if (rs != null) { rs.close(); }
		 * 
		 * if (pst != null) { pst.close(); }
		 * 
		 * if (con != null) { con.close(); } } catch (SQLException e) {
		 * e.printStackTrace(); } }
		 * 
		 */

		return lista;
	}

	public ArrayList<Material> filtrar(String search) {
		String sql = "";
		ArrayList<Material> lista = new ArrayList<Material>();
		if ("".equals(search)) {
			sql = "SELECT id, nombre, precio FROM material ORDER BY `id` DESC LIMIT 500;";
		} else {
			sql = "SELECT id, nombre, precio FROM material WHERE `nombre` LIKE ? ORDER BY `id` DESC LIMIT 500;";
		}
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			if (!"".equals(search)) {
				pst.setString(1, "%" + search + "%");
			}
			try (ResultSet rs = pst.executeQuery();) {
				Material m = null;
				while (rs.next()) {
					m = mapper(rs);
					lista.add(m);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Material getById(int id) {
		Material material = null;
		String sql = "SELECT `id`, `nombre`, `precio` FROM `material` WHERE `id` = ? ;";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					material = mapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return material;
	}

	@Override
	public boolean save(Material pojo) throws Exception {
		boolean resul = false;
		if (pojo != null) {
			if (pojo.getId() == -1) {
				try {
					resul = crear(pojo);

				} catch (Exception e) {

					e.printStackTrace();
					throw new Exception("MySQLIntegrityConstraintViolationException");

				}
			} else {
				resul = modificar(pojo);
			}
		}
		return resul;
	}

	private boolean modificar(Material pojo) {
		boolean resul = false;
		String sql = "UPDATE `nidea`.`material` SET `nombre`=?, `precio`=? WHERE  `id`=?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, pojo.getNombre());
			pst.setFloat(2, pojo.getPrecio());
			pst.setInt(3, pojo.getId());

			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("duplicado:");
			System.out.println(e);
		}
		return resul;
	}

	private boolean crear(Material pojo) throws Exception {
		boolean resul = false;
		String sql = "INSERT INTO `nidea`.`material` (`nombre`, `precio`) VALUES (?, ?);";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {
			pst.setString(1, pojo.getNombre());
			pst.setFloat(2, pojo.getPrecio());

			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1) {
				// recuperar ID generado de forma automatica
				try (ResultSet rs = pst.getGeneratedKeys()) {
					while (rs.next()) {
						pojo.setId(rs.getInt(1));
						resul = true;
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("duplicado");
			System.out.println(e);
			throw new Exception("MySQLIntegrityConstraintViolationException");
		}
		return resul;
	}

	@Override
	public boolean delete(int id) {
		boolean resul = false;
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = ConnectionManager.getConnection();
			String sql = "DELETE FROM `material` WHERE  `id`= ?;";

			pst = con.prepareStatement(sql);
			pst.setInt(1, id);

			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (pst != null) {
					pst.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resul;
	}

	@Override
	public Material mapper(ResultSet rs) throws SQLException {
		Material m = null;
		if (rs != null) {
			m = new Material();
			m.setId(rs.getInt("id"));
			m.setNombre(rs.getString("nombre"));
			m.setPrecio(rs.getFloat("precio"));
		}
		return m;
	}

}