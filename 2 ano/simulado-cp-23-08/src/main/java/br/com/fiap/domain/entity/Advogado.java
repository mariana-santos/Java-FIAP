package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_advogado", uniqueConstraints = {
        @UniqueConstraint(name = "uk_nro_oab_advogado", columnNames = { "nro_oab_advogado" })
})
public class Advogado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_advogado")
    @SequenceGenerator(name = "sq_advogado", sequenceName = "sq_advogado")
    @Column(name = "id_advogado")
    private Long id;

    @Column(name = "nome_advogado", nullable = false)
    private String nome;

    @Column(name = "nro_oab_advogado", nullable = false)
    private String numeroOAB;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "id_estado",
            referencedColumnName = "id_estado",
            foreignKey = @ForeignKey(name = "fk_advogado_estado")
    )
    private Estado estado;

    public Advogado() {
    }

    public Advogado(Long id, String nome, String numeroOAB, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.numeroOAB = numeroOAB;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public Advogado setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Advogado setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getNumeroOAB() {
        return numeroOAB;
    }

    public Advogado setNumeroOAB(String numeroOAB) {
        this.numeroOAB = numeroOAB;
        return this;
    }

    public Estado getEstado() {
        return estado;
    }

    public Advogado setEstado(Estado estado) {
        this.estado = estado;
        return this;
    }

    @Override
    public String toString() {
        return  id + ": " + nome + " - " + estado.getSigla() +'\n' +
                "OAB: " + numeroOAB + "\n";
    }


}
