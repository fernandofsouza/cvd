package br.com.fernando.cvd.view;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.fernando.cvd.model.Produto;
import br.com.fernando.cvd.service.ProdutoService;
import br.com.fernando.cvd.util.FacesUtil;

@Named
@ApplicationScoped
public class ProdutosVendaView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoService produtoService;

	private List<Produto> produtos = new ArrayList<>();

	private List<Produto> produtosSelecionados = new ArrayList<>();

	private Produto produto = new Produto();
	

	@PostConstruct
	public void inicializar() {
		produtos = produtoService.listarTodos();
		produto = produtoService.buscarPorId(new Long(17));
		System.out.println("Produtos: " + produto.getNome());
		

	}
	
	public StreamedContent getImagem() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the HTML. Return a stub StreamedContent so
			// that it will generate right URL.
			return new DefaultStreamedContent();
		} else {
			// So, browser is requesting the image. Return a real
			// StreamedContent with the image bytes.
			String produtoId = context.getExternalContext().getRequestParameterMap().get("produtoId");
			Produto produto = produtoService.buscarPorId(Long.valueOf(produtoId));
			System.out.println("produtoId: "+produtoId);
			System.out.println("imagem: "+produto.getImagens().get(0).getNome());
			System.out.println("blob :"+produto.getImagens().get(0).getImagem() );
			return new DefaultStreamedContent(new ByteArrayInputStream(produto.getImagens().get(0).getImagem()),"image/jpg");
		}
	}
	
	
	public void excluirSelecionados() {
		for (Produto produto : produtosSelecionados) {
			produtos.remove(produto);
		}

		FacesUtil.addInfoMessage("Produto(s) excluído(s) do carrinho com sucesso!");
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Produto> getProdutosSelecionados() {
		return produtosSelecionados;
	}

	public void setProdutosSelecionados(List<Produto> produtosSelecionados) {
		this.produtosSelecionados = produtosSelecionados;
	}

	public List<Produto> getProdutoes() {
		return produtos;
	}

	public void setProdutoes(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Produto> getProdutoSelecionados() {
		return produtosSelecionados;
	}

	public void setProdutoSelecionados(List<Produto> produtosSelecionados) {
		this.produtosSelecionados = produtosSelecionados;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	}
