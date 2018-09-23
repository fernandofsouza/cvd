package br.com.fernando.cvd.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fernando.cvd.model.Pedido;
import br.com.fernando.cvd.model.StatusPedido;
import br.com.fernando.cvd.service.PedidoService;
import br.com.fernando.cvd.service.StatusPedidoService;

@Named
@ViewScoped
public class CadastroStatusPedidoView implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pedido pedido = new Pedido();

	private List<StatusPedido> listaStatusPedido = new ArrayList<>();

	private StatusPedido statusPedido = new StatusPedido();
	private StatusPedido statusPedidoSelecionado = new StatusPedido();

	private Long idPedido;

	@Inject
	private PedidoService pedidoService;

	@Inject
	private StatusPedidoService statusPedidoService;

	public void inicializar() {
		if (idPedido != null) {
			pedido = pedidoService.buscarPorId(idPedido);
			System.out.println("Id do Pedido eh: " + idPedido);
		}
		this.listaStatusPedido = statusPedidoService.listarTodos();
	}

	public String salvar() {
		pedidoService.salvar(pedido);
		return "lista-status-pedido.xhtml?faces-redirect=true";
	}

	public String excluir() {
		pedidoService.excluir(pedido);
		return "lista-status-pedido.xhtml?faces-redirect=true";
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public List<StatusPedido> getListaStatusPedido() {
		return listaStatusPedido;
	}

	public void setListaStatusPedido(List<StatusPedido> listaStatusPedido) {
		this.listaStatusPedido = listaStatusPedido;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public StatusPedido getStatusPedidoSelecionado() {
		return statusPedidoSelecionado;
	}

	public void setStatusPedidoSelecionado(StatusPedido statusPedidoSelecionado) {
		this.statusPedidoSelecionado = statusPedidoSelecionado;
	}

}
