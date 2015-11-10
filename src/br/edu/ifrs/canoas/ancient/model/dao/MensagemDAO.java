package br.edu.ifrs.canoas.ancient.model.dao;

import java.util.List;
import br.edu.ifrs.canoas.ancient.bean.Mensagem;
import br.edu.ifrs.canoas.ancient.bean.Usuario;

public class MensagemDAO extends BaseDAO {

	private static final long serialVersionUID = -6243711678958222155L;
	
	public List<Mensagem> mensagensUsuario(Usuario usuario)
	{
		return em.createQuery("Select i from Mensagem i WHERE i.destinatario = :usuario")
		.setParameter("usuario", usuario)
		.getResultList();
	}

}
