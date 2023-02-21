package model;

import visão.Main;

public class Circulo extends Forma{
	
	
	private static final Double PI = 3.14159;
	Double raio;
	
	public Double getRaio() {
		return raio;
	}
	public void setRaio(Double raio) {
		this.raio = raio;
	}
	

	public Circulo() {
	
	}
	
	public Circulo(Double raio) {
		super();
		this.raio = raio;
	}
	
	
	@Override
	public double area() {
		
		Double area = PI*(raio*raio);
		
		return area;
	}
	@Override
	public double perimetro() {
		Double perimetro = 2 * PI * raio;
		return perimetro;
	}
	@Override
	public String toString() {
		return "Circulo [area()=" + area() + ", perimetro()=" + perimetro() + "]";
	}

	
}
