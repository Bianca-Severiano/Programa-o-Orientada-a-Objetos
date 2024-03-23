package view;

import model.AgendaTelefonica;
import model.Contato;

public class Principal {

	public static void main(String[] args) throws Exception {
		Contato c1 = new Contato("telA", "11-95566581", "A@gmail.com");
		Contato c2 = new Contato("telB", "11-95566581", "B@gmail.com");
		Contato c3 = new Contato("telC", "11-95566581", "C@gmail.com");
		Contato c4 = new Contato("telD", "11-95566581", "D@gmail.com");
		
		AgendaTelefonica agenda = new AgendaTelefonica();
		agenda.adicionarContato(c1);
		agenda.adicionarContato(c2);
		agenda.adicionarContato(c3);
		agenda.adicionarContato(c4);
		
		System.out.println(agenda.getAgendaTelefonica().size());
		
		//localiza
			Contato localizado = agenda.buscarContato("telA");
			if (localizado.getNome() == null) {
				System.out.println("Não localizado");
			} else {
				System.out.println(localizado.getNome() + " - " + localizado.getTelefone());
			}
			
	
		
		// exclui
		agenda.removerContato("telA");
		localizado = agenda.buscarContato("telA");
		if (localizado.getNome() == null) {
			System.out.println("Não localizado");
		} else {
			System.out.println(localizado.getNome() + " - " + localizado.getTelefone());
		}

	}

}
