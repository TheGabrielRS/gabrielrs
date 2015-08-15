package br.edu.ifrs.canoas.ancient.bean;

import java.io.Serializable;
import java.util.Date;

import br.edu.ifrs.canoas.ancient.bean.Local;
import br.edu.ifrs.canoas.ancient.bean.Equipamento;
import br.edu.ifrs.canoas.ancient.bean.Grupo;

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
	
	private Local local;
	private Equipamento equipamento;
	private Grupo grupo;
	
	

	public Incidente(String titulo, Date data, String descricao, Local local, Equipamento equipamento, Grupo grupo) {
		super();
		this.titulo = titulo;
		this.data = data;
		this.descricao = descricao;
		this.local = local;
		this.equipamento = equipamento;
		this.grupo = grupo;
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

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
