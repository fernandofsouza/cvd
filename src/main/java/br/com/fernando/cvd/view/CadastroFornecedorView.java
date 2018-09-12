package br.com.fernando.cvd.view;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fernando.cvd.model.Fornecedor;
import br.com.fernando.cvd.service.FornecedorService;

@Named
@ViewScoped
public class CadastroFornecedorView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Fornecedor fornecedor = new Fornecedor();
	
	private Long idFornecedor;
	
	@Inject
	private FornecedorService fornecedorService;
	
	
	public void inicializar() {
		if (idFornecedor != null) {
			fornecedor = fornecedorService.buscarPorId(idFornecedor);
			System.out.println("Id do Fornecedor eh: "+idFornecedor);
		}
	}
	
	
	public String salvar() {
		fornecedorService.salvar(fornecedor);
		return "lista-fornecedor.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		fornecedorService.excluir(fornecedor);
		return "lista-fornecedor.xhtml?faces-redirect=true";
	}


	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}


	public Long getIdFornecedor() {
		return idFornecedor;
	}


	public void setIdFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

}
