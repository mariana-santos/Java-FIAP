package javadb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int opcao;
		
		do {
			System.out.println("Bem vindo ao sistema! Selecione qualquer tecla para continuar");
			
			System.in.read();
			
			System.out.println("1 - Incluir alunos");
			System.out.println("2 - Atualizar alunos");
			System.out.println("3 - Excluir alunos");
			System.out.println("4 - Listar alunos");
			System.out.println("5 - Listar um aluno");
			System.out.println("6 - Sair");
			
			opcao = in.nextInt();
			
			if(opcao == 1){
				Aluno a = new Aluno();
				AlunoDB db = new AlunoDB();
				
				System.out.println("Digite o nome do aluno");
				a.setNome(in.next());
				
				System.out.println("Digite o ra do aluno");
				a.setRa(in.next());
				
				System.out.println("Digite o curso do aluno");
				a.setCurso(in.next());
				
				a.setId(db.ListarUltimoId());
				
				db.InserirAlunosDB(a);
			}
			
			else if(opcao == 2){
				Aluno a = new Aluno();
				AlunoDB db = new AlunoDB();
				
				System.out.println("Lista de alunos cadastrados: ");
				ListarAlunos(true, 0);
				
				System.out.println("Por favor, digite o id do aluno que deseja atualizar: ");
				a.setId(in.nextInt());
				
				System.out.println("Digite o novo nome do aluno");
				a.setNome(in.next());
				
				System.out.println("Digite o novo ra do aluno");
				a.setRa(in.next());
				
				System.out.println("Digite o novo curso do aluno");
				a.setCurso(in.next());
				
				db.AtualizarAlunoDB(a);
			}
			
			else if (opcao == 3){
				AlunoDB db = new AlunoDB();
				
				System.out.println("Lista de alunos cadastrados: ");
				ListarAlunos(true, 0);
				
				System.out.println("Por favor, digite o id do aluno que deseja excluir: ");
				int id = in.nextInt();
				
				db.ExcluirAlunoDB(id);
			}
			
			else if(opcao == 4){
				ListarAlunos(true, 0);
			}
			
			else if(opcao == 5){
				System.out.println("Por favor, digite o id do aluno que deseja buscar: ");
				int id = in.nextInt();
				
				ListarAlunos(false, id);
			}
			
		}while(opcao > 0 && opcao < 6);
	}
	
	public static void ListarAlunos(boolean todos, int id) throws IOException{
		AlunoDB db = new AlunoDB();
		ArrayList<Aluno> alunos = db.ListarAlunosDB();
		
		if (todos){
			for(Aluno aluno : alunos){
				System.out.print("ID: " + aluno.getId());
				System.out.println(" | Nome: " + aluno.getNome());
			}
		}
		else{
			for(Aluno aluno : alunos){
				if(aluno.getId() == id){
					System.out.println("ID: " + aluno.getId());
					System.out.println("Nome: " + aluno.getNome());
					System.out.println("RA: " + aluno.getRa());
					System.out.println("Curso: " + aluno.getCurso() + "\n");
					
					System.out.println("Digite qualquer tecla para continuar");
					System.in.read();
				}
			}
		}
	}
}
