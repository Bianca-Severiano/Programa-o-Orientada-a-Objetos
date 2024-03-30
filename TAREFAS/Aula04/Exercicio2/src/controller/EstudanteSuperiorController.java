package controller;

import model.Estudante;

public class EstudanteSuperiorController implements IEstudanteController {

	@Override
	public float calcPercentualRendimento(Estudante estudante) {
		return estudante.getMediaNotas() * estudante.getQtdAprovacoes() * 0.972f;
	}

	@Override
	public float calcPercentualProgressao(Estudante estudante) {
		float aprovacoes = estudante.getQtdAprovacoes() * 100;
		return (aprovacoes/6);
	}

}
