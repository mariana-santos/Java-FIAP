package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlunoDB {
	public Connection ConexaoDB(){
       
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
	
	public void InserirAlunosDB(Aluno a){
	     
        Connection conn = ConexaoDB();
        Statement statement;
       
        try {
            String query = String.
            		format("INSERT INTO tb_aluno (id, nome, ra, curso) "
            				+ "VALUES (%s,'%s', '%s', '%s')", 
            				a.getId(), a.getNome(), a.getRa(), a.getCurso());
           
            statement = conn.createStatement();
            statement.executeUpdate(query);
           
            System.out.println(a.getNome() + " incluído com sucesso!");
            System.in.read();
        }catch (Exception e){
            System.out.println(e);
        }
    }
	
	public ArrayList<Aluno> ListarAlunosDB(){
	       
        Connection conn = ConexaoDB();
        Statement statement;
        ResultSet rs = null;
        
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
       
        try {
            String query= "SELECT * FROM tb_aluno";
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
           
            while(rs.next()){
            	Aluno a = new Aluno();
            	a.setId(Integer.parseInt(rs.getString("id")));
                a.setNome(rs.getString("nome"));
                a.setCurso(rs.getString("curso"));
                a.setRa(rs.getString("ra"));
                
                alunos.add(a);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        
        return alunos;
    }
	
	public int ListarUltimoId(){
	       
        Connection conn = ConexaoDB();
        Statement statement;
        ResultSet rs = null;
        
        int id = 1;
       
        try {
            String query= "SELECT MAX(id) AS id FROM tb_aluno";
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
           
            while(rs.next()){
            	id = Integer.parseInt(rs.getString("id")) + 1;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        
        return id;
    }
	
	public void AtualizarAlunoDB(Aluno a){
	       
        Connection conn = ConexaoDB();
        Statement statement;
       
        try {
            String query = String.format("UPDATE tb_aluno "
            		+ "SET nome = '%s', ra = '%s', curso = '%s'"
            		+ "WHERE id = %s", 
            		a.getNome(), a.getRa(), a.getCurso(), a.getId());
            
            statement = conn.createStatement();
            statement.executeUpdate(query);
           
            System.out.println(a.getNome() + " atualizado com sucesso!");
            System.in.read();
        }catch (Exception e){
            System.out.println(e);
        }
    }
	
	public void ExcluirAlunoDB(int id){
        Connection conn = ConexaoDB();
        Statement statement;
       
        try {
            String query = String.format("DELETE FROM tb_aluno "
            		+ "WHERE id = %s", id);
           
            statement = conn.createStatement();
            statement.executeUpdate(query);
           
            System.out.println("Registro excluído com sucesso!");
            System.in.read();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
