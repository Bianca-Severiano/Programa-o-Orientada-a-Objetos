package view;

import model.Musica;
import model.Playlist;

public class Principal {

	public static void main(String[] args) throws Exception {
		Musica m1 = new Musica("Musica 1", "Autor 1", "Gravadora 1");
		Musica m2 = new Musica("Musica 2", "Autor 2", "Gravadora 2");
		Musica m3 = new Musica("Musica 3", "Autor 3", "Gravadora 3");
		Musica m4 = new Musica("Musica 4", "Autor 4", "Gravadora 4");
		
		Playlist playlist = new Playlist("Bianca");
		playlist.adicionarMusica(m1);
		playlist.adicionarMusica(m2);
		playlist.adicionarMusica(m3);
		playlist.adicionarMusica(m4);
		
		playlist.tocarMusicas();
		
		System.out.println("--------------------------");
		
		playlist.tocarMusicasAleatorio();

	}

}
