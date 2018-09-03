package br.com.fernando.cvd.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fernando.cvd.exception.NegocioException;
import br.com.fernando.cvd.model.Pedido;



@Stateless
public class PedidoDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(name="cvdPU")
	EntityManager manager;

	public Pedido salvar(Pedido pedido) {
		return manager.merge(pedido);
	}
	
	public void excluir(Pedido pedido) {
		try {
			pedido = buscarPorId(pedido.getId());
			manager.remove(pedido);
			
			
		} catch (Exception e) {			
			throw new NegocioException("Pedido não pode ser excluído");
		}
	}

	public Pedido buscarPorId(Long id) {		
		return manager.find(Pedido.class, id);
	}
	
	public List<Pedido> listarTodos() {
		List<Pedido>p = new ArrayList<Pedido>();
		try {
			p = (List<Pedido>) manager.createQuery("Select p FROM Pedido p", Pedido.class).getResultList();
		} catch (Exception e) {
			System.out.println("Erro: ");
			e.printStackTrace();
		}
	return p;	
	}
		
}
