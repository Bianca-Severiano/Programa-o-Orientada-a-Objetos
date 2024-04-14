package controller;

import java.util.ArrayList;

import model.Atividade;

public class AtividadeController implements IAvaliacoes<Atividade> {

	private ArrayList<Atividade> listaAtividades;
	
	
	public AtividadeController() {
		 this.listaAtividades = new ArrayList<>();
	}


	@Override
	public void addAvaliacao(Atividade atividade) {
		listaAtividades.add(atividade);
	}


	@Override
	public void removeAvaliacao(Atividade atividade) {
		listaAtividades.remove(atividade);
	}


	@Override
	public Atividade localizaAvaliacao(int index) {
		return listaAtividades.get(index);
	}


	@Override
	public void limpaLista() {
		listaAtividades.clear();
	}


	@Override
	public void mostraLista() {
        for (Atividade atividade : listaAtividades ) {
            System.out.println(atividade.toString());
        }
		
	}

	

}
