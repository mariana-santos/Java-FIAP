package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_estado", uniqueConstraints = {
        @UniqueConstraint(name = "uk_nome_estado", columnNames = { "nome_estado" }),
        @UniqueConstraint(name = "uk_sigla_estado", columnNames = { "sigla_estado" })
})
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_estado")
    @SequenceGenerator(name = "sq_estado", sequenceName = "sq_estado")
    @Column(name = "id_estado")
    private Long id;

    @Column(name = "nome_estado", nullable = false)
    private String nome;

    @Column(name = "sigla_estado", nullable = false)
    private String sigla;

    public Estado() {
    }

    public Estado(Long id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }


    public Long getId() {
        return id;
    }

    public Estado setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Estado setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSigla() {
        return sigla;
    }

    public Estado setSigla(String sigla) {
        this.sigla = sigla;
        return this;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                '}';
    }
}
