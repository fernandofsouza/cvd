package br.com.fernando.cvd.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fernando.cvd.model.Produto;
import br.com.fernando.cvd.service.ProdutoService;
import br.com.fernando.cvd.util.FacesUtil;


@Named
@ViewScoped
public class ListaProdutoView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProdutoService produtoService;
	
	private List<Produto> produtos = new ArrayList<>();
	
	
	private List<Produto> produtosSelecionados = new ArrayList<>();
	
		

	@PostConstruct
	public void inicializar() {
		produtos = produtoService.listarTodos();		
	}
	
	public void excluirSelecionados() {
		for (Produto produto : produtosSelecionados) {
			produtoService.excluir(produto);
			produtos.remove(produto);
		}
		
		FacesUtil.addInfoMessage("Produto(s) excluído(s) com sucesso!");
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


}
