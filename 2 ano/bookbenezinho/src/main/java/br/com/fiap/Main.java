package br.com.fiap;

import br.com.fiap.domain.entity.Author;
import br.com.fiap.domain.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "oracle" );
        EntityManager manager = factory.createEntityManager();

//        persistData(manager);

//      --- ADICIONANDO OS RESULTADOS DA QUERY NUMA LISTA E IMPRIMINDO ---
        List<Book> list =  manager.createQuery("FROM Book", Book.class).getResultList();

        list.forEach(System.out::println);
//        for(Book book : list){
//            System.out.println(book);
//        }

        manager.close();
        factory.close();

    }

    private static void persistData(EntityManager manager) {
        String author_name = JOptionPane.showInputDialog("Autor");
        String book_name = JOptionPane.showInputDialog("Livro");

//        var bene = new Author("Benefrancis");
//        var bruno = new Author("Bruno Sudré");

        var author = new Author(author_name);
        var book = new Book();

        book.setName(book_name)
                        .setISBN(UUID.randomUUID().toString())
                        .addAuthor(author)
                        .setReleaseDate(LocalDate.now());

        manager.getTransaction().begin();
        manager.persist(book);
        manager.getTransaction().commit();
    }
}