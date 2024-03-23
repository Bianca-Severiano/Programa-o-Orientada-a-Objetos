package model;

import bilbioteca.fila.dinamica.generica.model.Lista;

public class Playlist {
	
	private String dono;
	private Lista<Musica> playlist = new Lista<>();
	
	
	public Playlist(String dono) {
		super();
		this.dono = dono;
	}


	public String getDono() {
		return dono;
	}


	public void setDono(String dono) {
		this.dono = dono;
	}


	public Lista<Musica> getPlaylist() {
		return playlist;
	}
	
	public void adicionarMusica(Musica musica) throws Exception {
		playlist.addFirst(musica);
	}

	public void tocarMusicas() throws Exception {
		Musica musica;
		int tamanho = playlist.size();
		do {
			musica = playlist.get(tamanho-1);
			System.out.println("Tocando: " + musica.getNome() + " - " + musica.getAutor() + "( " + musica.getGravadora() + ")");
			tamanho--;
		} while (tamanho != 0);
	}
	
	public void tocarMusicasAleatorio() throws Exception {
		Musica musica;
		Lista<Musica> playlistaux = new Lista<>();
		int tamanho = playlist.size();
		do {
			int index = (int) (Math.random() * (tamanho));
			musica = playlist.get(index);
			System.out.println("Tocando: " + musica.getNome() + " - " + musica.getAutor() + "( " + musica.getGravadora() + ")");
			playlist.remove(index);
			playlistaux.addFirst(musica);
			tamanho--;
		} while (tamanho != 0);
		
		playlist = playlistaux;
	}
	
}
