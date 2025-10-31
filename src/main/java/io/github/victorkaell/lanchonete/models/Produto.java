package io.github.victorkaell.lanchonete.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private Double preco;
	private String descricao;
	private String imagemURL;
	private String status;
	
	@ManyToMany(fetch = FetchType.EAGER) // EAGER para carregar os adicionais junto com o produto
    @JoinTable(
        name = "produto_adicionais", 
        joinColumns = @JoinColumn(name = "produto_id"), 
        inverseJoinColumns = @JoinColumn(name = "adicional_id")
    )
    private Set<Adicional> adicionais;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Alimento [id=" + id + ", nome=" + nome + ", preco=" + preco + ", descricao=" + descricao
				+ ", imagemURL=" + imagemURL + ", status=" + status + "]";
	}
}
