package CP3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		ArrayList<Professor> listaProf = new ArrayList<>();
		ArrayList<Aluno> listaAlunos = new ArrayList<>();
		ArrayList<Coordenador> listaCoord = new ArrayList<>();
		
		int opcao;
		String nome = "";
		String ra = "";
		
		do{
			System.out.println("Que tipo de usuário deseja cadastrar?");
			System.out.println("1 - Aluno");
			System.out.println("2 - Professor");
			System.out.println("3 - Coordenador");
			System.out.println("4 - Consultar usuários cadastrados");
			System.out.println("5 - Sair");

			opcao = in.nextInt();
			
			if(opcao < 4 && opcao > 0){
				System.out.println("Digite o nome a ser cadastrado: ");
				nome = in.next();

				System.out.println("Digite o RA a ser cadastrado: ");
				ra = in.next();
			}
			
			if(opcao == 1){
				Aluno aluno = new Aluno();
				
				aluno.setNome(nome);
				aluno.setRa(ra);
				
				System.out.println("Digite o curso em que o aluno será matriculado: ");
				aluno.setCurso(in.next());
				
				listaAlunos.add(aluno);
				
				System.out.println("Aluno "+nome+" cadastrado com sucesso!");
				System.in.read();
			}
			
			else if(opcao == 2){
				Professor prof = new Professor();
				
				prof.setNome(nome);
				prof.setRa(ra);
				
				System.out.println("Quantas disciplinas o professor ministra?");
				int qtd = in.nextInt();
				
				String disciplinas[] = new String[qtd];
				
				for (int i = 0; i < qtd; i++){
					System.out.println("Digite o nome da "+(i+1)+"° disciplina");
					disciplinas[i] = in.next();
				}
				
				prof.setDisciplinas(disciplinas);
				
				listaProf.add(prof);
				
				System.out.println("Professor "+nome+" cadastrado com sucesso!");
				System.in.read();
			}
			
			else if(opcao == 3){
				Coordenador coord = new Coordenador();
				
				coord.setNome(nome);
				coord.setRa(ra);
				
				System.out.println("Quantos cursos o coordenador coordena?");
				int qtd = in.nextInt();
				
				String disciplinas[] = new String[qtd];
				
				for (int i = 0; i < qtd; i++){
					System.out.println("Digite o nome do "+(i+1)+"° curso");
					disciplinas[i] = in.next();
				}
				
				coord.setCursos(disciplinas);
				
				listaCoord.add(coord);
				
				System.out.println("Coordenador "+nome+" cadastrado com sucesso!");
				System.in.read();
			}
			
			else if(opcao == 4){
//				SE ALGUMA COISA FOI CADASTRADA, ELE MOSTRA OS USUÁRIOS
				if(!listaAlunos.isEmpty() && !listaCoord.isEmpty() && !listaProf.isEmpty()){
					System.out.printf("----------LISTA DE USUÁRIOS----------\n\n");
				}
					
				if(!listaCoord.isEmpty()){
					System.out.printf("**COORDENADORES**\n\n");
					
					for (Coordenador c : listaCoord){
						System.out.println("Nome: "+c.getNome());
						System.out.println("RA: "+c.getRa());
						
						System.out.printf("\nLISTA DE CURSOS COORDENADOS:\n");
						for (int i = 0; i < c.getCursos().length; i++){
							System.out.println((i+1)+"° - "+c.getCursos()[i]);
						}
					}
					System.out.println();
					System.in.read();
				}
					
				if(!listaProf.isEmpty()){
					System.out.printf("**PROFESSORES**\n\n");
					
					for (Professor p : listaProf){
						System.out.println("Nome: "+p.getNome());
						System.out.println("RA: "+p.getRa());
						
						System.out.printf("\nLISTA DE DISCIPLINAS MINISTRADAS:\n");
						for (int i = 0; i < p.getDisciplinas().length; i++){
							System.out.println((i+1)+"° - "+p.getDisciplinas()[i]);
						}
					}

					System.out.println();
					System.in.read();
				}
					
				if(!listaAlunos.isEmpty()){
					System.out.printf("**ALUNOS**\n\n");
					
					for (Aluno a : listaAlunos){
						System.out.println("Nome: "+a.getNome());
						System.out.println("RA: "+a.getRa());
						System.out.println("Curso: "+a.getCurso());
						System.out.println();
					}
					
					System.out.println();
					System.in.read();
				}
			}
			
		}while(opcao > 0 && opcao < 5);
		
		
	}	

}
