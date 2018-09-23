package br.com.fernando.cvd.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fernando.cvd.exception.NegocioException;
import br.com.fernando.cvd.model.StatusPedido;



@Stateless
public class StatusPedidoDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(name="cvdPU")
	EntityManager manager;

	public StatusPedido salvar(StatusPedido statusPedido) {
		return manager.merge(statusPedido);
	}
	
	public void excluir(StatusPedido statusPedido) {
		try {
			statusPedido = buscarPorId(statusPedido.getId());
			manager.remove(statusPedido);
			
			
		} catch (Exception e) {			
			throw new NegocioException("Status Pedido não pode ser excluído");
		}
	}

	public StatusPedido buscarPorId(Long id) {		
		return manager.find(StatusPedido.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<StatusPedido> listarTodos() {
		List<StatusPedido> s = new ArrayList<StatusPedido>();
		try {
			s = (List<StatusPedido>) manager.createNativeQuery("Select * from status_pedido", StatusPedido.class).getResultList();
		} catch (Exception e) {
			System.out.println("Erro: ");
			e.printStackTrace();
		}
	return s;	
	}
		
}
