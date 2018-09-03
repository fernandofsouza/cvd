package br.com.fernando.cvd.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.fernando.cvd.dao.ItemPedidoDao;
import br.com.fernando.cvd.model.ItemPedido;



public class ItemPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ItemPedidoDao itemPedidoDao;

	
	public void salvar(ItemPedido itemPedido) {
		
		itemPedidoDao.salvar(itemPedido);
	}

	
	public void excluir(ItemPedido itemPedido) {
		itemPedidoDao.excluir(itemPedido);
	}

	public List<ItemPedido> listarTodos() {
		return itemPedidoDao.listarTodos();
	}

	public ItemPedido buscarPorId(Long id) {
		return itemPedidoDao.buscarPorId(id);
	}

}
