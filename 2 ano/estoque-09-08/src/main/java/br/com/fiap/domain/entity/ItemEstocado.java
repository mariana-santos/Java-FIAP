package br.com.fiap.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_item", uniqueConstraints = {
        @UniqueConstraint(name = "uk_item_nr_serie", columnNames = { "nr_serie" })
})
public class ItemEstocado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_item")
    @SequenceGenerator(name = "sq_item", sequenceName = "sq_item")
    @Column(name = "id_item")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "id_produto",
            referencedColumnName = "id_produto",
            foreignKey = @ForeignKey(name = "fk_item_produto")
    )
    private Produto produto;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "id_deposito",
            referencedColumnName = "id_deposito",
            foreignKey = @ForeignKey(name = "fk_item_deposito")
    )
    private Deposito deposito;

    @Column(name = "dt_entrada", nullable = false)
    private LocalDateTime entrada;

    @Column(name = "dt_saida")
    private LocalDateTime saida;

    @Column(name = "nr_serie", nullable = false)
    private String numeroSerie;

    public ItemEstocado() {

    }

    public ItemEstocado(Long id, Produto produto, Deposito deposito, LocalDateTime entrada, LocalDateTime saida, String numeroSerie) {
        this.id = id;
        this.produto = produto;
        this.deposito = deposito;
        this.entrada = entrada;
        this.saida = saida;
        this.numeroSerie = numeroSerie;
    }

    public Long getId() {
        return id;
    }

    public ItemEstocado setId(Long id) {
        this.id = id;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public ItemEstocado setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public ItemEstocado setDeposito(Deposito deposito) {
        this.deposito = deposito;
        return this;
    }


    public LocalDateTime getEntrada() {
        return entrada;
    }

    public ItemEstocado setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
        return this;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public ItemEstocado setSaida(LocalDateTime saida) {
        this.saida = saida;
        return this;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public ItemEstocado setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
        return this;
    }


    @Override
    public String toString() {
        return "ItemEstocado{" +
                "id=" + id +
                ", produto=" + produto +
                ", deposito=" + deposito +
                ", entrada=" + entrada +
                ", saida=" + saida +
                ", numeroSerie='" + numeroSerie + '\'' +
                '}';
    }
}
