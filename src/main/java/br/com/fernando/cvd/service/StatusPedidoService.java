package br.com.fernando.cvd.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.fernando.cvd.dao.StatusPedidoDao;
import br.com.fernando.cvd.model.StatusPedido;



public class StatusPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private StatusPedidoDao statusPedidoDao;

	
	public void salvar(StatusPedido statusPedido) {
		
		statusPedidoDao.salvar(statusPedido);
	}

	
	public void excluir(StatusPedido statusPedido) {
		statusPedidoDao.excluir(statusPedido);
	}

	public List<StatusPedido> listarTodos() {
		return statusPedidoDao.listarTodos();
	}

	public StatusPedido buscarPorId(Long id) {
		return statusPedidoDao.buscarPorId(id);
	}

}
