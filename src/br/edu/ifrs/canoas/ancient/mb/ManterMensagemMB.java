package br.edu.ifrs.canoas.ancient.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.ancient.bean.Mensagem;
import br.edu.ifrs.canoas.ancient.control.service.ManterMensagemService;

@Named
@SessionScoped
public class ManterMensagemMB implements Serializable {

	private static final long serialVersionUID = 4230943228909481093L;

	private Mensagem mensagem;
	
	private List<Mensagem> mensagens;
	
	private List<Mensagem> minhasMensagens = new ArrayList<Mensagem>();

	@EJB
	private ManterMensagemService mensagemService;
	
	@Inject
	private GerenciarLoginMB gerenciarLogin;
	
	
	@PostConstruct
	public void init()
	{
		this.mensagem = new Mensagem();
		mensagensUsuario();
	}
	
	public List<Mensagem> getMinhasMensagens() {
		return minhasMensagens;
	}

	public void setMinhasMensagens(List<Mensagem> minhasMensagens) {
		this.minhasMensagens = minhasMensagens;
	}

	public void lista()
	{
		setMensagens(mensagemService.todas());
	}
	
	public void enviarMensagem()
	{
		mensagem.setRemetente(gerenciarLogin.getUsuario());
		mensagemService.enviarMensagem(this.mensagem);
		this.mensagem = new Mensagem();
	}
	
	public void mensagensUsuario()
	{
		System.out.println("entrou no metodo");
		lista();
		System.out.println("preencheu a lista");
		try{
			mensagens.forEach(msg->{
				if(msg.getDestinatario().equals(this.getGerenciarLogin().getUsuario()))
					minhasMensagens.add(msg);
			});
		}
		catch(Exception e)
		{
			System.out.println("erro no foreach");
			minhasMensagens.toString();
		}
			
		/*mensagens.forEach(msg->{
			if(msg.getDestinatario().equals(this.getGerenciarLogin().getUsuario()))
				minhasMensagens.add(msg);
			System.out.println(msg.getTitulo());
		});*/
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public GerenciarLoginMB getGerenciarLogin() {
		return gerenciarLogin;
	}

	public void setGerenciarLogin(GerenciarLoginMB gerenciarLogin) {
		this.gerenciarLogin = gerenciarLogin;
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
