package br.com.fernando.cvd.view;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fernando.cvd.model.Produto;
import br.com.fernando.cvd.service.ProdutoService;

@Named
@ViewScoped
public class CadastroProdutoView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Produto produto = new Produto();
	
	private Long idProduto;
	
	@Inject
	private ProdutoService produtoService;
	
	
	public void inicializar() {
		if (idProduto != null) {
			produto = produtoService.buscarPorId(idProduto);
		}
	}
	
	
	public String salvar() {
		produtoService.salvar(produto);
		return "lista-produto.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		produtoService.excluir(produto);
		return "lista-produto.xhtml?faces-redirect=true";
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public Long getIdProduto() {
		return idProduto;
	}


	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

}
