package br.edu.ifrs.canoas.ancient.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Mensagem extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = -5179659812813041965L;
	
	@OneToOne
	private Usuario remetente;
	
	@OneToOne
	private Usuario destinatario;
	
	private String titulo;
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	private String mensagem;
	
	private boolean status;

	public boolean isStatus() {
		return status;
	}
	
	public String statusAtual()
	{
		return this.status ? "Sim":"Não";
	}
	
	public void lida()
	{
		setStatus(true);
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Usuario getRemetente() {
		return remetente;
	}

	public void setRemetente(Usuario remetente) {
		this.remetente = remetente;
	}

	public Usuario getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	
	
	
	

}
