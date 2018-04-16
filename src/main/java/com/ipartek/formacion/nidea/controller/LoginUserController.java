package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.nidea.pojo.Usuario;

/**
 * Servlet implementation class LoginUserController
 */
@WebServlet("/loginUser")
public class LoginUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginUserController() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("userlogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String password = "123456";
		final int id_rol = 2;
		// recogemos parametros del jsp
		String nombre = request.getParameter("usuario");
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(15);
		Usuario user = new Usuario();
		user.setNombre(nombre);
		user.setPassword(password);
		user.setId(id);
		user.setId_rol(id_rol);
		session.setAttribute("uPublic", user);

		/*
		 * // recoger usuarios conectados del servletContext ServletContext context =
		 * request.getServletContext(); HashMap<Integer, String> usuarios =
		 * (HashMap<Integer, String>) context.getAttribute("usuarios_conectados"); if
		 * (usuarios == null) { usuarios = new HashMap<Integer, String>(); }
		 * 
		 * // guardar usuario en hashMap usuarios.put(id, user); // guardar hashMap en
		 * el contexto Servlets context.setAttribute("usuarios_conectados", usuarios);
		 */
		request.getRequestDispatcher("frontoffice/index.jsp").forward(request, response);

	}

}
