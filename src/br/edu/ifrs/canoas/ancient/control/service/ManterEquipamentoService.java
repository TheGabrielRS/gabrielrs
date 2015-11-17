package br.edu.ifrs.canoas.ancient.control.service;

import br.edu.ifrs.canoas.ancient.model.dao.EquipamentoDAO;
import br.edu.ifrs.canoas.ancient.bean.Equipamento;

import javax.ejb.Stateless;
import javax.inject.Inject;

import java.util.List;

@Stateless
public class ManterEquipamentoService {
	
	@Inject
	private EquipamentoDAO equipamentoDAO;
	
	public List<Equipamento> listaTodos()
	{
		return equipamentoDAO.buscaTodos();
	}
	
	public void salva(Equipamento equipamento)
	{
		equipamentoDAO.insere(equipamento);
	}
	
	public void remove(Equipamento e)
	{
		equipamentoDAO.exclui(e.getId());
	}
	
	public void edita(Equipamento e)
	{
		equipamentoDAO.atualiza(e);
	}

}
