package br.com.fernando.cvd.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;



@Entity(name="public.categoria_produto")
public class CategoriaProduto implements Serializable {



private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotEmpty
private String descricao;

private String nome;

@Column(name="qtd_un")
private BigDecimal quantidadeUnitaria;

@Column(name="cod_categoria")
private String codigo;

public CategoriaProduto() {
	
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

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public BigDecimal getQuantidadeUnitaria() {
	return quantidadeUnitaria;
}

public void setQuantidadeUnitaria(BigDecimal quantidadeUnitaria) {
	this.quantidadeUnitaria = quantidadeUnitaria;
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
	result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((quantidadeUnitaria == null) ? 0 : quantidadeUnitaria.hashCode());
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
	CategoriaProduto other = (CategoriaProduto) obj;
	if (codigo == null) {
		if (other.codigo != null)
			return false;
	} else if (!codigo.equals(other.codigo))
		return false;
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
	if (quantidadeUnitaria == null) {
		if (other.quantidadeUnitaria != null)
			return false;
	} else if (!quantidadeUnitaria.equals(other.quantidadeUnitaria))
		return false;
	return true;
}

@Override
public String toString() {
	return "CategoriaProduto [id=" + id + ", descricao=" + descricao + ", quantidadeUnitaria=" + quantidadeUnitaria
			+ ", codigo=" + codigo + "]";
}


}