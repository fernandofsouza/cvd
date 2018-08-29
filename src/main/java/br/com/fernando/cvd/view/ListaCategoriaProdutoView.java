package br.com.fernando.cvd.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fernando.cvd.model.CategoriaProduto;
import br.com.fernando.cvd.service.CategoriaProdutoService;
import br.com.fernando.cvd.util.FacesUtil;


@Named
@ViewScoped
public class ListaCategoriaProdutoView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaProdutoService categoriaProdutoService;
	
	private List<CategoriaProduto> categoriasProduto = new ArrayList<>();
	
	private List<CategoriaProduto> categoriasProdutoSelecionados = new ArrayList<>();
	
	

	@PostConstruct
	public void inicializar() {
		categoriasProduto = categoriaProdutoService.listarTodos();		
	}
	
	public void excluirSelecionados() {
		for (CategoriaProduto categoriaProduto : categoriasProdutoSelecionados) {
			categoriaProdutoService.excluir(categoriaProduto);
			categoriasProduto.remove(categoriaProduto);
		}
		
		FacesUtil.addInfoMessage("Categoria(s) excluída(s) com sucesso!");
	}

	public List<CategoriaProduto> getCategoriaProdutos() {
		return categoriasProduto;
	}

	public void setCategoriaProdutos(List<CategoriaProduto> categoriasProduto) {
		this.categoriasProduto = categoriasProduto;
	}

	public List<CategoriaProduto> getCategoriaProdutoSelecionados() {
		return categoriasProdutoSelecionados;
	}

	public void setCategoriaProdutoSelecionados(List<CategoriaProduto> categoriasProdutoSelecionados) {
		this.categoriasProdutoSelecionados = categoriasProdutoSelecionados;
	}


}
