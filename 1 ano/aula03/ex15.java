package exercicios;

import java.util.Scanner;

public class ex15 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		double l1, l2, l3;
		
		System.out.println("Digite o primeiro lado");
		l1 = in.nextDouble();
		System.out.println("Digite o segundo lado");
		l2 = in.nextDouble();
		System.out.println("Digite o terceiro lado");
		l3 = in.nextDouble();
		
		if ((l1 + l2 > l3) && (l1 + l3 > l2) && (l3 + l2 > l1)){
			if(l1 == l2 && l2 == l3){
		        System.out.println("Tri�ngulo eq�il�tero");
			}
			else if (l1 != l2 && l2 != l3){
		        System.out.println("Tri�ngulo escaleno");
			}
		    else{
		    	System.out.println("Tri�ngulo is�sceles");
		    }
		}else{
			System.out.println("N�o � um tri�ngulo");
		}

	}

}
