package br.edu.ifrs.canoas.ancient.bean;

import java.io.Serializable;

import br.edu.ifrs.canoas.ancient.bean.Usuario;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Grupo extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = 8031013284547191468L;

	@NotNull
	private String nome;
	
	@ManyToOne
	private Usuario gerenciador;
	
	@OneToMany
	private List<Usuario> tecnicos;


	
	public Grupo(String nome, Usuario gerenciador, List<Usuario> tecnicos) {
		super();
		this.nome = nome;
		this.gerenciador = gerenciador;
		this.tecnicos = tecnicos;
	}


	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((gerenciador == null) ? 0 : gerenciador.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Grupo other = (Grupo) obj;
		if (gerenciador == null) {
			if (other.gerenciador != null)
				return false;
		} else if (!gerenciador.equals(other.gerenciador))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}





	public Grupo()
	{
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getGerenciador() {
		return gerenciador;
	}

	public void setGerenciador(Usuario gerenciador) {
		this.gerenciador = gerenciador;
	}

	public List<Usuario> getTecnicos() {
		return tecnicos;
	}

	public void setTecnicos(List<Usuario> tecnicos) {
		this.tecnicos = tecnicos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
