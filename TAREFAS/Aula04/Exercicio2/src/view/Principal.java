package view;

import controller.EstudanteSuperiorController;
import controller.EstudanteTecnicoController;
import model.EstudanteSuperior;
import model.EstudanteTecnico;

public class Principal {
	public static void main(String[] args) {
		EstudanteSuperior es = new EstudanteSuperior();
		EstudanteSuperiorController esController = new EstudanteSuperiorController();
		EstudanteTecnico et = new EstudanteTecnico();
		EstudanteTecnicoController etController = new EstudanteTecnicoController();
		
		es.setNome("AlunoSuperior1");
		es.setEmail("a@gmail.com");
		es.setRa("1234567");
		es.setAnoConclusaoSG(2017);
		es.setInstituicaoSG("Escola a");
		es.setMediaNotas(9.56f);
		es.setQtdAprovacoes(4);
		
		System.out.println(esController.calcPercentualProgressao(es));
		System.out.println(esController.calcPercentualRendimento(es));
		
		System.out.println("----------------------------------------");
		
		et.setNome("AlunoTecnico1");
		et.setEmail("b@gmail.com");
		et.setRa("2234568");
		et.setMediaNotas(9.56f);
		et.setQtdAprovacoes(3);
		
		System.out.println(etController.calcPercentualProgressao(et));
		System.out.println(etController.calcPercentualRendimento(et));
		
	}	
}
