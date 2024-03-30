package model;

public class Trapezio extends Quadrilatero {
	private float baseMenor;

	public Trapezio() {
		super();
	}

	public float getBaseMenor() {
		return baseMenor;
	}

	public void setBaseMenor(float baseMenor) {
		this.baseMenor = baseMenor;
	}

	@Override
	public float calcArea() {
		float resultado;
		resultado = ((baseMenor + getBase()) * getAltura())/2;
		return resultado;
	}

	@Override
	public float calcPerimetro() {
		float lado;
		float alturaquad;
		float b2quad;
		float somaquad;
		float b2;

		b2 = (getBase() - getBaseMenor()) / 2;
		b2quad = (float) Math.pow(b2, 2);
		alturaquad = (float) Math.pow(getAltura(), 2);
		somaquad = b2quad + alturaquad;
		lado = (float) Math.sqrt(somaquad);

		return ((2*lado) + getBase() + getBaseMenor());
	}
	
	
}
