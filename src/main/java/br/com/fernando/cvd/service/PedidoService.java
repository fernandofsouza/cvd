package br.com.fernando.cvd.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.fernando.cvd.dao.PedidoDao;
import br.com.fernando.cvd.model.Pedido;



public class PedidoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private PedidoDao pedidoDao;

	
	public void salvar(Pedido pedido) {
		
		pedidoDao.salvar(pedido);
	}

	
	public void excluir(Pedido pedido) {
		pedidoDao.excluir(pedido);
	}

	public List<Pedido> listarTodos() {
		return pedidoDao.listarTodos();
	}

	public Pedido buscarPorId(Long id) {
		return pedidoDao.buscarPorId(id);
	}

}
