package view;

import model.Aluno;

public class Principal {

	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		a1.setNota1(7.5f);
		a1.setNota2(6.3f);
		a1.setNota3(8.4f);
		a1.setPresencas(72);
		
		float media = a1.getMedia();
		String situacao = a1.getSituacao();
		
		System.out.println(media);
		System.out.println(situacao);
		System.out.println("---------------------");
		
		Aluno a2 = new Aluno();
		a2.setNota1(3.4f);
		a2.setNota2(5.2f);
		a2.setNota3(2.1f);
		a2.setPresencas(64);
		
		float media2 = a2.getMedia();
		String situacao2 = a2.getSituacao();
//		System.out.println(a2.getNota1());
		System.out.println(media2);
		System.out.println(situacao2);
		System.out.println("---------------------");
	}

}
