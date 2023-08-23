package br.com.fiap;

import br.com.fiap.domain.entity.Advogado;
import br.com.fiap.domain.entity.Estado;
import br.com.fiap.domain.entity.Processo;
import br.com.fiap.domain.entity.TipoDeAcao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
        EntityManager manager = factory.createEntityManager();

        PersistirDados(manager, factory);

        int id_processo = Integer.parseInt(JOptionPane.showInputDialog("Por favor, digite o id do processo que deseja buscar"));
//
        getProcessoById(id_processo, manager, factory);

        getProcessos(manager, factory);

        manager.close();
        factory.close();
    }

    public static void PersistirDados(EntityManager manager, EntityManagerFactory factory){
        TipoDeAcao despejo = new TipoDeAcao(null, "Ação de despejo");
        TipoDeAcao trabalhista = new TipoDeAcao(null, "Ação trabalhista");

        Estado sp = new Estado(null, "São Paulo", "SP");
        Estado rj = new Estado(null, "Rio de Janeiro", "RJ");

        Advogado advPedro = new Advogado(null, "Pedro Rodrigues", "123", rj);
        Advogado advMari = new Advogado(null, "Mariana Santos", "456", sp);

        Processo processo1 = new Processo(null, "123", false, advMari, trabalhista);
        Processo processo2 = new Processo(null, "456", true, advMari, despejo);

        manager.getTransaction().begin();

        manager.persist(despejo);
        manager.persist(trabalhista);
        manager.persist(sp);
        manager.persist(rj);
        manager.persist(advPedro);
        manager.persist(advMari);
        manager.persist(processo1);
        manager.persist(processo2);

        manager.getTransaction().commit();

    }

    public static void getProcessoById(int id, EntityManager manager, EntityManagerFactory factory){
        manager.getTransaction().begin();

        var jpql = "FROM Processo pro  where pro.id = " + id;

        System.out.println("---PROCESSO BUSCADO---");
        List list = manager.createQuery( jpql ).getResultList();
        list.forEach( System.out::println );
    }

    public static void getProcessos(EntityManager manager, EntityManagerFactory factory){
        manager.getTransaction().begin();

        var jpql = "FROM Processo pro";

        System.out.println("---TODOS OS PROCESSOS---");
        List list = manager.createQuery( jpql ).getResultList();
        list.forEach( System.out::println );
    }
}