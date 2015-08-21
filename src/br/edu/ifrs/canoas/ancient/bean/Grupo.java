package br.edu.ifrs.canoas.ancient.bean;

import java.io.Serializable;

import br.edu.ifrs.canoas.ancient.bean.Usuario;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Grupo extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = 8031013284547191468L;

	@NotNull
	private Usuario gerenciador;
	
	@NotNull @OneToMany
	private List<Usuario> tecnicos;

	public Grupo(Usuario gerenciador, List<Usuario> tecnicos) {
		super();
		this.gerenciador = gerenciador;
		this.tecnicos = tecnicos;
	}
	
	public Grupo()
	{
		super();
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
