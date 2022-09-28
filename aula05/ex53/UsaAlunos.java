package ex53;
import java.util.Scanner;

public class UsaAlunos {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Aluno[] listaAlunos = new Aluno[5];
		
		for (int i = 0; i < 5; i++){
			
			Aluno a = new Aluno();
			
			System.out.println("Digite o seu RA:");
			a.ra = in.nextLine();
			
			System.out.println("Digite o seu nome:");
			a.nome = in.nextLine();
			
			System.out.println("Digite o período do seu curso:");
			a.periodo = in.nextLine().toLowerCase();
			
			System.out.println("Digite as suas matérias/disciplinas: ");
			String[] mat = new String[6];
			
			for(int j = 0; j < 6; j++){
				System.out.println("Digite a sigla da sua "+(j+1)+"° disciplina");
				mat[j] = in.nextLine();
			}
			
			a.materias = mat;
			
			listaAlunos[i] = a;
		}
		
		System.out.println("Alunos que estudam no período da noite: ");
		for (int i = 0; i < 5; i++){
			if(listaAlunos[i].periodo.equals("noite")){
				System.out.println(listaAlunos[i].ra + ": "+listaAlunos[i].nome);
				
				System.out.print("Matérias: ");
				
				for(int j = 0; j < 6; j++){
					System.out.print(listaAlunos[i].materias[j]+' ');
				}
			}
		}
	}
}
