package br.com.fernando.cvd.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fernando.cvd.exception.NegocioException;
import br.com.fernando.cvd.model.Promocao;



@Stateless
public class PromocaoDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(name="cvdPU")
	EntityManager manager;

	public Promocao salvar(Promocao promocao) {
		return manager.merge(promocao);
	}
	
	public void excluir(Promocao promocao) {
		try {
			promocao = buscarPorId(promocao.getId());
			manager.remove(promocao);
			
			
		} catch (Exception e) {			
			throw new NegocioException("Promoção não pode ser excluída");
		}
	}

	public Promocao buscarPorId(Long id) {		
		return manager.find(Promocao.class, id);
	}
	
	
	public List<Promocao> listarTodos() {
		List<Promocao> p = new ArrayList<Promocao>();
		try {
			p = (List<Promocao>) manager.createQuery("select p from Promocao p", Promocao.class).getResultList();
		} catch (Exception e) {
			System.out.println("Erro: ");
			e.printStackTrace();
		}
	return p;	
	}
		
}
