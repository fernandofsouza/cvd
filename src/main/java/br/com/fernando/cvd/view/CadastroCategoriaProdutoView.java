package br.com.fernando.cvd.view;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fernando.cvd.model.CategoriaProduto;
import br.com.fernando.cvd.service.CategoriaProdutoService;

@Named
@ViewScoped
public class CadastroCategoriaProdutoView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private CategoriaProduto categoriaProduto = new CategoriaProduto();
	
	private Long idCategoriaProduto;
	
	@Inject
	private CategoriaProdutoService categoriaProdutoService;
	
	
	public void inicializar() {
		if (idCategoriaProduto != null) {
			categoriaProduto = categoriaProdutoService.buscarPorId(idCategoriaProduto);
		}
	}
	
	
	public String salvar() {
		categoriaProdutoService.salvar(categoriaProduto);
		return "lista-categoria-produto.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		categoriaProdutoService.excluir(categoriaProduto);
		return "lista-categoria-produto.xhtml?faces-redirect=true";
	}


	public CategoriaProduto getCategoriaProduto() {
		return categoriaProduto;
	}


	public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}


	public Long getIdCategoriaProduto() {
		return idCategoriaProduto;
	}


	public void setIdCategoriaProduto(Long idCategoriaProduto) {
		this.idCategoriaProduto = idCategoriaProduto;
	}

}
