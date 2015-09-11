package br.edu.ifrs.canoas.ancient.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Local extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = 3285913336915209175L;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String endereco;

	public Local(String nome, String endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public Local()
	{
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
