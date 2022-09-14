package exercicios;

import java.util.Scanner;

public class ex36 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a, b;
		
//		36. Entrar via teclado com um valor (X) qualquer. Travar a digitação, no sentido de aceitar somente valores positivos. Solicitar o intervalo que o programa que deverá calcular a tabuada do valor digitado, sendo que o segundo valor (B), deverá ser maior que o primeiro (A), caso contrário, digitar novamente somente o segundo. Após a validação dos dados, exibir a tabuada do valor digitado, no intervalo decrescente, ou seja, a tabuada de X no intervalo de B para A.

		System.out.println("Digite um número qualquer");
		int x = in.nextInt();
		
//		se for negativo	
		while(x < 0){
			System.out.println("Número inválido. Somente positivos são aceitos");
			System.out.println("Digite um número qualquer");
			x = in.nextInt();
		}
		
		System.out.println("Digite o começo do intervalo da tabuada: ");
		a = in.nextInt();
		
		System.out.println("Digite o fim do intervalo da tabuada: ");
		b = in.nextInt();
		
		//SE O SEGUNDO NÚMERO FOR MENOR
		while(b < a){
			System.out.println("O intervalo não pode ser [+{"+a+"}, {"+b+"}]. Digite o segundo valor novamente");
			b = in.nextInt();
		}
		
//		CÁLCULO COM WHILE
		int i = b;
		
		System.out.println("Tabuada de "+x+" com while");
		while(i >= a){
			System.out.println(x+" x "+i+" = "+ x * i);
			i--;
		}
		
//		CÁLCULO COM FOR
		System.out.println("Tabuada de "+x+" com for");
		for(int c = b; c >= a; c--){
			System.out.println(x+" x "+c+" = "+ x * c);
		}
	}

}
