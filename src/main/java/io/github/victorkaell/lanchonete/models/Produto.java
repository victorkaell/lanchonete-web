package io.github.victorkaell.lanchonete.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double precoBase;

    private String imagemUrl;

    // Define o relacionamento Muitos-para-Muitos
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // Define a tabela de junção (tabela intermediária)
    @JoinTable(
        name = "produto_adicionais", // Nome da tabela de junção
        joinColumns = @JoinColumn(name = "produto_id"), // Chave estrangeira para Produto
        inverseJoinColumns = @JoinColumn(name = "adicional_id") // Chave estrangeira para Adicional
    )
    private Set<Adicional> adicionais = new HashSet<>();
    
    // --- Construtores ---

    // Construtor vazio (obrigatório pelo JPA)
    public Produto() {
    }

    public Produto(String nome, Double precoBase, String imagemUrl) {
        this.nome = nome;
        this.precoBase = precoBase;
        this.imagemUrl = imagemUrl;
    }

    // --- Getters e Setters ---

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

    public Double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(Double precoBase) {
        this.precoBase = precoBase;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public Set<Adicional> getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(Set<Adicional> adicionais) {
        this.adicionais = adicionais;
    }

    // (Opcional: hashCode e equals são boas práticas para entidades)
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        Produto other = (Produto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}