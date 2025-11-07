package io.github.victorkaell.lanchonete.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

// Marca esta classe como uma entidade do banco de dados
@Entity
// Define o nome da tabela no banco
@Table(name = "adicionais")
public class Adicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double preco;

    // "mappedBy" indica que a entidade 'Produto' é a "dona" deste relacionamento
    // Isso evita que o JPA crie duas tabelas de junção
    @ManyToMany(mappedBy = "adicionais")
    // Usamos 'Set' para garantir que não haja adicionais duplicados por produto
    private Set<Produto> produtos = new HashSet<>();

    // --- Construtores ---

    // Construtor vazio (obrigatório pelo JPA)
    public Adicional() {
    }

    public Adicional(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
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
        Adicional other = (Adicional) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}