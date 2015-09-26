package br.edu.ifrs.canoas.ancient.mb;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import br.edu.ifrs.canoas.ancient.mb.TransfereEntidadeMB;

@ApplicationScoped
public class ListenerTransfere implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		TransfereEntidadeMB transfereEntidadeMB = new TransfereEntidadeMB();
		event.getServletContext().setAttribute("foo", transfereEntidadeMB);
		
	}

	


}
