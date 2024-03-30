package view;

import controller.BatalhaController;
import model.NPC;
import model.Personagem;

public class Principal {
	public static void main(String[] args) {
		Personagem p = new Personagem();
		p.setId(1);
		p.setNome("Personagem zé");
		p.setEnergia(300);
		p.setNivel(3);
		p.setArma("Espada");
		
		BatalhaController bCont = new BatalhaController();
		bCont.inicioBatalha(p);
		NPC npc = bCont.npcBatalha(p);
		System.out.println(npc);
	}
}
