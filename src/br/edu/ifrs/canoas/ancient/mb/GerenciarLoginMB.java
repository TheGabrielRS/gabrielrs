package br.edu.ifrs.canoas.ancient.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.ancient.bean.Usuario;
import br.edu.ifrs.canoas.ancient.control.service.GerenciarLoginService;
import br.edu.ifrs.canoas.ancient.mb.TransfereEntidadeMB;

@SessionScoped
@Named
public class GerenciarLoginMB implements Serializable  {

	@Inject
	private Usuario usuario;

	private TransfereEntidadeMB transfereEntidade;
	
	@Inject
	private GerenciarLoginService loginService;
	
	private final String pagLogin = "/public/pages/login";
	
	private final String pagWelcome = "/private/pages/index";
	

	public String login() {
		usuario = loginService.login(usuario);
		transfereEntidade = new TransfereEntidadeMB();
		return isLogado()?pagWelcome:pagLogin;
	}

	public String logout() {
		usuario = new Usuario();
		return pagLogin;
	}

	public boolean isLogado() {
		return usuario != null && usuario.getId() != null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
