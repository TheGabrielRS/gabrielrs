package br.edu.ifrs.canoas.ancient.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.edu.ifrs.canoas.ancient.bean.Local;
import br.edu.ifrs.canoas.ancient.bean.Equipamento;
import br.edu.ifrs.canoas.ancient.bean.Grupo;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
	
	
	private Grupo grupo;
	
	private Local local;
	
	//private Requerente requerente;
	
	@OneToMany
	private List<Equipamento> equipamento;
	
	

	public Incidente(String titulo, Date data, String descricao, Grupo grupo, Local local) {
		super();
		this.titulo = titulo;
		this.data = data;
		this.descricao = descricao;
		this.grupo = grupo;
		this.local = local;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public List<Equipamento> getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(List<Equipamento> equipamento) {
		this.equipamento = equipamento;
	}
	
	
}
