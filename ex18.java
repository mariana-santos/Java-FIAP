package exercicios;

import java.util.Scanner;

public class ex18 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double v, v0, a, t;
		
		System.out.println("Digite a aceleração do veículo em m/s² ");
		a = in.nextDouble();
		
		System.out.println("Digite a velocidade inicial do veículo em m/s ");
		v0 = in.nextDouble();
		
		System.out.println("Digite o tempo de percurso em segundos ");
		t = in.nextDouble();
		
		//Fórmula velocidade final
		v = v0 + a*t;
		
		//Transformando em km/h
		v = v * 3.6;
		
		System.out.printf("Velocidade final: "+v+"km/h");
		
		if(v <= 40) {
			System.out.println("Veículo muito lento");
		}else if(v > 40 && v <= 60){
			System.out.println("Velocidade permitida");
		}else if(v > 60 && v <= 80) {
			System.out.println("Velocidade de cruzeiro");
		}else if(v > 80 && v <= 120) {
			System.out.println("Veículo rápido");
		}else {
			System.out.println("Veículo muito rápido");
		}
	}
}
