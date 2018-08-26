package br.com.fernando.cvd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;



@Entity(name="tipo_pagamento")
public class TipoPagamento {


@SuppressWarnings("unused")
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotEmpty
private String descricao;

private Boolean parcelado;

public TipoPagamento() {
	
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public Boolean getParcelado() {
	return parcelado;
}

public void setParcelado(Boolean parcelado) {
	this.parcelado = parcelado;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((parcelado == null) ? 0 : parcelado.hashCode());
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
	TipoPagamento other = (TipoPagamento) obj;
	if (descricao == null) {
		if (other.descricao != null)
			return false;
	} else if (!descricao.equals(other.descricao))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (parcelado == null) {
		if (other.parcelado != null)
			return false;
	} else if (!parcelado.equals(other.parcelado))
		return false;
	return true;
}

@Override
public String toString() {
	return "TipoPagamento [id=" + id + ", descricao=" + descricao + ", parcelado=" + parcelado + "]";
}




}