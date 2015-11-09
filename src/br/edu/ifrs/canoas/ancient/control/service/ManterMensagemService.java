package br.edu.ifrs.canoas.ancient.control.service;

import javax.ejb.Stateless;
import java.util.List;

import br.edu.ifrs.canoas.ancient.model.dao.MensagemDAO;
import br.edu.ifrs.canoas.ancient.bean.Mensagem;


@Stateless
public class ManterMensagemService {
	
	private MensagemDAO mensagemDAO;
	
	public List<Mensagem>  todas()
	{
		return mensagemDAO.buscaTodos();
	}

}