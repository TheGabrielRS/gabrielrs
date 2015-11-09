package br.edu.ifrs.canoas.ancient.mb;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.ancient.bean.Grupo;
import br.edu.ifrs.canoas.ancient.bean.Usuario;
import br.edu.ifrs.canoas.ancient.control.service.GrupoService;

@Named
@SessionScoped
public class ManterGrupoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6792673180307873696L;
	
	
	@Inject
	private Grupo grupo;
	
	private List<Grupo> grupos;
	
	private Usuario[] usuarios;
	
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
		System.out.println(grupos.toString());
	}
	
	public void preenche()
	{
		this.grupo.setTecnicos(Arrays.asList(usuarios));
	}
	
	public void salva() {
		preenche();
		if (grupoService.salvaGrupo(this.grupo)){
			grupo = new Grupo();
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Problema", "O incidente não pôde ser salvo!"));
		}	
	}
	
	public Usuario[] getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}

	public String editar(Grupo grupo)
	{
		setGrupo(grupo);
		return "/private/pages/grupo/editarGrupo?faces-redirect=true";
	}
	
	public void salvaEdicao(Usuario usuario)
	{
		grupo.getTecnicos().add(usuario);
		grupoService.editarGrupo(grupo);
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
