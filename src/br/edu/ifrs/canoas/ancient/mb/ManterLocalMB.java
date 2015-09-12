package br.edu.ifrs.canoas.ancient.mb;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.ancient.bean.Local;
import br.edu.ifrs.canoas.ancient.control.service.ManterLocalService;

@Named
@RequestScoped
public class ManterLocalMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2101741115055913170L;
	
	@Inject
	private Local local;
	
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

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	
	

}
