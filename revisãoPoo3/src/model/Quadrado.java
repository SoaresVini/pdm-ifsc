package model;

public class Quadrado extends Retangulo{

Double altura;
Double largura;

public Quadrado() {
	super();
	
}
	
public Quadrado(Double altura, Double largura) {
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
	// TODO Auto-generated method stub
	return super.area();
}

@Override
public double perimetro() {
	// TODO Auto-generated method stub
	return super.perimetro();
	}
	
}
