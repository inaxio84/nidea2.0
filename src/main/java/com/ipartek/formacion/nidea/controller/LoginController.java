package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.nidea.model.UsuarioDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String view = "";
	private Alert alert = new Alert();
	private UsuarioDAO dao;

	// private static final String USER = "admin";
	// private static final String PASS = "admin";
	private static final int SESSION_EXPIRATION = -1; // NO EXPIRA
	// private static final int SESSION_EXPIRATION = 60 * 20; // 20 min

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			dao = UsuarioDAO.getInstance();

			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");

			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			usuarios = dao.getAll();

			request.setAttribute("materiales", materiales);

			if (USER.equalsIgnoreCase(usuario) && PASS.equals(password)) {

				// guardar usuario en session
				HttpSession session = request.getSession();
				session.setAttribute("usuario", usuario);

				/*
				 * Tiempo expiracion session, tambien se puede configurar web.xml un valor
				 * negativo, indica que nunca expira
				 * 
				 * <session-config> <session-timeout>-1</session-timeout> </session-config>
				 * 
				 */
				session.setMaxInactiveInterval(SESSION_EXPIRATION);

				view = "backoffice/index.jsp";
				alert = new Alert("Ongi Etorri", Alert.TIPO_PRIMARY);
			} else {

				view = "login.jsp";
				alert = new Alert("Credenciales incorrectas, prueba de nuevo");
			}

		} catch (Exception e) {
			e.printStackTrace();
			view = "login.jsp";
			alert = new Alert();

		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

}