package model;

import java.time.LocalDate;

public class Pessoa {
	private String nome;
	private LocalDate dataNascimento;
	private String profissao;
	
	//get e set NOME
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//get e set PROFISSAO
	public String getProfissao() {
		return profissao;
	}
	
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	//get e set DATA DE NASCIMENTO
	
	public LocalDate getDataNascimento () {
		return dataNascimento;
	}
	
	public void setDataNascimento(int dia, int mes, int ano) {
		LocalDate hoje = null;
		hoje = LocalDate.now();
		int anoL;
		int idade=0;
		
		int hojeDia = hoje.getDayOfMonth();
		int hojeMes = hoje.getMonthValue();
		
		if (dia >= hojeDia && mes <= hojeMes){
			idade = idade + (hoje.getYear() - ano);
		} else {
			idade = (hoje.getYear() - ano) - 1;
		}
			
		
		
		if ( idade > 150) {
			anoL = hoje.getYear() - 150;
			this.dataNascimento = LocalDate.of(anoL, mes, dia);
		} else {
			this.dataNascimento = LocalDate.of(ano, mes, dia);
		}
	}
}
