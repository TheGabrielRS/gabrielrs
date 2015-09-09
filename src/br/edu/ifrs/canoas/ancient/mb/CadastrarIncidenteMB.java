package br.edu.ifrs.canoas.ancient.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.edu.ifrs.canoas.ancient.bean.Incidente;
import br.edu.ifrs.canoas.ancient.control.service.ManterIncidenteService;



@Named
@SessionScoped
public class CadastrarIncidenteMB implements Serializable {

	private static final long serialVersionUID = -3322293812769985007L;


	@Inject
	private Incidente incidente;

	@Inject
	private ManterIncidenteService incidenteService;
	
	public void salva() {
		if (incidenteService.salvaIncidente(incidente)){
			incidente = new Incidente();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sucesso", "Incidente salvo com sucesso!"));
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Problema", "O incidente não pôde ser salvo!"));
		}	
	}
	

	public Incidente getIncidente() {
		return incidente;
	}

	public void setIncidente(Incidente incidente) {
		this.incidente = incidente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
