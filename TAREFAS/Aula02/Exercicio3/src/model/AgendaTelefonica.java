package model;

import bilbioteca.fila.dinamica.generica.model.Lista;

public class AgendaTelefonica {
	private Lista<Contato> agendaTelefonica = new Lista<>();
	
	public void adicionarContato(Contato contato) {
		agendaTelefonica.addFirst(contato);
	}
	
	public Contato buscarContato (String nome) throws Exception {
		int tamanho = agendaTelefonica.size();
		Contato contato = new Contato(null, null, null);
		while (tamanho != 0) {
			if (agendaTelefonica.get(tamanho-1).getNome() == nome) {
				contato = agendaTelefonica.get(tamanho-1);
			}
			tamanho--;
		}	
		return contato;
	}
	
	public void removerContato(String nome) throws Exception {
		Contato contato = buscarContato(nome);
		if (contato.getNome() == null) {
			System.out.println("Contato não localizado");
		} else {
			int tamanho = agendaTelefonica.size();
			while (tamanho != 0) {
				if (agendaTelefonica.get(tamanho-1).getNome() == contato.getNome()) {
					 agendaTelefonica.remove(tamanho-1);
				}
				tamanho--;
			}	
		}
		
	}

	public Lista<Contato> getAgendaTelefonica() {
		return agendaTelefonica;
	}

	
	
	
	
	
}
