package exercicios;

import java.util.Scanner;

public class ex36 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a, b;
		
//		36. Entrar via teclado com um valor (X) qualquer. Travar a digita��o, no sentido de aceitar somente valores positivos. Solicitar o intervalo que o programa que dever� calcular a tabuada do valor digitado, sendo que o segundo valor (B), dever� ser maior que o primeiro (A), caso contr�rio, digitar novamente somente o segundo. Ap�s a valida��o dos dados, exibir a tabuada do valor digitado, no intervalo decrescente, ou seja, a tabuada de X no intervalo de B para A.

		System.out.println("Digite um n�mero qualquer");
		int x = in.nextInt();
		
//		se for negativo	
		while(x < 0){
			System.out.println("N�mero inv�lido. Somente positivos s�o aceitos");
			System.out.println("Digite um n�mero qualquer");
			x = in.nextInt();
		}
		
		System.out.println("Digite o come�o do intervalo da tabuada: ");
		a = in.nextInt();
		
		System.out.println("Digite o fim do intervalo da tabuada: ");
		b = in.nextInt();
		
		//SE O SEGUNDO N�MERO FOR MENOR
		while(b < a){
			System.out.println("O intervalo n�o pode ser [+{"+a+"}, {"+b+"}]. Digite o segundo valor novamente");
			b = in.nextInt();
		}
		
//		C�LCULO COM WHILE
		int i = b;
		
		System.out.println("Tabuada de "+x+" com while");
		while(i >= a){
			System.out.println(x+" x "+i+" = "+ x * i);
			i--;
		}
		
//		C�LCULO COM FOR
		System.out.println("Tabuada de "+x+" com for");
		for(int c = b; c >= a; c--){
			System.out.println(x+" x "+c+" = "+ x * c);
		}
	}

}
