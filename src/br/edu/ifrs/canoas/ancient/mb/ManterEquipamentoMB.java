package br.edu.ifrs.canoas.ancient.mb;


import java.io.Serializable;
import java.util.List;

import br.edu.ifrs.canoas.ancient.bean.Equipamento;
import br.edu.ifrs.canoas.ancient.control.service.ManterEquipamentoService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ManterEquipamentoMB implements Serializable {

	private static final long serialVersionUID = -7191024656989095264L;
	
	@Inject
	private Equipamento equipamento;
	
	private List<Equipamento> equipamentos;
	
	@PostConstruct
	public void init()
	{
		listaTodos();
	}
	
	
	@Inject
	private ManterEquipamentoService equipamentoService;
	
	public String editar (Equipamento equ)
	{
		setEquipamento(equ);
		return "/private/pages/equipamento/editarEquipamento?faces-redirect=true";
	}
	
	public void salvaEdicao ()
	{
		equipamentoService.edita(equipamento);
	}
	
	public void listaTodos()
	{
		setEquipamentos(equipamentoService.listaTodos());
	}
	
	public void remove()
	{
		equipamentoService.remove(equipamento);
	}
	
	
	public void salva()
	{
		equipamentoService.salva(equipamento);
		this.equipamento = new Equipamento();
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}
}

