package br.edu.ifrs.canoas.tads.lds.model.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.edu.ifrs.canoas.tads.lds.bean.Incidente;
import br.edu.ifrs.canoas.tads.lds.util.StrUtil;

@Stateless
public class IncidenteDAO extends BaseDAO<Incidente, Long>{
	
	private static final long serialVersionUID = -609095339271933353L;

	@SuppressWarnings("unchecked")
	public List<Incidente> busca(Incidente incidente){
				
		if (incidente == null)
			return new ArrayList<Incidente>();
		
		 Criteria criteria = super.getSection().createCriteria(Incidente.class);

		 
		 if (StrUtil.isNotBlank(incidente.getTitulo()))
			 criteria.add(Restrictions.eq("titulo", incidente.getTitulo().trim().toLowerCase()));
		
		 if (StrUtil.isNotBlank(incidente.getDescricao()))
			 criteria.add(Restrictions.eq("descricao", incidente.getDescricao().trim().toLowerCase()));
		 
		 if (StrUtil.isNotBlank(incidente.getData()))
			 criteria.add(Restrictions.eq("data", incidente.getData().trim().toLowerCase()));

		 return criteria.list();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Incidente> buscaPorCriterio(String criterio){
		return em.createQuery(
		         "SELECT i "
		         + "FROM Incidente i"
		         + "WHERE lower(i.titulo) = :titulo "
		         + " or lower (i.descricao) = :descricao "
		         + " or lower (i.data) =  :data ")
		         .setParameter("titulo", criterio.trim().toLowerCase())
		         .setParameter("descricao", criterio.trim().toLowerCase())
		         .setParameter("data", criterio.trim().toLowerCase())
		         .getResultList();
	}

}
