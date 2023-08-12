package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_deposito", uniqueConstraints = {
        @UniqueConstraint(name = "uk_nm_deposito", columnNames = {"nm_deposito"})
})
public class Deposito {

    @Id
    @SequenceGenerator(name = "sq_deposito", allocationSize = 1, initialValue = 1, sequenceName = "sq_deposito")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_deposito")

    @Column(name = "id_deposito")
    private Long id;

    @Column(name = "nm_deposito", nullable = false, unique = true)
    private String nome;

    public Deposito(){  }

    public Deposito(Long id, String nome){
        this.setNome(nome);
        this.setId(id);
    }

    public Long getId() {
        return id;
    }

    public Deposito setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Deposito setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        return "Deposito{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
