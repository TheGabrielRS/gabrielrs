package br.edu.ifrs.canoas.ancient.control.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.edu.ifrs.canoas.ancient.bean.Local;
import br.edu.ifrs.canoas.ancient.model.dao.LocalDAO;

@Stateless
public class ManterLocalService {
	
	@Inject
	private LocalDAO localDAO;
	
	public boolean salvar(Local local)
	{
		try{
			localDAO.insere(local);
			return true;
		}catch (Exception E){
			return false;
		}
		
	}
	
	public void editar(Local local)
	{
		localDAO.atualiza(local);
	}

	public List<Local> lista()
	{
		return (List<Local>) localDAO.buscaTodos();
	}
	
	
	public LocalDAO getLocalDAO() {
		return localDAO;
	}

	public void setLocalDAO(LocalDAO localDAO) {
		this.localDAO = localDAO;
	}

	
	
}
