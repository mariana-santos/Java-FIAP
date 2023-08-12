package br.com.fiap;

import br.com.fiap.domain.entity.Deposito;
import br.com.fiap.domain.entity.ItemEstocado;
import br.com.fiap.domain.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Deposito deposito = new Deposito();
        deposito
                .setId(null)
                .setNome("faria lima");

        Produto prod = new Produto();

        prod.setId(null)
                .setNome("banana")
                .setDescricao("a mais delicia da feira")
                .setValor(BigDecimal.valueOf(4.99));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("maria-db");

        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

//        manager.persist(deposito);
//        manager.persist(prod);

        for(int i = 0; i < 50; i++){
            var item = new ItemEstocado();

            item.setDeposito(deposito)
                    .setProduto(prod)
                    .setEntrada(LocalDateTime.now())
                    .setNumeroSerie(i + "NR" + prod.getId() + "-" + deposito.getId());

            manager.persist(item);
        }


        manager.getTransaction().commit();

        System.out.println(deposito);
        System.out.println(prod);

        manager.close();
        factory.close();

    }
}
