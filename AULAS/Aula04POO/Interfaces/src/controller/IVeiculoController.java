package controller;

import model.Veiculo;

public interface IVeiculoController {
	
	public void ligarVeiculo (Veiculo veiculo);
	public void acelerarVeiculo (Veiculo veiculo);
	public void pararVeiculo(Veiculo veiculo);
	
}
