package exercicios;

import java.util.Scanner;

public class ex28 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int maior, menor, meio;
		
		System.out.println("Insira o primeiro número: ");
		maior = in.nextInt();
		
		System.out.println("Insira o segundo número: ");
		menor = in.nextInt();
		
		System.out.println("Insira o terceiro número: ");
		meio = in.nextInt();
		
		//Verificando o maior
		if(menor > maior && menor > meio) {
			maior = menor;
		}else if(meio > maior && meio > menor){
			maior = meio;
		}
		
		//Verificando o menor
		if(maior < menor && maior < meio) {
			menor = maior;
		}else if(meio < maior && meio < menor){
			menor = meio;
		}
		
		//Verificando o do meio
		if(maior > menor && maior < meio) {
			meio = maior;
		}else if(menor < maior && menor > meio){
			meio = menor;
		}
		
		System.out.println("Números em ordem crescente: "+menor+" - "+meio+" - "+maior);
	}
}
