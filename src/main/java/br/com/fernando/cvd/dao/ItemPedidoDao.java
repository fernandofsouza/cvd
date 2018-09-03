package br.com.fernando.cvd.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fernando.cvd.exception.NegocioException;
import br.com.fernando.cvd.model.ItemPedido;



@Stateless
public class ItemPedidoDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(name="cvdPU")
	EntityManager manager;

	public ItemPedido salvar(ItemPedido itemPedido) {
		return manager.merge(itemPedido);
	}
	
	public void excluir(ItemPedido itemPedido) {
		try {
			itemPedido = buscarPorId(itemPedido.getId());
			manager.remove(itemPedido);
			
			
		} catch (Exception e) {			
			throw new NegocioException("ItemPedido não pode ser excluído");
		}
	}

	public ItemPedido buscarPorId(Long id) {		
		return manager.find(ItemPedido.class, id);
	}
	
	public List<ItemPedido> listarTodos() {
		List<ItemPedido>i = new ArrayList<ItemPedido>();
		try {
			i = (List<ItemPedido>) manager.createQuery("Select i FROM ItemPedido i", ItemPedido.class).getResultList();
		} catch (Exception e) {
			System.out.println("Erro: ");
			e.printStackTrace();
		}
	return i;	
	}
		
}
