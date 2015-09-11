package br.edu.ifrs.canoas.ancient.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
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
	
	private Local local;
	
	private ManterLocalService localService;
	
	public void salvar()
	{
		localService.salvar(this.local);
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	
	

}
