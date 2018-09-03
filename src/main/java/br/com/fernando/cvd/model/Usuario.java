package br.com.fernando.cvd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class Usuario {


@SuppressWarnings("unused")
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotEmpty
private String nome;


private String login;

private String senha;

private String email;

private String endereco;

private String cep;

@ManyToOne
@JoinColumn(name="id_tipo_usuario")
private TipoUsuario tipoUsuario;



public Usuario() {
	
}



public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getNome() {
	return nome;
}



public void setNome(String nome) {
	this.nome = nome;
}



public String getLogin() {
	return login;
}



public void setLogin(String login) {
	this.login = login;
}



public String getSenha() {
	return senha;
}



public void setSenha(String senha) {
	this.senha = senha;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public String getEndereco() {
	return endereco;
}



public void setEndereco(String endereco) {
	this.endereco = endereco;
}



public String getCep() {
	return cep;
}



public void setCep(String cep) {
	this.cep = cep;
}



public TipoUsuario getTipoUsuario() {
	return tipoUsuario;
}



public void setTipoUsuario(TipoUsuario tipoUsuario) {
	this.tipoUsuario = tipoUsuario;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cep == null) ? 0 : cep.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((login == null) ? 0 : login.hashCode());
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	return result;
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Usuario other = (Usuario) obj;
	if (cep == null) {
		if (other.cep != null)
			return false;
	} else if (!cep.equals(other.cep))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (login == null) {
		if (other.login != null)
			return false;
	} else if (!login.equals(other.login))
		return false;
	if (nome == null) {
		if (other.nome != null)
			return false;
	} else if (!nome.equals(other.nome))
		return false;
	return true;
}



@Override
public String toString() {
	return "Usuario [id=" + id + ", nome=" + nome + ", login=" + login + ", email=" + email + ", endereco=" + endereco
			+ ", cep=" + cep + ", tipoUsuario=" + tipoUsuario + "]";
}



}