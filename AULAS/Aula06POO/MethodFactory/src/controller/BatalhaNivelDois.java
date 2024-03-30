package controller;

import model.NPC;
import model.NPCNivelDois;

public class BatalhaNivelDois extends BatalhaFactory {

	public BatalhaNivelDois() {
		super();
	}

	@Override
	public NPC npcBatalha() {
		NPCNivelDois npc2 = new NPCNivelDois();
		int id2 = (int) ((Math.random() * 10001) + 10000);
		npc2.setId(id2);
		npc2.setArma("Machado");
		npc2.setEnergia(100);
		npc2.setAutocura(20);
		return npc2;
	}

	
}
