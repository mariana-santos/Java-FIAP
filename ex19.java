package exercicios;

import java.util.Scanner;

public class ex19 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double p1, p2, media;
		
		System.out.println("Digite a primeira nota:");
		p1 = in.nextDouble();
		
		System.out.println("Digite a segunda nota: ");
		p2 = in.nextDouble();
		
		media = (p1 + 2*p2) /3;
		
		if(media >= 5) {
			System.out.printf("Média final %f. Aluno aprovado. :)", media);
		}else {
			System.out.printf("Média final %f. Aluno reprovado. :/", media);
		}
		
	}
}
