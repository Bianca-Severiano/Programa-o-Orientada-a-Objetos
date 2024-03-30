package model;

public class EstudanteSuperior extends Estudante {
	
	private String instituicaoSG;
	private int anoConclusaoSG;
	
	public EstudanteSuperior() {
		super();
	}

	public String getInstituicaoSG() {
		return instituicaoSG;
	}

	public void setInstituicaoSG(String instituicaoSG) {
		this.instituicaoSG = instituicaoSG;
	}

	public int getAnoConclusaoSG() {
		return anoConclusaoSG;
	}

	public void setAnoConclusaoSG(int anoConclusaoSG) {
		this.anoConclusaoSG = anoConclusaoSG;
	}

	
}
