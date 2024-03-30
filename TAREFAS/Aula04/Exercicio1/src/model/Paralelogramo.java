package model;

public class Paralelogramo extends Quadrilatero {

	public Paralelogramo() {
		super();
	}

	@Override
	public float calcArea() {
		float resultado;
		resultado = getAltura() * getBase();
		return resultado;
	}

	@Override
	public float calcPerimetro() {
		float lado = (float) (getAltura()/(Math.sqrt(2)/2));
		System.err.println(lado);
		float soma = (getBase() + lado);
		return 2*soma; 
	}

}
