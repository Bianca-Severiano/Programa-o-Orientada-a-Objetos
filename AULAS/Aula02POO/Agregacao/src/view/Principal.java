package view;

import java.util.Iterator;

import bilbioteca.fila.dinamica.generica.model.Lista;
import model.Jogador;
import model.Time;

public class Principal {

	public static void main(String[] args) {
	
		Lista<Jogador> jogadores = new Lista<>();
		
		Jogador j1 = new Jogador();
		j1.setNome("Jogador1");
		j1.setPosicao("Atacante");
		
		Jogador j2 = new Jogador();
		j2.setNome("Jogador2");
		j2.setPosicao("Meia");
		
		jogadores.addFirst(j1);
		try {
			jogadores.addLast(j2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Time time = new Time();
		time.setCidade("Londres");
		time.setNome("Time a");
		time.setJogadores(jogadores);
		
		System.out.println(time.getNome());
		System.out.println(time.getCidade());
		
		int tamanho = time.getJogadores().size();

		for (int i = 0; i < tamanho; i++) {
			try {
				Jogador jogador = time.getJogadores().get(i);
				System.out.println(jogador.getNome() + " -  " + jogador.getPosicao() );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
