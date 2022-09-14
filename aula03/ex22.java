package exercicios;

import java.util.Scanner;

public class ex22 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int opcao;
		
		System.out.println("1 – Triângulo");
		System.out.println("2 – Quadrado");
		System.out.println("3 – Retângulo");
		System.out.println("4 – Círculo");
		System.out.println("5 – Fim de processo (sair do programa)");
		
		System.out.println("Bem-vindo! Selecione selecione alguma das opções acima para calcular: ");
		opcao = in.nextInt();
		
		double n1, n2;
		
		System.out.println("Digite o primeiro número: ");
		n1 = in.nextDouble();
		
		System.out.println("Digite o segundo número: ");
		n2= in.nextDouble();
		
		switch(opcao) {
			case 1:
				System.out.printf("Resultado: %.1f", n1 * n2);
				break;
			case 2:
				System.out.printf("Resultado: %.1f", n1 + n2);
				break;
			case 3:
				if(n1 != 0) {
					System.out.printf("Resultado: %.1f", n1 / n2);
				}else {
					System.out.println("Divisor inválido");
				}
				break;
			case 4:
				System.out.printf("Resultado: %.1f", n1 - n2);
				break;
			case 5:
				break;
			default:
				System.out.println("Opção inválida");
		}
	}
	
}
