package model;

import java.util.List;

import bilbioteca.fila.dinamica.generica.model.Lista;

public class Time {
	private String nome;
	private String cidade;
	private Lista<Jogador> jogadores;

	
	public Time() {
		super();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Lista<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(Lista<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
	
}
