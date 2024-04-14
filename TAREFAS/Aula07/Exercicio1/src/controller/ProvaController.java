package controller;

import java.util.ArrayList;

import model.Prova;

public class ProvaController implements IAvaliacoes<Prova> {
	
	private ArrayList<Prova> listaProvas;

	public ProvaController() {
		listaProvas = new ArrayList<>();
	}

	@Override
	public void addAvaliacao(Prova prova) {
		listaProvas.add(prova);
	}

	@Override
	public void removeAvaliacao(Prova prova) {
		listaProvas.remove(prova);
		
	}

	@Override
	public Prova localizaAvaliacao(int index) {
		 return listaProvas.get(index);
	}

	@Override
	public void limpaLista() {
		listaProvas.clear();
	}

	@Override
	public void mostraLista() {
		for (Prova prova : listaProvas) {
			System.out.println(prova.toString());
		}
		
	}
	
	
}
