package model;

public class Retangulo extends Forma{

	Double altura, largura;

	public Retangulo() {
		super();
	}

	public Retangulo(Double altura, Double largura) {
		super();
		this.altura = altura;
		this.largura = largura;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	@Override
	public double area() {
		
		Double area = altura * largura;
		
		return area;
	}

	@Override
	public double perimetro() {
		Double perimetro = 2*(altura*largura);
		return perimetro;
	}

	@Override
	public String toString() {
		return "Retangulo [area()=" + area() + ", perimetro()=" + perimetro() + "]";
	}
	

}
