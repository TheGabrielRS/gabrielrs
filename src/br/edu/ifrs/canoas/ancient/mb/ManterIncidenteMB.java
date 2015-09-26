package br.edu.ifrs.canoas.ancient.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


import br.edu.ifrs.canoas.ancient.bean.Incidente;
import br.edu.ifrs.canoas.ancient.control.service.ManterIncidenteService;

@Named
@ViewScoped
public class ManterIncidenteMB implements Serializable{

	private static final long serialVersionUID = -5481426310511396058L;
	
	@Inject
	private Incidente incidente;
	
	@EJB
	private ManterIncidenteService incidenteService;
	
	private List<Incidente> incidentes;
	private List<Incidente> incidentesFiltrados;
	
	@ManagedProperty(value = "#{transfereEntidade}")
	private TransfereEntidadeMB transfereEntidade;
	
	
	@PostConstruct
	public void init()
	{
		if(transfereEntidade != null && transfereEntidade.getObject()!=null && transfereEntidade.getObject() instanceof Incidente)
		{
			setIncidente((Incidente)transfereEntidade.getObject());
			transfereEntidade.setObject(null);
		}
		lista();
	}
	
	@PreDestroy
	public void finish()
	{
		System.out.println("Destruiu ManterIncidenteMB");
	}
	
	public String editar(Incidente inc)
	{
		setIncidente(inc);
		transfereEntidade.setObject(this.incidente);
		return "/private/pages/incidente/editarIncidente?faces-redirect=true";
	}
	
	public void salvarEdicao()
	{
		incidenteService.editarIncidente(incidente);
	}
	
	
	public List<Incidente> getIncidentesFiltrados() {
		return incidentesFiltrados;
	}

	public void setIncidentesFiltrados(List<Incidente> incidentesFiltrados) {
		this.incidentesFiltrados = incidentesFiltrados;
	}
	
	public void lista (){
		setIncidentes(incidenteService.lista());
	}

	public void exclui(Incidente inc)
	{
		
		incidenteService.exclui(inc);

	}
	
	public List<Incidente> getIncidentes(){
		incidentes = incidenteService.lista();
		return incidentes;
	}
	
	public void setIncidentes(List<Incidente> incidentes) {
		this.incidentes = incidentes;
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
}
