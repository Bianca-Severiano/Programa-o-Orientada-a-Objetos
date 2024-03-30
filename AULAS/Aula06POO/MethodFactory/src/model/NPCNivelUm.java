package model;

public class NPCNivelUm extends NPC{
	private int magia;

	public NPCNivelUm() {
		super();
	}

	public int getMagia() {
		return magia;
	}

	public void setMagia(int magia) {
		this.magia = magia;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("===================NPC Nível 1 ====================== \n");
		buffer.append("ID:= "+getId()+"\n");
		buffer.append("Arma:= "+getArma()+"\n");
		buffer.append("Energia:= "+getEnergia()+"\n");
		buffer.append("Magia:= "+magia+"\n");
		buffer.append("=========================================================");
		return buffer.toString();
	}
	
	
	
	
	
}
