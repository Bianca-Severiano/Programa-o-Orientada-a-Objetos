package model;

public class VIP extends Ingresso {
	private String funcComprador;
	
	public VIP() {
		super();
	}

	public String getFuncComprador() {
		return funcComprador;
	}

	public void setFuncComprador(String funcComprador) {
		this.funcComprador = funcComprador;
	}
	
	@Override
	public float valorFinal(float taxaConveniencia) {
		return super.valorFinal(taxaConveniencia) + (getValor()*0.18f) ;
	}
}
