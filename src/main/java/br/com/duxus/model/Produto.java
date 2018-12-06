package br.com.duxus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
public class Produto {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Length(min = 3)
	@Pattern(regexp = "[a-z A-Z]+")
	private String nome;

	@NotNull
	@Length(max = 40)
	private String descricao;

	@Min(0)
	private double preco;

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

	public String getNome() {
		return this.nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public double getPreco() {
		return this.preco;
	}

}
