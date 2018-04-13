package com.ipartek.formacion.nidea.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.nidea.pojo.Usuario;

/**
 * Application Lifecycle Listener implementation class
 * UsuariosConectadosListener
 *
 */
@WebListener
public class UsuariosConectadosListener implements HttpSessionListener, HttpSessionAttributeListener {

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {

		if (se.getSession().getAttribute("uPublic") != null) {

			Usuario newUser = (Usuario) se.getSession().getAttribute("uPublic");

			// contexto de la aplicion
			ServletContext context = se.getSession().getServletContext();

			if (context.getAttribute("usuarios_conectados") != null) {

				HashMap<Integer, Usuario> usuarios = (HashMap<Integer, Usuario>) context
						.getAttribute("usuarios_conectados");
				// sacar usuario en hashMap
				usuarios.remove(newUser.getId());
				// guardar hashMap en el contexto Servlets
				context.setAttribute("usuarios_conectados", usuarios);

			}
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {
		// comprobar que sea atributo==uPublic
		String evento = event.getName();
		if ("uPublic".equals(evento)) {
			// contexto de la aplicion
			ServletContext context = event.getSession().getServletContext();
			HashMap<Integer, Usuario> usuarios = (HashMap<Integer, Usuario>) context
					.getAttribute("usuarios_conectados");
			if (usuarios == null) {
				usuarios = new HashMap<Integer, Usuario>();
			}
			Usuario newUser = (Usuario) event.getValue();
			// guardar usuario en hashMap
			usuarios.put(newUser.getId(), newUser);
			// guardar hashMap en el contexto Servlets
			context.setAttribute("usuarios_conectados", usuarios);
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {

	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
	}

}
