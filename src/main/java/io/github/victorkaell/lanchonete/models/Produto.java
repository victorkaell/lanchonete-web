package io.github.victorkaell.lanchonete.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private Double preco;
	private String descricao;
	private String imagemURL;
	private Boolean estaDisponivel;
	
	public Produto() {}
	
	public Produto(String nome, Double preco, String descricao, String imagemURL, Boolean estaDisponivel) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.imagemURL = imagemURL;
		this.estaDisponivel = estaDisponivel;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagemURL() {
		return imagemURL;
	}

	public void setImagemURL(String imagemURL) {
		this.imagemURL = imagemURL;
	}

	public Boolean getEstaDisponivel() {
		return estaDisponivel;
	}
	
	public void setEstaDisponivel(Boolean estaDisponivel) {
		this.estaDisponivel = estaDisponivel;
	}
	
	@Override
	public String toString() {
		return "Alimento [id=" + id + ", nome=" + nome + ", preco=" + preco + ", descricao=" + descricao
				+ ", imagemURL=" + imagemURL + ", estaDisponivel=" + estaDisponivel + "]";
	}

}
