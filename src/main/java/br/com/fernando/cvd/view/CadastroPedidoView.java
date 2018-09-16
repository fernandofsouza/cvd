package br.com.fernando.cvd.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fernando.cvd.model.HistoricoPedido;
import br.com.fernando.cvd.model.ItemPedido;
import br.com.fernando.cvd.model.Pedido;
import br.com.fernando.cvd.model.Produto;
import br.com.fernando.cvd.model.Promocao;
import br.com.fernando.cvd.model.StatusPedido;
import br.com.fernando.cvd.model.TipoPagamento;
import br.com.fernando.cvd.model.Usuario;
import br.com.fernando.cvd.service.HistoricoPedidoService;
import br.com.fernando.cvd.service.PedidoService;
import br.com.fernando.cvd.service.ProdutoService;
import br.com.fernando.cvd.service.PromocaoService;
import br.com.fernando.cvd.service.StatusPedidoService;
import br.com.fernando.cvd.service.TipoPagamentoService;
import br.com.fernando.cvd.service.UsuarioService;
import br.com.fernando.cvd.util.FacesUtil;

@Named
@SessionScoped
public class CadastroPedidoView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PedidoService pedidoService;
	@Inject
	private ProdutoService produtoService;
	@Inject
	private UsuarioService usuarioService;
	@Inject
	private TipoPagamentoService tipoPagamentoService;
	@Inject
	private StatusPedidoService statusPedidoService;
	@Inject
	private PromocaoService promocaoService;
	@Inject
	private HistoricoPedidoService historicoPedidoService;
	
	
	private Pedido pedido = new Pedido();

	private Long idPedido;

	private Double quantidade = new Double(1);

	private Long idProduto;

	private Produto produto = new Produto();

	private ItemPedido item = new ItemPedido();

	private Usuario usuario = new Usuario();
	
	private HistoricoPedido historicoPedido = new HistoricoPedido();
	
	private StatusPedido statusPedido = new StatusPedido();

	private Promocao promocao;
	
	private List<Pedido> pedidos = new ArrayList<>();

	private List<ItemPedido> itensSelecionados = new ArrayList<>();

	private List<ItemPedido> itens = new ArrayList<>();
	
	private List<TipoPagamento> tiposPagamento = new ArrayList<>();

	@PostConstruct
	public void inicializar() {
		System.out.println("##### Inicializou CadastroPedidoView ######");
		if (idProduto != null) {
			System.out.println("idProduto antes de buscar no banco: " + idProduto);
			produto = produtoService.buscarPorId(idProduto);
			System.out.println("Produto_inicializar: " + produto.getDescricao());
			usuario = usuarioService.buscarPorId(1L);
			adicionarItem();
		}
		tiposPagamento = tipoPagamentoService.listarTodos();
		statusPedido = statusPedidoService.buscarPorId(StatusPedido.STATUS_ABERTO);
		//promocao default 1 - nenhuma
		promocao = promocaoService.buscarPorId(1l);
	}

	@PreDestroy
	public void finalizar() {
		System.out.println("### Encerrou CadastroPedidoView ###");
	}

	public void preencherPedido() {
		//adicionarItem();
		// pedido
		pedido.setDataPedido(new Date());
		pedido.setItemPedido(itens);
		pedido.setTotal(calculaValorPedido(itens));
		pedido.setUsuario(usuario);
		System.out.println("Id do produto: " + produto.getId());
		pedido.setPromocao(promocao);
		pedido.setStatusPedido(statusPedido);
		pedido.setVendedor(usuario);
		pedido.setNumeroPedido(new Date().getTime()+1000L+usuario.getId());
		System.out.println("num_pedido: " + pedido.getNumeroPedido());
		System.out.println("Itens: " + pedido.getItemPedido().size());
	}

	public void adicionarItem() {
		// itens
		item.setProduto(produto);
		item.setQuantidade(quantidade);
		System.out.println("item quantidade: " + quantidade);
		item.setPrecoUnitario(produto.getPrecoUnitario());
		itens.add(item);
		item = new ItemPedido();
	}

	public String salvar() {
		System.out.println("Itens comprados "+itens.size());
		preencherPedido();
		System.out.println("itens no pedido: "+pedido.getItemPedido().size());
		System.out.println("valor total pedido: "+pedido.getTotal());
		System.out.println("tipo Pagamento selecionado: "+pedido.getTipoPagamento().getDescricao());
		this.pedido = pedidoService.salvar(pedido);
		System.out.println(pedido.getNumeroPedido());
		incluiStatus();
		limpar();
		return "lista-pedido.xhtml?faces-redirect=true";
	}
	public void incluiStatus(){
		historicoPedido.setDataStatus(new Date());
		historicoPedido.setPedido(pedido);
		historicoPedido.setStatusPedido(statusPedido);
		historicoPedidoService.salvar(historicoPedido);
	}
	
	public String limparItens() {
		for (ItemPedido i : itensSelecionados) {
			itens.remove(i);
		}
		System.out.println("limpando Itens...");
		FacesUtil.addInfoMessage("Item(ns) excluído(s) com sucesso!");
		idProduto = null;
		return "cadastro-pedido.xhtml?faces-redirect=true";
	}
	
	public Double calculaValorPedido(List<ItemPedido> itens) {
		Double soma = new Double(0);
		Double frete = new Double(0);
		for (ItemPedido i : itens) {
			soma += i.getProduto().getPrecoUnitario();
		}
		System.out.println("total pedido: " + (soma + frete));
		return soma + frete;
	}
	public void limpar(){
		pedido = new Pedido();
		itens = new ArrayList<>();
	}
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public List<ItemPedido> getItensSelecionados() {
		return itensSelecionados;
	}

	public void setItensSelecionados(List<ItemPedido> itensSelecionados) {
		this.itensSelecionados = itensSelecionados;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ItemPedido getItem() {
		return item;
	}

	public void setItem(ItemPedido item) {
		this.item = item;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<TipoPagamento> getTiposPagamento() {
		return tiposPagamento;
	}

	public void setTiposPagamento(List<TipoPagamento> tiposPagamento) {
		this.tiposPagamento = tiposPagamento;
	}

	public Promocao getPromocao() {
		return promocao;
	}

	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

}
