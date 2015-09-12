package br.edu.ifrs.canoas.ancient.mb;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.ancient.bean.Grupo;
import br.edu.ifrs.canoas.ancient.bean.Incidente;
import br.edu.ifrs.canoas.ancient.control.service.GrupoService;

@Named
@RequestScoped
public class GrupoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6792673180307873696L;
	
	
	@Inject
	private Grupo grupo;
	
	private List<Grupo> grupos = new ArrayList<Grupo>();
	
	@Inject
	private GrupoService grupoService;
	
	public void lista()
	{
		setGrupos(grupoService.listaGrupo());	
	}
	
	@PostConstruct
	public void init()
	{
		lista();
	}
	
	public void salva() {
		if (grupoService.salvaGrupo(this.grupo)){
			grupo = new Grupo();
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Problema", "O incidente não pôde ser salvo!"));
		}	
	}
	
	
	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public GrupoService getGrupoService() {
		return grupoService;
	}

	public void setGrupoService(GrupoService grupoService) {
		this.grupoService = grupoService;
	}
	
	

}
