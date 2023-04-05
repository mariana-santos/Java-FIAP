package manipulacao_string;

import java.util.HashMap;
import java.util.Scanner;

public class Exercicio01 {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		
		String alunosVestibular = "Jose dos Santos,7,Sao Paulo;Sandra Silva,6.5,Sao Jose do Rio Preto;Augusto Soares,8,Sao Paulo;Vanderlei Azevedo,5.65,Santos;Vanessa Ferreira,9,Sao Paulo";
		
		String alunos[] = alunosVestibular.split(";");
		
		HashMap<Integer, Aluno> alunos_maior_7  = new  HashMap<Integer, Aluno>();
		
		for (int i = 0; i < alunos.length; i++){
			String campos[] = alunos[i].split(",");
			
			String nome = campos[0];
			double nota = Double.parseDouble(campos[1]);
			String cidade = campos[2];
			
			if(nota >= 7){
				Aluno aluno = new Aluno();
				
				int id = alunos_maior_7.size() + 1;
				
				aluno.setNome(nome);
				aluno.setCidade(cidade);
				aluno.setNota(nota);
				aluno.setId(id);
				
				alunos_maior_7.put(id, aluno);
			}
		}
		
		alunos_maior_7.forEach((key, aluno) -> {
			System.out.println("Nome: "+ aluno.getNome());
			System.out.println("Nota: "+ aluno.getNota());
			System.out.println("Cidade: "+ aluno.getCidade()+ "\n");
		});
	}
}
