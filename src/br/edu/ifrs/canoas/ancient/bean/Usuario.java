package br.edu.ifrs.canoas.ancient.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
public class Usuario extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = 6262524988798723388L;

	@NotNull @Email 
	private String email;
	
	@NotNull
	private String senha;
	
	@NotNull
	private String nome;
	
	@NotNull 
	private String sobrenome;
	
	public Usuario() {
		super();
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
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
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}




	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	
}
