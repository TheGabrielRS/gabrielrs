package br.edu.ifrs.canoas.ancient.mb;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Id;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import br.edu.ifrs.canoas.ancient.bean.Incidente;
import br.edu.ifrs.canoas.ancient.control.service.ManterIncidenteService;

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
	private List<Incidente> incidentes;
	private List<Incidente> incidentesFiltrados;
	
	/*@PostConstruct
	public void init()
	{
		lista();
	}*/
	
	
	public List<Incidente> getIncidentesFiltrados() {
		return incidentesFiltrados;
	}

	public void setIncidentesFiltrados(List<Incidente> incidentesFiltrados) {
		this.incidentesFiltrados = incidentesFiltrados;
	}
	
    public void cancelarEdicao (RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void editarIncidente(CellEditEvent edicao)
	{
		incidenteService.editarIncidente((Incidente) edicao.getNewValue(),(Incidente) edicao.getOldValue());
	}
	
	public void lista (){
		this.incidentes = incidenteService.lista();
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
