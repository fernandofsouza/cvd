package br.com.fernando.cvd.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fernando.cvd.model.ItemPedido;
import br.com.fernando.cvd.model.Pedido;
import br.com.fernando.cvd.model.Produto;
import br.com.fernando.cvd.model.Usuario;
import br.com.fernando.cvd.service.PedidoService;
import br.com.fernando.cvd.service.ProdutoService;
import br.com.fernando.cvd.service.UsuarioService;

@Named
@ViewScoped
public class CadastroPedidoView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PedidoService pedidoService;
	@Inject
	private ProdutoService produtoService;
	@Inject
	private UsuarioService usuarioService;
	
	private Pedido pedido = new Pedido();
	
	private Long idPedido;
	
	private Double quantidade;
	
	private Long idProduto;
	
	private Produto produto;
	
	private ItemPedido item = new ItemPedido();
	
	private Usuario usuario = new Usuario();
	
	private List<Pedido> pedidos = new ArrayList<>();

	private List<ItemPedido> itensSelecionados = new ArrayList<>();
		
	private List<ItemPedido> itens = new ArrayList<>();
	
	@PostConstruct
	public void inicializar() {
		if (idProduto != null) {
			produto = produtoService.buscarPorId(idProduto);
			System.out.println("Produto_inicializar######: "+produto.getNome());
			
		}
		usuario = usuarioService.buscarPorId(1L);
		preencherPedido();
		
	}
	
	public void preencherPedido(){
		
		item.setProduto(produto);
		item.setQuantidade(quantidade);
		itens.add(item);
		pedido.setDataPedido(new Date());
		pedido.setItemPedido(itens);
		pedido.setUsuario(usuario);
		pedido.setNumeroPedido(produto.getId()+1000L);
		System.out.println("num_pedido: #######"+pedido.getNumeroPedido());
	
		System.out.println("Itens ########"+pedido.getItemPedido().size());
	}
	public String salvar() {
		
		pedidoService.salvar(pedido);
		return "lista-pedido.xhtml?faces-redirect=true";
	}
	
		
	public void limparItens(){
		itens = new ArrayList<>();
		System.out.println("limpando Itens...");
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
	
}
