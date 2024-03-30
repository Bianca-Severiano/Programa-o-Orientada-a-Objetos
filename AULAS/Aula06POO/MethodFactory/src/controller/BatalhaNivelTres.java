package controller;

import model.NPC;
import model.NPCNivelTres;

public class BatalhaNivelTres extends BatalhaFactory {

	
	public BatalhaNivelTres() {
		super();
	}

	@Override
	public NPC npcBatalha() {
		NPCNivelTres npc3 = new NPCNivelTres();
		int id3 = (int) ((Math.random() * 100001) + 100000);
		npc3.setId(id3);
		npc3.setArma("Adaga");
		npc3.setEnergia(100);
		npc3.setReplicacao(30);
		return npc3;
	}

}
