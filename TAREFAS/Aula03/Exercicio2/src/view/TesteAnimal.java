package view;

import model.Animal;
import model.Mamifero;
import model.Peixe;

public class TesteAnimal {

	public static void main(String[] args) {
		Animal camelo = new Animal();
		Peixe tubarao = new Peixe();
		Mamifero urso = new Mamifero();
		
		camelo.setNome("Camelo");
		camelo.setComprimento(150);
		camelo.setCor("Amarelo");
		camelo.setAmbiente("Terra");
		camelo.setVelocidade(2.0f);
		
		tubarao.setNome("Tubarão");
		tubarao.setComprimento(300);
		tubarao.setVelocidade(1.5f);
		
		
		urso.setNome("Urso do Canadá");
		urso.setComprimento(180);
		urso.setCor("Vermelho");
		urso.setVelocidade(0.5f);
		urso.setComidaFavorita("Mel");
		
		camelo.dados();
		tubarao.dados();
		urso.dados();

	}

}
