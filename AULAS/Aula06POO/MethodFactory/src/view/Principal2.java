package view;

import controller.BatalhaFactory;
import controller.BatalhaNivelDois;
import controller.BatalhaNivelTres;
import controller.BatalhaNivelUm;
import model.NPC;
import model.NPCNivelDois;
import model.NPCNivelTres;
import model.NPCNivelUm;
import model.Personagem;

public class Principal2 {
	public static void main(String[] args) {
		Personagem p = new Personagem();
		p.setId(1);
		p.setNome("Personagem zé");
		p.setEnergia(300);
		p.setNivel(1);
		p.setArma("Espada");
		
		NPC npc = null;
		
		switch (p.getNivel()) {
		case 1:
			BatalhaFactory batNivUm = new BatalhaNivelUm();
			batNivUm.inicioBatalha(p);
			npc = batNivUm.npcBatalha();
			break;
		case 2:
			BatalhaFactory batNivDois = new BatalhaNivelDois();
			batNivDois.inicioBatalha(p);
			npc = batNivDois.npcBatalha();
			break;
		case 3:
			BatalhaFactory batNivTres = new BatalhaNivelTres();
			batNivTres.inicioBatalha(p);
			npc = batNivTres.npcBatalha();
			break;
		default:
			BatalhaFactory batNivUmm = new BatalhaNivelUm();
			batNivUmm.inicioBatalha(p);
			npc = batNivUmm.npcBatalha();
			break;
		}
		
		System.out.println(npc);
	}
}
