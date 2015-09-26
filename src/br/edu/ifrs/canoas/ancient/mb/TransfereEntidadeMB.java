package br.edu.ifrs.canoas.ancient.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;
import javax.inject.Named;

import br.edu.ifrs.canoas.ancient.bean.Incidente;

@Named
@SessionScoped
public class TransfereEntidadeMB implements Serializable {

	private static final long serialVersionUID = -7045067190983497886L;
	
	private Object object;

	public TransfereEntidadeMB() {
		super();
	}
	
	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
	public void init()
	{
		
	}
	

}
