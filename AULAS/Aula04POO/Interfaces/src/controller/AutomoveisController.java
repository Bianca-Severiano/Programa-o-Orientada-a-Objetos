package controller;

import model.Veiculo;

public class AutomoveisController implements IVeiculoController {

	public AutomoveisController() {
		super();	
	}

	@Override
	public void ligarVeiculo(Veiculo veiculo) {
		System.out.println("Girando a chave para dar a partida no " + veiculo.getMarca() + " " + veiculo.getModelo());
		
	}

	@Override
	public void acelerarVeiculo(Veiculo veiculo) {
		System.out.println("Acelerando o automóvel " + veiculo.getMarca() + " " + veiculo.getModelo());
		veiculo.ateCemPorHora();
		
	}

	@Override
	public void pararVeiculo(Veiculo veiculo) {
		System.out.println("Pisando na embreagem e no freio para reduzir a velocidade do " + veiculo.getMarca() + " " + veiculo.getModelo()+ " até parar");
		
	}
	
	
}
