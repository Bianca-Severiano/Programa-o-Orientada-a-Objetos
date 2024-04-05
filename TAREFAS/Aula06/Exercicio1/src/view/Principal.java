package view;

import model.Carga;
import model.Motor;
import model.Passeio;

public class Principal {
	public static void main(String[] args) {
		Motor mp = new Motor();
		mp.setPotencia(100);
		mp.setQtdPis(2);
		
		Motor mc = new Motor();
		mc.setPotencia(50);
		mc.setQtdPis(1);
		
		Passeio p1 = new Passeio ();
		p1.setCor("Branco");
		p1.setMarca("Marca a");
		p1.setModelo("Modelo a");
		p1.setPlaca("abc123");
		p1.setQtdPassageiros(5);
		p1.setQtdRodas(4);
		p1.setVelocMax(200);
		p1.setMotor(mp);
		System.out.println(p1.calcVel(25000));
		
		Passeio p2 = new Passeio ();
		p2.setCor("Branco");
		p2.setMarca("Marca a");
		p2.setModelo("Modelo a");
		p2.setPlaca("abc123");
		p2.setQtdPassageiros(5);
		p2.setQtdRodas(4);
		p2.setVelocMax(200);
		p2.setMotor(mp);
		System.out.println(p2.calcVel(25000));
		
		System.out.println("----------------------------------------");
		Carga c1 = new Carga();
		c1.setCor("Preto");
		c1.setMarca("Marca b");
		c1.setModelo("Modelo b");
		c1.setPlaca("abc444");
		c1.setQtdRodas(4);
		c1.setVelocMax(50);
		c1.setMotor(mc);
		System.out.println(c1.calcVel(25000));
		
		Carga c2 = new Carga();
		c2.setCor("Preto");
		c2.setMarca("Marca b");
		c2.setModelo("Modelo b");
		c2.setPlaca("abc444");
		c2.setQtdRodas(4);
		c2.setVelocMax(50);
		c2.setMotor(mc);
		System.out.println(c2.calcVel(25000));
		
	}
}
