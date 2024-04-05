package view;

import controller.ControllerBH;
import controller.ControllerCB;
import controller.ControllerPA;
import controller.ControllerSP;

public class Principal {
	public static void main(String[] args) {
		ControllerBH bh = new ControllerBH();
		ControllerCB cb = new ControllerCB();
		ControllerPA pa = new ControllerPA();
		ControllerSP sp = new ControllerSP();
		
		System.out.println("----------------- Belo Horizonte -----------------");
		System.out.println("O imposto é: " + bh.CalculoImposto() );
		
		System.out.println("-----------------Curitiba -----------------");
		System.out.println("O imposto é: " + cb.CalculoImposto() );
		
		System.out.println("----------------- Porto Alegre -----------------");
		System.out.println("O imposto é: " + pa.CalculoImposto() );
		
		System.out.println("----------------- São Paulo -----------------");
		System.out.println("O imposto é: " + sp.CalculoImposto() );
		
	}
}
