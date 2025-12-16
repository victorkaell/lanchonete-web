package io.github.victorkaell.lanchonete.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome não pode estar vazio.")
	@Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
	private String nome;
	
	@NotNull(message = "O preço é obrigatório.")
	@Min(value = 0, message = "O preço não pode ser negativo.")
	private Double preco;
	
	@NotBlank(message = "A descrição é obrigatória.")
	@Size(max = 255, message = "A descrição deve ser curta.")
	private String descricao;
	
	@NotBlank(message = "A URL da imagem é obrigatória.")
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
