package br.com.fiap.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_produto", uniqueConstraints = {
        @UniqueConstraint(name = "uk_nm_produto", columnNames = { "nm_produto" })
})
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_produto")
    @SequenceGenerator(name = "sq_produto", sequenceName = "sq_produto")
    @Column(name = "id_produto")
    private Long id;

    @Column(name = "nm_produto", nullable = false)
    private String nome;

    @Column(name = "ds_produto", nullable = false)
    private String descricao;

    private BigDecimal valor;

    public Produto(){ }

    public Produto(Long id, String nome, String descricao, BigDecimal valor) {
        this.setId(id);
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setValor(valor);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", valor=" + getValor() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Produto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Produto setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }
}
