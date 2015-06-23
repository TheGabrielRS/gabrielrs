package br.edu.ifrs.canoas.tads.lds.control.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.edu.ifrs.canoas.tads.lds.bean.Incidente;
import br.edu.ifrs.canoas.tads.lds.model.dao.IncidenteDAO;
import br.edu.ifrs.canoas.tads.lds.util.Mensagens;
import br.edu.ifrs.canoas.tads.lds.util.StrUtil;

@Stateless
public class ManterIncidenteService {

	@Inject
	private IncidenteDAO incidenteDAO;

	public boolean salvaIncidente(Incidente incidente) 
	{
		incidenteDAO.insere(incidente);
		//Mensagens.define(FacesMessage.SEVERITY_INFO, "Incidente cadastrado");
		return true;
	}


	@SuppressWarnings("unchecked")
	public List<Incidente> busca(String criterio) {
		if (criterio != null && criterio.length() > 0) 
			return incidenteDAO.buscaPorCriterio(criterio);
		else
			return incidenteDAO.buscaTodos();
	}

}
