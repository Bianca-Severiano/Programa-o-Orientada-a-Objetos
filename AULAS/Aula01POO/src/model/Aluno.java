package model;

public class Aluno {
	
	private float nota1;
	private float nota2;
	private float nota3;
	private int presencas;
	
	public Aluno() {
		nota1 = 0.0f;
        nota2= 0.0f;
        nota3 = 0.0f;
        presencas = 0;
	}
	
//	public Aluno (float nota1, float nota2, float nota3, int presencas) {
//		this.nota1 = nota1;
//		this.nota2 = nota2;
//		this.nota3 = nota3; 
//		this.presencas = presencas;	
//	}
	
	public float getMedia() {
		float media = (nota1 + nota2 + nota3)/3;
		return media;
	}
	
	public String getSituacao() {
		float media = getMedia();
		if (media >= 6.0f && presencas >= 60) {
			return "Aprovado";
		} else {
			return "Reprovado";
		}
	}
	
	public float getNota1() {
		return nota1;
	}
	
	public void setNota1(float nota1) {
		if (nota1 < 0.0f) {
			this.nota1 = 0.0f;
		} else {
			this.nota1 = nota1;
		}
	}
	
	
	public float getNota2() {
		return nota2;
	}
	
	public void setNota2(float nota2) {
		if (nota2 < 0.0f) {
			this.nota2 = 0.0f;
		} else {
			this.nota2 = nota2;
		}
	}
	
	
	public float getNota3() {
		return nota3;
	}
	
	public void setNota3(float nota3) {
		if (nota3 < 0.0f) {
			this.nota3 = 0.0f;
		} else {
			this.nota3 = nota3;
		}
	}
	
	public int getPresenca() {
		return presencas;
	}
	
	public void setPresencas(int presencas) {
		if (presencas < 0) {
			this.presencas = 0;
		} else {
			this.presencas = presencas;
		}
	}
}
