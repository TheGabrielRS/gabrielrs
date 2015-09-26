package br.edu.ifrs.canoas.ancient.bean;

import java.io.Serializable;
import java.util.List;

import br.edu.ifrs.canoas.ancient.bean.Local;
import br.edu.ifrs.canoas.ancient.bean.Equipamento;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Requerente extends BaseEntity<Long> implements Serializable{
	
	private static final long serialVersionUID = 6599659774611732286L;
	
	@NotNull
	private String nome;
	
	@ManyToOne
	private Local local;
	
	@OneToMany
	private List<Equipamento> equipamento;

}
