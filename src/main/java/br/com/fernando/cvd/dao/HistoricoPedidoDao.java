package br.com.fernando.cvd.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fernando.cvd.exception.NegocioException;
import br.com.fernando.cvd.model.HistoricoPedido;



@Stateless
public class HistoricoPedidoDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(name="cvdPU")
	EntityManager manager;

	public HistoricoPedido salvar(HistoricoPedido historicoPedido) {
		return manager.merge(historicoPedido);
	}
	
	public void excluir(HistoricoPedido historicoPedido) {
		try {
			historicoPedido = buscarPorId(historicoPedido.getId());
			manager.remove(historicoPedido);
			
			
		} catch (Exception e) {			
			throw new NegocioException("Histórico pedido não pode ser excluído");
		}
	}

	public HistoricoPedido buscarPorId(Long id) {		
		return manager.find(HistoricoPedido.class, id);
	}
	
		
	public List<HistoricoPedido> listarTodos() {
		List<HistoricoPedido> h = new ArrayList<HistoricoPedido>();
		try {
			h = (List<HistoricoPedido>) manager.createQuery("Select h FROM HistoricoPedido h", HistoricoPedido.class).getResultList();
		} catch (Exception e) {
			System.out.println("Erro: ");
			e.printStackTrace();
		}
	return h;	
	}
	
	public List<HistoricoPedido> listarTodosPorPedido(Long idPedido) {
		List<HistoricoPedido> h = new ArrayList<HistoricoPedido>();
		try {
			h = (List<HistoricoPedido>) manager.createQuery("Select h FROM HistoricoPedido h where h.pedido.id = :idPedido", HistoricoPedido.class)
					.setParameter("idPedido", idPedido)
					.getResultList();
		} catch (Exception e) {
			System.out.println("Erro: ");
			e.printStackTrace();
		}
	return h;	
	}
		
}
