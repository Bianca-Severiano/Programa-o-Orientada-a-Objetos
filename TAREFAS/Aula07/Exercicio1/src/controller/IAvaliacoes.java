package controller;

public interface IAvaliacoes <T> {

		public void addAvaliacao(T t);
		public void removeAvaliacao(T t);
		public T localizaAvaliacao (int index);
		public void limpaLista();
		public void mostraLista();
	
}
