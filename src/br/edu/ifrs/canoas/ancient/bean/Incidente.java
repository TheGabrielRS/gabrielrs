package br.edu.ifrs.canoas.ancient.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.edu.ifrs.canoas.ancient.bean.Local;
import br.edu.ifrs.canoas.ancient.bean.Equipamento;
import br.edu.ifrs.canoas.ancient.bean.Grupo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@ManyToOne
	private Grupo grupo;
	
	@ManyToOne
	private Local local;
	
	//private Requerente requerente;
	
	@ManyToOne
	private Equipamento equipamento;

	public Incidente(String titulo, Date data, String descricao, Grupo grupo, Local local, Equipamento equipamento) {
		super();
		this.titulo = titulo;
		this.data = data;
		this.descricao = descricao;
		this.grupo = grupo;
		this.local = local;
		this.equipamento= equipamento;
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

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Incidente other = (Incidente) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}
	
	
	
	
}
