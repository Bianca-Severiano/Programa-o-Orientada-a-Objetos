package view;

import controller.AutomoveisController;
import controller.MotoController;
import model.Automovel;
import model.Moto;

public class Principal {

	public static void main(String[] args) {
		Automovel automovel = new Automovel();
		automovel.setMarca("Renault");
		automovel.setModelo("Sandero");
		automovel.setVelocidadeMaxima(160);
		
		Moto moto = new Moto();
		moto.setMarca("Honda");
		moto.setModelo("Biz");
		moto.setVelocidadeMaxima(130);
		
		AutomoveisController automovelcontroller = new AutomoveisController();
		automovelcontroller.ligarVeiculo(automovel);
		automovelcontroller.acelerarVeiculo(automovel);
		automovelcontroller.pararVeiculo(automovel);
		
		System.out.println("--------------------------------------");
		
		MotoController motocontroller = new MotoController();
		motocontroller.ligarVeiculo(moto);
		motocontroller.acelerarVeiculo(moto);
		motocontroller.pararVeiculo(moto);
		motocontroller.descansaMoto(moto);

	}

}
