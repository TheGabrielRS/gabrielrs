package br.edu.ifrs.canoas.ancient.control.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.edu.ifrs.canoas.ancient.bean.Incidente;
import br.edu.ifrs.canoas.ancient.model.dao.IncidenteDAO;
import br.edu.ifrs.canoas.ancient.util.Mensagens;
import br.edu.ifrs.canoas.ancient.util.StrUtil;

@Stateless
public class ManterIncidenteService {

	@Inject
	private IncidenteDAO incidenteDAO;
	
	public void editarIncidente(Incidente inc)
	{
		incidenteDAO.atualiza(inc);
	}
	
	
	public boolean salvaIncidente(Incidente incidente) 
	{
		incidenteDAO.insere(incidente);
		//Mensagens.define(FacesMessage.SEVERITY_INFO, "Incidente cadastrado");
		return true;
	}

	public List<Incidente> lista ()
	{
		return incidenteDAO.listaIncidentes();
	}
	
	@SuppressWarnings("unchecked")
	public void exclui(Incidente incidente)
	{
		incidenteDAO.exclui(incidente.getId());
	}

}
