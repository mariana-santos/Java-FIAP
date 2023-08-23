package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tipo_acao", uniqueConstraints = {
        @UniqueConstraint(name = "uk_nome_tipo_acao", columnNames = { "nome_tipo_acao" })
})
public class TipoDeAcao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_tipo_acao")
    @SequenceGenerator(name = "sq_tipo_acao", sequenceName = "sq_tipo_acao")
    @Column(name = "id_tipo_acao")
    private Long id;

    @Column(name = "nome_tipo_acao", nullable = false)
    private String nome;

    public TipoDeAcao() {
    }

    public TipoDeAcao(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public Long getId() {
        return id;
    }

    public TipoDeAcao setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoDeAcao setNome(String nome) {
        this.nome = nome;
        return this;
    }


    @Override
    public String toString() {
        return  id + ": " + nome + '\n';
    }
}
