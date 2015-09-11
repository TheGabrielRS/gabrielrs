package br.edu.ifrs.canoas.ancient.control.service;

import javax.ejb.Stateless;

import br.edu.ifrs.canoas.ancient.bean.Local;
import br.edu.ifrs.canoas.ancient.model.dao.LocalDAO;

@Stateless
public class ManterLocalService {
	
	private LocalDAO localDAO;
	
	public void salvar(Local local)
	{
		localDAO.insere(local);
	}

}
