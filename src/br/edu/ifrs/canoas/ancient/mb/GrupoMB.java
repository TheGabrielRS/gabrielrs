package br.edu.ifrs.canoas.ancient.mb;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.ancient.bean.Grupo;
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
	
	private GrupoService grupoService;
	
	@PostConstruct
	public void lista()
	{
		setGrupos(grupoService.listaGrupo());	
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

}
