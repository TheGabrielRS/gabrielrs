package br.edu.ifrs.canoas.ancient.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import br.edu.ifrs.canoas.ancient.bean.Grupo;

public class GrupoDAO extends BaseDAO<Grupo, Long>{

	private static final long serialVersionUID = 1142254858502520046L;
	
	@SuppressWarnings("unchecked")
	public List<Grupo> listaGrupo ()
	{
		return em.createQuery("SELECT g FROM Grupo g").getResultList();
	}
		
}
