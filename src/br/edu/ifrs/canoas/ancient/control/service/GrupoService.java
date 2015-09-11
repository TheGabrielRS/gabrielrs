package br.edu.ifrs.canoas.ancient.control.service;

import br.edu.ifrs.canoas.ancient.model.dao.GrupoDAO;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.edu.ifrs.canoas.ancient.bean.BaseEntity;
import br.edu.ifrs.canoas.ancient.bean.Grupo;

@Stateless
public class GrupoService extends BaseEntity<Long> implements Serializable {
	
	@Inject
	private GrupoDAO grupoDAO;
	
	public List<Grupo> listaGrupo()
	{
		return grupoDAO.listaGrupo();
	}
	
	public boolean salvaGrupo (Grupo grupo)
	{
		grupoDAO.insere(grupo);
		return true;
	}
	
	
	
}