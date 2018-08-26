package br.com.fernando.cvd.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mindrot.jbcrypt.BCrypt;

import br.com.fernando.cvd.exception.NegocioException;
import br.com.fernando.cvd.model.Usuario;

@Stateless
public class UsuarioDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(name = "cvdPU")
	EntityManager manager;

	public Usuario salvar(Usuario usuario) {
		return manager.merge(usuario);
	}

	public void excluir(Usuario usuario) {
		try {
			usuario = buscarPorId(usuario.getId());
			manager.remove(usuario);

		} catch (Exception e) {
			throw new NegocioException("Usuario não pode ser excluído");
		}
	}

	public Usuario buscarPorId(Long id) {
		return manager.find(Usuario.class, id);
	}
	
	
	public List<Usuario> listarTodos() {
		List<Usuario> u = new ArrayList<Usuario>();
		try {
			u = (List<Usuario>) manager.createQuery("Select u FROM Usuario u", Usuario.class).getResultList();
		} catch (Exception e) {
			System.out.println("Erro: ");
			e.printStackTrace();
		}
		return u;
	}

	public Usuario criptografaSenha(Usuario usuario) {

		// Gera um sal aleatório
		String salGerado = BCrypt.gensalt();
		System.out.println("O sal gerado foi $" + salGerado + "$");

		// Gera a senha hasheada utilizando o sal gerado
		String senhaHasheada = BCrypt.hashpw(usuario.getSenha(), salGerado);

		// Atualiza a senha do usuário
		usuario.setSenha(senhaHasheada);

		return usuario;

	}

	public boolean autentica(Usuario usuarioCandidato) {

		String senhaDoCandidato = usuarioCandidato.getSenha(); // senha texto puro

		Usuario usuarioComSenhaHasheada = this.buscarPorId(usuarioCandidato.getId());
		String senhaDoBanco = usuarioComSenhaHasheada.getSenha(); // senha criptografada.

		// Usa o BCrypt para verificar se a senha passada está correta.
		// Isso envolve ler a senhaDoBanco, separar o que é sal e o que é hash
		// usar o sal para criar um hash da senhaDoCandidato e, por fim
		// verificar se os hashes gerados são iguais.
		boolean autenticado = BCrypt.checkpw(senhaDoCandidato, senhaDoBanco);

		return autenticado;

	}

}
