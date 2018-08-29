package br.com.fernando.cvd.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class Fornecedor implements Serializable{


private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotEmpty
private String nome;

@NotEmpty
private String contato;

private String email;

private String endereco;

private Integer cnpj;





public Fornecedor() {
	
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

public String getContato() {
	return contato;
}

public void setContato(String contato) {
	this.contato = contato;
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

public Integer getCnpj() {
	return cnpj;
}

public void setCnpj(Integer cnpj) {
	this.cnpj = cnpj;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
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
	Fornecedor other = (Fornecedor) obj;
	if (cnpj == null) {
		if (other.cnpj != null)
			return false;
	} else if (!cnpj.equals(other.cnpj))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
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
	return "Fornecedor [id=" + id + ", nome=" + nome + ", contato=" + contato + ", email=" + email + ", endereco="
			+ endereco + ", cnpj=" + cnpj + "]";
}




}