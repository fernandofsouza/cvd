package br.com.fernando.cvd.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class Produto implements Serializable{


private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotEmpty
private String nome;

@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
@JoinColumn(name = "id_produto")
private List<Imagens> imagens;

@OneToOne
@JoinColumn(name="id_categoria")
private CategoriaProduto categoriaProduto;


@OneToOne
@JoinColumn(name="id_caracteristica")
private CaracteristicaProduto caracteristicaProduto;


public Produto() {
	
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

public List<Imagens> getImagens() {
	return imagens;
}

public void setImagens(List<Imagens> imagens) {
	this.imagens = imagens;
}

public CategoriaProduto getCategoriaProduto() {
	return categoriaProduto;
}

public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
	this.categoriaProduto = categoriaProduto;
}

public CaracteristicaProduto getCaracteristicaProduto() {
	return caracteristicaProduto;
}

public void setCaracteristicaProduto(CaracteristicaProduto caracteristicaProduto) {
	this.caracteristicaProduto = caracteristicaProduto;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((caracteristicaProduto == null) ? 0 : caracteristicaProduto.hashCode());
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
	Produto other = (Produto) obj;
	if (caracteristicaProduto == null) {
		if (other.caracteristicaProduto != null)
			return false;
	} else if (!caracteristicaProduto.equals(other.caracteristicaProduto))
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
	return "Produto [id=" + id + ", nome=" + nome + ", imagens=" + imagens + ", categoriaProduto=" + categoriaProduto
			+ ", caracteristicaProduto=" + caracteristicaProduto + "]";
}



}