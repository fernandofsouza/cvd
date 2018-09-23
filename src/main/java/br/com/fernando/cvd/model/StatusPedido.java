package br.com.fernando.cvd.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;



@Entity(name="status_pedido")
public class StatusPedido implements Serializable{

	public static final Long STATUS_ABERTO = 1l;
	public static final Long STATUS_FATURADO = 2l;
	public static final Long STATUS_PREPARADO = 3l;
	public static final Long STATUS_ENVIADO = 4l;
	public static final Long STATUS_EM_TRANSITO = 5l;
	public static final Long STATUS_ENTREGUE = 6l;
	public static final Long STATUS_DEVOLVIDO = 7l;
	public static final Long STATUS_EXCLUIDO = 8l;
	public static final Long STATUS_EXTRAVIADO = 9l;
	public static final Long STATUS_CANCELADO = 10l;
	

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotEmpty
private String descricao;



public StatusPedido() {
	
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

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
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
	StatusPedido other = (StatusPedido) obj;
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
	return true;
}

@Override
public String toString() {
	return "StatusPedido [id=" + id + ", descricao=" + descricao + "]";
}



}