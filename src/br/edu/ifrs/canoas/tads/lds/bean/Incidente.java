package br.edu.ifrs.canoas.tads.lds.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Incidente extends BaseEntity<Long> implements Serializable {


	private static final long serialVersionUID = 3362575553670210754L;

	@NotNull
	private String titulo;
	
	@NotNull
	private Date data;
	
	@NotNull
	private String descricao;
	
	public Incidente(String titulo, Date data, String descricao)
	{
		super();
		this.titulo = titulo;
		this.data = data;
		this.descricao = descricao;
	}

	public Incidente() {
		super();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
