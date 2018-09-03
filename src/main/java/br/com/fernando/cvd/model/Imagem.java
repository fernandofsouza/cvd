package br.com.fernando.cvd.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;



@Entity(name="imagens")
public class Imagem implements Serializable{



private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotEmpty
private String nome;

private String tipo;

private BigDecimal tamanho;

//@Lob
@Type(type="org.hibernate.type.BinaryType")
private byte[] imagem;

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="id_produto")
private Produto produto;


public Produto getProduto() {
	return produto;
}


public void setProduto(Produto produto) {
	this.produto = produto;
}


public Imagem() {
	
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


public String getTipo() {
	return tipo;
}


public void setTipo(String tipo) {
	this.tipo = tipo;
}


public BigDecimal getTamanho() {
	return tamanho;
}


public void setTamanho(BigDecimal tamanho) {
	this.tamanho = tamanho;
}


public byte[] getImagem() {
	return imagem;
}


public void setImagem(byte[] imagem) {
	this.imagem = imagem;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	result = prime * result + ((tamanho == null) ? 0 : tamanho.hashCode());
	result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
	Imagem other = (Imagem) obj;
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
	if (tamanho == null) {
		if (other.tamanho != null)
			return false;
	} else if (!tamanho.equals(other.tamanho))
		return false;
	if (tipo == null) {
		if (other.tipo != null)
			return false;
	} else if (!tipo.equals(other.tipo))
		return false;
	return true;
}


}