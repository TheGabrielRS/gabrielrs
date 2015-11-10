package br.edu.ifrs.canoas.ancient.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.ancient.bean.Mensagem;
import br.edu.ifrs.canoas.ancient.control.service.ManterMensagemService;

@Named
@SessionScoped
public class ManterMensagemMB implements Serializable {

	private static final long serialVersionUID = -5081577176810130550L;
	
	@Inject
	private Mensagem mensagem;
	
	private List<Mensagem> mensagens;
	
	private List<Mensagem> lidas;
	
	private List<Mensagem> naolidas;
	
	@EJB
	private ManterMensagemService mensagemService;
	
	@ManagedProperty(value="#{gerenciarLoginMB}")
	private GerenciarLoginMB gerenciarLogin;
	
	
	@PostConstruct
	public void init()
	{
		this.mensagensUsuario();
		this.status();
	}

	public void status()
	{
		for(Mensagem mensagemSelecionada : mensagens)
		{
			if(mensagemSelecionada.isStatus())
				lidas.add(mensagemSelecionada);
			else
				naolidas.add(mensagemSelecionada);
		}
	}
	
	public void mensagensUsuario()
	{
		setMensagens(mensagemService.mensagensUsuario(gerenciarLogin.getUsuario()));
	}
	public List<Mensagem> getLidas() {
		return lidas;
	}

	public void setLidas(List<Mensagem> lidas) {
		this.lidas = lidas;
	}

	public List<Mensagem> getNaolidas() {
		return naolidas;
	}

	public void setNaolidas(List<Mensagem> naolidas) {
		this.naolidas = naolidas;
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public ManterMensagemService getMensagemService() {
		return mensagemService;
	}

	public void setMensagemService(ManterMensagemService mensagemService) {
		this.mensagemService = mensagemService;
	}
	
	
	

}
