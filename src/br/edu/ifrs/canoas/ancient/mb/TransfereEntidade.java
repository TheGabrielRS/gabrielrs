package br.edu.ifrs.canoas.ancient.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class TransfereEntidade implements Serializable {

	private static final long serialVersionUID = -7045067190983497886L;
	
	private Object object;

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
