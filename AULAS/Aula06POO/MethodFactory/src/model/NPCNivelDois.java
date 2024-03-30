package model;

public class NPCNivelDois extends NPC {
	private int autocura;

	public NPCNivelDois() {
		super();
	}

	public int getAutocura() {
		return autocura;
	}

	public void setAutocura(int autocura) {
		this.autocura = autocura;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("===================NPC Nível 2 ====================== \n");
		buffer.append("ID:= "+getId()+"\n");
		buffer.append("Arma:= "+getArma()+"\n");
		buffer.append("Energia:= "+getEnergia()+"\n");
		buffer.append("Magia:= "+autocura+"\n");
		buffer.append("=========================================================");
		return buffer.toString();
	}
	
	
	
}
