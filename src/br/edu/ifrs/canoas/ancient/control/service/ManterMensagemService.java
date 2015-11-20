package br.edu.ifrs.canoas.ancient.control.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.edu.ifrs.canoas.ancient.bean.Mensagem;
import br.edu.ifrs.canoas.ancient.bean.Usuario;
import br.edu.ifrs.canoas.ancient.model.dao.MensagemDAO;

@Stateless
public class ManterMensagemService {
	
	@Inject
	private MensagemDAO mensagemDAO;
	

	public List<Mensagem> todas()
	{
		return mensagemDAO.todas();
	}
	
	/*public List<Mensagem> mensagensUsuario(Usuario usuario)
	{
		return mensagemDAO.mensagensUsuario(usuario);
	}*/
	
	public void enviarMensagem(Mensagem mensagem)
	{
		mensagemDAO.insere(mensagem);
	}

}
