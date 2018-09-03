package br.com.fernando.cvd.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fernando.cvd.model.Pedido;
import br.com.fernando.cvd.service.PedidoService;
import br.com.fernando.cvd.util.FacesUtil;


@Named
@ViewScoped
public class ListaPedidoView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PedidoService pedidoService;
	
	private List<Pedido> pedidos = new ArrayList<>();
	
	private List<Pedido> pedidoSelecionados = new ArrayList<>();
	
	
		

	@PostConstruct
	public void inicializar() {
		pedidos = pedidoService.listarTodos();		
	}
	
	public void excluirSelecionados() {
		for (Pedido pedido : pedidoSelecionados) {
			pedidoService.excluir(pedido);
			pedidos.remove(pedido);
		}
		
		FacesUtil.addInfoMessage("Pedido(s) excluído(s) com sucesso!");
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Pedido> getPedidoSelecionados() {
		return pedidoSelecionados;
	}

	public void setPedidoSelecionados(List<Pedido> pedidoSelecionados) {
		this.pedidoSelecionados = pedidoSelecionados;
	}


}
