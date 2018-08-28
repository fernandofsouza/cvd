package br.com.fernando.cvd.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fernando.cvd.model.TipoUsuario;
import br.com.fernando.cvd.service.TipoUsuarioService;
import br.com.fernando.cvd.util.FacesUtil;


@Named
@ViewScoped
public class ListaTipoUsuarioView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoUsuarioService tipoUsuarioService;
	
	private List<TipoUsuario> tiposUsuario = new ArrayList<>();
	
	private List<TipoUsuario> tiposUsuarioSelecionados = new ArrayList<>();
	
		

	@PostConstruct
	public void inicializar() {
		tiposUsuario = tipoUsuarioService.listarTodos();		
	}
	
	public void excluirSelecionados() {
		for (TipoUsuario tipoUsuario : tiposUsuarioSelecionados) {
			tipoUsuarioService.excluir(tipoUsuario);
			tiposUsuario.remove(tipoUsuario);
		}
		
		FacesUtil.addInfoMessage("Tipo(s) Usuario(s) excluído(s) com sucesso!");
	}

	public List<TipoUsuario> getTipoUsuarios() {
		return tiposUsuario;
	}

	public void setTipoUsuarios(List<TipoUsuario> tiposUsuario) {
		this.tiposUsuario = tiposUsuario;
	}

	public List<TipoUsuario> getTipoUsuarioSelecionados() {
		return tiposUsuarioSelecionados;
	}

	public void setTipoUsuarioSelecionados(List<TipoUsuario> tiposUsuarioSelecionados) {
		this.tiposUsuarioSelecionados = tiposUsuarioSelecionados;
	}


}
