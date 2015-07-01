package br.edu.ifrs.canoas.tads.lds.control.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import br.edu.ifrs.canoas.tads.lds.bean.Incidente;
import br.edu.ifrs.canoas.tads.lds.control.service.ManterIncidenteService;

@Named
@RequestScoped
public class ManterIncidenteMB implements Serializable{

	private static final long serialVersionUID = -5481426310511396058L;
	
	@Inject
	private Incidente incidente;
	
	@EJB
	private ManterIncidenteService incidenteService;
	
	private String criterio = "";
	private List<Incidente> incidentes = new ArrayList<Incidente>();
	
	
	
	public void lista (){
		incidentes = incidenteService.busca(null);
	}
	
	public void busca(){
		incidentes = incidenteService.busca(criterio);
		
	}
	
	public List<Incidente> getIncidentes(){
		return incidentes;
	}
	
	public String getCriterio()
	{
		return this.criterio;
	}
	
	public void setCriterio(String criterio)
	{
		this.criterio = criterio;
	}
	

}
