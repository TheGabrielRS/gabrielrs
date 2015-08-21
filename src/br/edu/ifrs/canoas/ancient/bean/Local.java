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
	
	@NotNull
	private long coordy;
	
	@NotNull
	private long coordx;

	public Local(String nome, String endereco, long coordy, long coordx) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.coordy = coordy;
		this.coordx = coordx;
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

	public long getCoordy() {
		return coordy;
	}

	public void setCoordy(long coordy) {
		this.coordy = coordy;
	}

	public long getCoordx() {
		return coordx;
	}

	public void setCoordx(long coordx) {
		this.coordx = coordx;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
