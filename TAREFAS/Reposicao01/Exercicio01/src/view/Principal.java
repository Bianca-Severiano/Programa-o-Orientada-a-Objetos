package view;

import model.Ingresso;
import model.VIP;

public class Principal {
	public static void main(String[] args) {
		Ingresso ingresso = new Ingresso();
		ingresso.setIdentificador("1a");
		ingresso.setValor(10f);
		ingresso.dados();
		System.out.println(ingresso.valorFinal(0.1f)+ "\n=================");
		VIP ingressoVIP = new VIP();
		ingressoVIP.setIdentificador("1b");
		ingressoVIP.setFuncComprador("analista");
		ingressoVIP.setValor(10f);
		ingressoVIP.dados();
		System.out.println(ingressoVIP.valorFinal(0.1f));
		
		
	
		
	}
}
