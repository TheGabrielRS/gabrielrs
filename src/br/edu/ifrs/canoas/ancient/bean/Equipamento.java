package br.edu.ifrs.canoas.ancient.bean;

import java.io.Serializable;

import br.edu.ifrs.canoas.ancient.bean.Local;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Equipamento extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = -4019429343394370938L;
	
	@NotNull
	private String tombo;
	
	@NotNull
	@ManyToOne
	private Local local;
	
	@NotNull
	private String descricao;

	public Equipamento(String tombo, Local local, String descricao) {
		super();
		this.tombo = tombo;
		this.local = local;
		this.descricao = descricao;
	}
	
	public Equipamento()
	{
		super();
	}

	public String getTombo() {
		return tombo;
	}

	public void setTombo(String tombo) {
		this.tombo = tombo;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
