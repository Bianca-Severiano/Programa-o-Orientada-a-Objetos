package view;

import model.Automovel;

public class TesteAutomovel {

	public static void main(String[] args) {
		Automovel automovel = new Automovel ("aaaaa", "Fiat", 150);
		
		System.out.println(automovel.getPlaca());

	}

}
