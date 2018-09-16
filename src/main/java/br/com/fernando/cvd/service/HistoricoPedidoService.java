package br.com.fernando.cvd.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.fernando.cvd.dao.HistoricoPedidoDao;
import br.com.fernando.cvd.model.HistoricoPedido;



public class HistoricoPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private HistoricoPedidoDao historicoPedidoDao;

	
	public void salvar(HistoricoPedido historicoPedido) {
		
		historicoPedidoDao.salvar(historicoPedido);
	}

	
	public void excluir(HistoricoPedido historicoPedido) {
		historicoPedidoDao.excluir(historicoPedido);
	}

	public List<HistoricoPedido> listarTodos() {
		return historicoPedidoDao.listarTodos();
	}
	
	public List<HistoricoPedido> listarTodosPorPedido(Long idPedido) {
		return historicoPedidoDao.listarTodosPorPedido(idPedido);
	}
	
	public HistoricoPedido buscarPorId(Long id) {
		return historicoPedidoDao.buscarPorId(id);
	}

}
