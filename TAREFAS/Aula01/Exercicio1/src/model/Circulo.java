package model;

public class Circulo {
	public double raio;

	public Circulo(double raio) {
		this.raio = raio;
	}

	public double getPerimetro() {
		double perimetro = (2 * Math.PI * raio);
		return perimetro;
	}

	public double getArea() {
		double area = (Math.pow(raio, 2)) * Math.PI;
		return area;
	}
}
