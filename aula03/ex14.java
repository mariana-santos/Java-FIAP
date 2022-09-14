package exercicios;

import java.util.Scanner;

public class ex14 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		double peso, altura, imc;
		
		System.out.println("Digite seu peso");
		peso = in.nextDouble();
		
		System.out.println("Digite sua altura");
		altura = in.nextDouble();
		
		imc = peso / (altura * altura);
		
		if(imc < 20){
			System.out.println("Abaixo do peso");
		}
		else if(imc < 25){
			System.out.println("Peso ideal");
		}else{
			System.out.println("Abaixo do peso");
		}

	}

}
