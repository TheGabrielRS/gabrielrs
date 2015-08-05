package br.edu.ifrs.canoas.tads.lds.control.mb;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Id;

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
	private Date criteriodata;
	private List<Incidente> incidentes = new ArrayList<Incidente>();
	
	
	
	public void lista (){
		incidentes = incidenteService.lista();
	}
	
	public void busca(){
		incidentes = incidenteService.busca(criterio);
	}
	
	public void buscaData(){
		incidentes = incidenteService.busca(criteriodata);
		
	}
	
	public void exclui(Incidente inc)
	{
		
		incidenteService.exclui(inc);

	}
	
	public List<Incidente> getIncidentes(){
		return incidentes;
	}
	
	public void setIncidentes(List<Incidente> incidentes) {
		this.incidentes = incidentes;
	}
	
	public String getCriterio()
	{
		return this.criterio;
	}
	
	public void setCriterio(String criterio)
	{
		this.criterio = criterio;
	}
	
	public void setIncidente (Incidente incidente)
	{
		this.incidente = incidente;
	}
	
	public Incidente getIncidente()
	{
		return this.incidente;
	}
	
	public boolean querAlterar()
	{
		return true;
	}

	public Date getCriteriodata() {
		return criteriodata;
	}

	public void setCriteriodata(Date criteriodata) {
		this.criteriodata = criteriodata;
	}
	
}