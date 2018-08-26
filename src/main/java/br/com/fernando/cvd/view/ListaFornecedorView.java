package br.com.fernando.cvd.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fernando.cvd.model.Fornecedor;
import br.com.fernando.cvd.service.FornecedorService;
import br.com.fernando.cvd.util.FacesUtil;


@Named
@ViewScoped
public class ListaFornecedorView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FornecedorService fornecedorService;
	
	private List<Fornecedor> fornecedores = new ArrayList<>();
	
	private List<Fornecedor> fornecedorSelecionados = new ArrayList<>();
	
		

	@PostConstruct
	public void inicializar() {
		fornecedores = fornecedorService.listarTodos();		
	}
	
	public void excluirSelecionados() {
		for (Fornecedor fornecedor : fornecedorSelecionados) {
			fornecedorService.excluir(fornecedor);
			fornecedores.remove(fornecedor);
		}
		
		FacesUtil.addInfoMessage("Fornecedor(s) excluído(s) com sucesso!");
	}

	public List<Fornecedor> getFornecedors() {
		return fornecedores;
	}

	public void setFornecedors(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public List<Fornecedor> getFornecedorSelecionados() {
		return fornecedorSelecionados;
	}

	public void setFornecedorSelecionados(List<Fornecedor> fornecedorSelecionados) {
		this.fornecedorSelecionados = fornecedorSelecionados;
	}


}
