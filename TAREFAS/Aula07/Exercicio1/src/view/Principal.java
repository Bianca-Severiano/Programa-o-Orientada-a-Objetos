package view;

import controller.AtividadeController;
import controller.ProvaController;
import model.Atividade;
import model.Prova;

public class Principal {

	public static void main(String[] args) {
		AtividadeController atividade = new AtividadeController();
		ProvaController prova = new ProvaController();
		
		System.out.println("--------ATIVIDADES--------");
		for (int i = 0; i < 5; i++) {
			 Atividade atv = new Atividade("Tarefa x".toCharArray(), (int) (Math.random() * 9 + 1));
			 atividade.addAvaliacao(atv);
		}
		
		atividade.mostraLista();
		atividade.removeAvaliacao(atividade.localizaAvaliacao(3));
		System.out.println("----------------");
		atividade.mostraLista();
		atividade.limpaLista();
		System.out.println("----------------");
		atividade.mostraLista();
		System.out.println("----------------");
		
		System.out.println("--------PROVAS--------");
		for (int i = 0; i < 5; i++) {
			Prova prv = new Prova((int)(Math.random() * 6 + 5), (float)(Math.random() * 10.01));
			prova.addAvaliacao(prv);
		}
		
		prova.mostraLista();
		prova.removeAvaliacao(prova.localizaAvaliacao(3));
		System.out.println("----------------");
		prova.mostraLista();
		prova.limpaLista();
		System.out.println("----------------");
		prova.mostraLista();
		System.out.println("----------------");
		
		

	}

}
