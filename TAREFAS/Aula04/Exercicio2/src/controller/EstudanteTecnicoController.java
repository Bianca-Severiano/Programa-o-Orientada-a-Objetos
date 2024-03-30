package controller;

import model.Estudante;

public class EstudanteTecnicoController implements IEstudanteController{

	@Override
	public float calcPercentualRendimento(Estudante estudante) {
		return estudante.getMediaNotas() * estudante.getQtdAprovacoes() * 0.931f;
	}

	@Override
	public float calcPercentualProgressao(Estudante estudante) {
		float aprovacoes = estudante.getQtdAprovacoes() * 100;
		return (aprovacoes/3);
	}

}
