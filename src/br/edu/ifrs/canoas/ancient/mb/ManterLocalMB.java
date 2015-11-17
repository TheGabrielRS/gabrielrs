package br.edu.ifrs.canoas.ancient.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.ancient.bean.Local;
import br.edu.ifrs.canoas.ancient.control.service.ManterLocalService;

@Named
@SessionScoped
public class ManterLocalMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2101741115055913170L;
	
	@Inject
	private Local local;
	
	private List<Local> locais;
	
	@Inject
	private ManterLocalService localService;
	
	public void salvar()
	{
		if(localService.salvar(local))
		{
			local = new Local();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sucesso", "Local salvo com sucesso!"));	
		}
		else
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falha", "Local salvo com sucesso!"));
			
	}
	
	@PostConstruct
	public void init()
	{
		lista();
	}
	
	public String editar(Local loc)
	{
		setLocal(loc);
		return "/private/pages/local/editarLocal?faces-redirect=true";
	}
	
	public void salvarEdicao()
	{
		localService.editar(local);
	}
	
	public void lista()
	{
		setLocais(localService.lista());
	}

	public List<Local> getLocais() {
		return localService.lista();
	}

	public void setLocais(List<Local> locais) {
		this.locais = locais;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	
	

}
