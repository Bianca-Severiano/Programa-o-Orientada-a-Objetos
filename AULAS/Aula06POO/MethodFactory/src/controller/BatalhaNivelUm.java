package controller;

import model.NPC;
import model.NPCNivelUm;

public class BatalhaNivelUm extends BatalhaFactory{

	
	public BatalhaNivelUm() {
		super();
	}

	@Override
	public NPC npcBatalha() {
		NPCNivelUm npc1 = new NPCNivelUm();
		int idl = (int) ((Math.random() * 1001) + 1000);
		npc1.setId(idl);
		npc1.setArma("Espada");
		npc1.setEnergia(100);
		npc1.setMagia(10);
		return npc1;
	}

}
