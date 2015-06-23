package br.edu.ifrs.canoas.tads.lds.control.mb;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.tads.lds.bean.Incidente;
import br.edu.ifrs.canoas.tads.lds.control.service.ManterIncidenteService;


@Named
@SessionScoped
public class CadastrarIncidenteMB implements Serializable {

	private static final long serialVersionUID = -3322293812769985007L;


	@Inject
	private Incidente incidente;

	@Inject
	private ManterIncidenteService incidenteService;
	
	public String salva() {
		if (incidenteService.salvaIncidente(incidente)){
			incidente = new Incidente();
			return "manterIncidente";
		}
		return "login";
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