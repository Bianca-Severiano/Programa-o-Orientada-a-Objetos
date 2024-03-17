package view;

import model.Circulo;

public class Principal {

	public static void main(String[] args) {
		Circulo c1 = new Circulo(5);
		
		double areaC1 = c1.getArea();
		double perimetroC1 = c1.getPerimetro();
		System.out.println("Área: "+areaC1);
		System.out.println("Perímetro: "+perimetroC1);

	}

}
