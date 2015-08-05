package br.edu.ifrs.canoas.tads.lds.control.service;

import java.util.ArrayList;
import java.util.Date;
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
	private Incidente incidenteValida = new Incidente("Busca Inv�lida", null, "Busca Inv�lida");

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
		{
			List<Incidente> lista = new ArrayList<Incidente>();
			lista.add(new Incidente("Busca Inv�lida", null, "Busca Inv�lida"));
			return lista;
		}		
	}
	
	public List<Incidente> lista ()
	{
		return incidenteDAO.listaIncidentes();
	}
	
	@SuppressWarnings("unchecked")
	public List<Incidente> busca(Date data) {
		Date dataatual = new Date();
		if (data != null && dataatual.after(data) || dataatual.equals(data))
			return incidenteDAO.buscaPorCriterio(data);
		else
		{
			List<Incidente> lista = new ArrayList<Incidente>();
			lista.add(new Incidente("Busca Inv�lida", null, "Busca Inv�lida"));
			return lista;
		}		
	}
	
	@SuppressWarnings("unchecked")
	public void exclui(Incidente incidente)
	{
		incidenteDAO.exclui(incidente.getId());
	}

}
