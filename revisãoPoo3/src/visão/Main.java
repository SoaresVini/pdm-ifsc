package visão;

import java.util.Scanner;

import model.Circulo;
import model.Forma;
import model.Quadrado;
import model.Retangulo;

public class Main {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		
		Integer acao = 0; 
		
		
		while (acao != 4) {
			
			System.out.println("Qual forma você deseja calcular:"
					  + "\n 1-Quadrado" 
					  + "\n 2-Retangulo" 
					  + "\n 3-Circulo"
					  + "\n 4-Sair");
			
			acao = s.nextInt();
			
			s.nextLine();
			
			if (acao == 1) {
				
				System.out.println("Largura: ");
				Double lagura = s.nextDouble();
				
				System.out.println("Altura: ");
				Double altura = s.nextDouble();
				
				Forma quad = new Quadrado(altura, lagura);
				
				quad.perimetro();
				quad.area();
				
				System.out.println(quad);
			
			}else 
				if(acao == 2){
				
					System.out.println("Largura: ");
					Double lagura = s.nextDouble();
						
					System.out.println("Altura: ");
					Double altura = s.nextDouble();
					
					Forma ret = new Retangulo(altura, lagura);
					
					ret.area();
					ret.perimetro();
					
					System.out.println(ret);
		
			}else 
				if(acao == 3) {
					
					System.out.println("Raio: ");
					Double raio = s.nextDouble();
					
					Forma circ = new Circulo(raio);
					
					circ.area();
					circ.perimetro();
					
					System.out.println(circ);
					
				}
			
			System.out.println("Qual forma você deseja calcular:"
					  + "\n 1-Quadrado" 
					  + "\n 2-Retangulo" 
					  + "\n 3-Circulo"
					  + "\n 4-Sair");
			
			acao = s.nextInt();
			
			s.nextLine();
		}
		
		
						  
						 
		

	}

}
