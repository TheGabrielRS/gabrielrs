package br.edu.ifrs.canoas.ancient.model.dao;

import java.util.List;
import br.edu.ifrs.canoas.ancient.bean.Mensagem;
import br.edu.ifrs.canoas.ancient.bean.Usuario;

public class MensagemDAO extends BaseDAO {

	private static final long serialVersionUID = -6243711678958222155L;
	
	@SuppressWarnings("unchecked")
	public List<Mensagem> todas()
	{
		return em.createQuery("SELECT i FROM Mensagem i")
				.getResultList();
	}
}
