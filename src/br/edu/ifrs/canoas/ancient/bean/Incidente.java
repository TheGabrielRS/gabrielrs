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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
}
