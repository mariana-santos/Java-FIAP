package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_processo", uniqueConstraints = {
        @UniqueConstraint(name = "uk_nro_processo", columnNames = { "nro_processo" })
})
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_processo")
    @SequenceGenerator(name = "sq_processo", sequenceName = "sq_processo")
    @Column(name = "id_processo")
    private Long id;

    @Column(name = "nro_processo", nullable = false)
    private String numero;

    @Column(name = "pro_bono_processo", nullable = false)
    private Boolean proBono;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "id_advogado",
            referencedColumnName = "id_advogado",
            foreignKey = @ForeignKey(name = "fk_processo_advogado")
    )
    private Advogado advogado;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "id_tipo_acao",
            referencedColumnName = "id_tipo_acao",
            foreignKey = @ForeignKey(name = "fk_processo_tipo_acao")
    )
    private TipoDeAcao tipoDeAcao;


    public Processo() {
    }

    public Processo(Long id, String numero, Boolean proBono, Advogado advogado, TipoDeAcao tipoDeAcao) {
        this.id = id;
        this.numero = numero;
        this.proBono = proBono;
        this.advogado = advogado;
        this.tipoDeAcao = tipoDeAcao;
    }

    public Long getId() {
        return id;
    }

    public Processo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Processo setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public Boolean getProBono() {
        return proBono;
    }

    public Processo setProBono(Boolean proBono) {
        this.proBono = proBono;
        return this;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public Processo setAdvogado(Advogado advogado) {
        this.advogado = advogado;
        return this;
    }

    public TipoDeAcao getTipoDeAcao() {
        return tipoDeAcao;
    }

    public Processo setTipoDeAcao(TipoDeAcao tipoDeAcao) {
        this.tipoDeAcao = tipoDeAcao;
        return this;
    }


    @Override
    public String toString() {
        return "--Processo " + id + "--\n" +
                "número: " + numero + '\n' +
                "pro bono: " + (proBono ? "sim" : "não") + "\n" +
                "advogado: \n" + advogado +
                "tipo de ação: \n" + tipoDeAcao + "\n";
    }
}
