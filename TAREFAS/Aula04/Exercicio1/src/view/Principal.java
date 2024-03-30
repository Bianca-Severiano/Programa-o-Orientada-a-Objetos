package view;

import model.Paralelogramo;
import model.Trapezio;

public class Principal {

	public static void main(String[] args) {
		Paralelogramo p = new Paralelogramo();
		Trapezio t = new Trapezio();
		
		p.setAltura(5);
		p.setBase(16);
		System.out.println(p.calcArea());
		System.out.println(p.calcPerimetro());
		
		System.out.println("------------------------");
		t.setAltura(4);
		t.setBase(5);
		t.setBaseMenor(3);
		System.out.println(t.calcArea());
		System.out.println(t.calcPerimetro());

	}

}
