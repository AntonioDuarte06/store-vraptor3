package br.com.duxus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto{
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String descricao;
	private Double preco;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String name) {
		this.nome = name;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getNome() {return this.nome;}
	
	public String getDescricao() {return this.descricao;}

	public double getPreco() {return this.preco;}

}
