package controller;

import model.NPC;
import model.Personagem;

public abstract class BatalhaFactory {
	
	public void inicioBatalha(Personagem p) {
		System.out.println("Inicio batalha nível " + p.getNivel());
	}
	
	public abstract NPC npcBatalha();
	
}
