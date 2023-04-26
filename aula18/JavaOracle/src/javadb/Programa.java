package javadb;


import java.sql.Connection;

public class Programa {
    public static void main(String[] args) {
        UsuarioDB db = new UsuarioDB();
       
        Usuario a = new Usuario(1, "Jefferson");
        db.InserirUsuarioDB(a);
       
        a.setNome("João Marcelo");
        db.AtualizarUsuarioDB(a);
       
        db.ExcluirUsuarioDB(1);
       
        db.ListarUsuarioDB();
    }
}
