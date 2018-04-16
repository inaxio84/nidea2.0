package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Usuario;
import com.ipartek.formacion.nidea.util.Utilidades;

public class UsuarioDAO implements Persistible<Usuario> {

	private static UsuarioDAO INSTANCE = null;

	// Private constructor NO se pueda hacer new y crear N instancias
	private UsuarioDAO() {
	}

	// creador synchronized para protegerse de posibles problemas multi-hilo
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
	}

	public static UsuarioDAO getInstance() {
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
	public ArrayList<Usuario> getAll() {
		String sql = "";
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		sql = "SELECT id, nombre, password, id_rol FROM usuario ORDER BY `id` ASC LIMIT 500;";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			/*
			 * Class.forName("com.mysql.jdbc.Driver"); final String URL =
			 * "jdbc:mysql://192.168.0.42/spoty?user=alumno&password=alumno"; con =
			 * DriverManager.getConnection(URL);
			 */

			Usuario u = null;
			while (rs.next()) {
				u = mapper(rs);
				lista.add(u);
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

	@Override
	public Usuario getById(int id) {
		Usuario u = null;
		String sql = "SELECT `id`, `nombre`, `password`, `id_rol`  FROM `usuario` WHERE `id` = ? ;";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					u = mapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public boolean save(Usuario pojo) throws Exception {
		boolean resul = false;

		// sanear el nombre utilizando la utilidad de limpiar espacios
		pojo.setNombre(Utilidades.limpiarEspacios(pojo.getNombre()));

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

	private boolean modificar(Usuario pojo) {
		boolean resul = false;
		String sql = "UPDATE `nidea_ejercicio`.`usuario` SET `nombre`=?, `password`=?, `id_rol`=? WHERE  `id`=?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getPassword());
			pst.setInt(3, pojo.getId_rol());

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

	private boolean crear(Usuario pojo) throws Exception {
		boolean resul = false;
		String sql = "INSERT INTO `nidea_ejercicio`.`usuario` (`nombre`, `password`, `id_rol`) VALUES (?, ?, ?);";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {
			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getPassword());
			pst.setInt(3, pojo.getId_rol());

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
			String sql = "DELETE FROM `usuario` WHERE  `id`= ?;";

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
	public Usuario mapper(ResultSet rs) throws SQLException {
		Usuario u = null;
		if (rs != null) {
			u = new Usuario();
			u.setId(rs.getInt("id"));
			u.setNombre(rs.getString("nombre"));
			u.setPassword(rs.getString("password"));
		}
		return u;
	}

}
