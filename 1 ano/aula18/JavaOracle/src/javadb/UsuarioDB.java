package javadb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UsuarioDB {


    public Connection ConexaoDB(){
               
        //try (Connection conn = DriverManager.getConnection(
                //"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm...", "???")) {
       
        Connection conn=null;
       
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
           
            conn = DriverManager.
            		getConnection("jdbc:oracle:thin:@oracle.fiap.com.br"
            				+ ":1521:ORCL", "rm97503", "280304");

            if(conn!=null)
                System.out.println("Conexão estabelecida com sucesso!");
            else
                System.out.println("Falha na conexão com o Banco de Dados!");


        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", 
            		e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return conn;
    }
   
    public void InserirUsuarioDB(Usuario u){
       
        Connection conn = ConexaoDB();
        Statement statement;
       
        try {
            String query = String.
            		format("insert into tb_usuario "
            				+ "(id,nome) values(%s,'%s')", 
            				u.getId(), u.getNome());
           
            statement = conn.createStatement();
            statement.executeUpdate(query);
           
            System.out.println("Registro incluído com sucesso!");
            
        }catch (Exception e){
            System.out.println(e);
        }
    }
   
    public void ListarUsuarioDB(){
       
        Connection conn = ConexaoDB();
        Statement statement;
        ResultSet rs=null;
       
        try {
            String query= "select * from tb_usuario";
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
           
            while(rs.next()){
                System.out.print(rs.getString("id")+" ");
                System.out.println(rs.getString("nome"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public void AtualizarUsuarioDB(Usuario u){
       
        Connection conn = ConexaoDB();
        Statement statement;
       
        try {
            String query = String.format("update tb_usuario "
            		+ "set nome = '%s' where id = %s", 
            		u.getNome(), u.getId());
            
            statement = conn.createStatement();
            statement.executeUpdate(query);
           
            System.out.println("Registro atualizado com sucesso!");
        }catch (Exception e){
            System.out.println(e);
        }
    }
   
    public void ExcluirUsuarioDB(int id){
       
        Connection conn = ConexaoDB();
        Statement statement;
       
        try {
            String query = String.format("delete from tb_usuario "
            		+ "where id = %s", id);
           
            statement = conn.createStatement();
            statement.executeUpdate(query);
           
            System.out.println("Registro excluído com sucesso!");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
