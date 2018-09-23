package br.com.fernando.cvd.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.fernando.cvd.dao.PedidoDao;
import br.com.fernando.cvd.dao.StatusPedidoDao;
import br.com.fernando.cvd.model.Pedido;
import br.com.fernando.cvd.model.StatusPedido;
import br.com.fernando.cvd.model.Usuario;



public class PedidoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private PedidoDao pedidoDao;
	
	@EJB
	private StatusPedidoDao statusPedidoDao;
	
	private Pedido pedido = new Pedido();
	
	private StatusPedido statusPedido = new StatusPedido();
	
	public Pedido salvar(Pedido pedido) {
		
		return pedidoDao.salvar(pedido);
	}

	
	public void excluir(Pedido pedido) {
		pedidoDao.excluir(pedido);
	}

	public List<Pedido> listarTodos() {
		return pedidoDao.listarTodos();
	}
	public List<Pedido> listarTodosPorUsuario(Usuario usuario){
		return pedidoDao.listarTodosPorUsuario(usuario.getId());
	}
	
	public Pedido buscarPorId(Long id) {
		return pedidoDao.buscarPorId(id);
	}
	public void alterarStatus(Pedido pedido, Long idStatus){
		this.pedido = buscarPorId(pedido.getId());
		this.statusPedido = statusPedidoDao.buscarPorId(idStatus);
		this.pedido.setStatusPedido(statusPedido);
		salvar(this.pedido);
	}
	public void cancelarPedido(Pedido pedido){
		alterarStatus(pedido, StatusPedido.STATUS_CANCELADO);
	}
	public void faturarPedido(Pedido pedido){
		alterarStatus(pedido, StatusPedido.STATUS_FATURADO);
	}
	public void prepararPedido(Pedido pedido){
		alterarStatus(pedido, StatusPedido.STATUS_PREPARADO);
	}
	public void enviarPedido(Pedido pedido){
		alterarStatus(pedido, StatusPedido.STATUS_ENVIADO);
	}
	public void emTransitoPedido(Pedido pedido){
		alterarStatus(pedido, StatusPedido.STATUS_EM_TRANSITO);
	}
	public void entregarPedido(Pedido pedido){
		alterarStatus(pedido, StatusPedido.STATUS_ENTREGUE);
	}
	public void devolverPedido(Pedido pedido){
		alterarStatus(pedido, StatusPedido.STATUS_DEVOLVIDO);
	}
	public void excluirPedido(Pedido pedido){
		alterarStatus(pedido, StatusPedido.STATUS_EXCLUIDO);
	}
	public void extraviadoPedido(Pedido pedido){
		alterarStatus(pedido, StatusPedido.STATUS_EXTRAVIADO);
	}
	
	
}
