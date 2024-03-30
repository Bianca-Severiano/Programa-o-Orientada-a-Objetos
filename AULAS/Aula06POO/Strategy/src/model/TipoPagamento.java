package model;

public enum TipoPagamento {
	CARTÃO("cartao"),
	PIX("pix"),
	DINHEIRO("dinheiro");
	
	private String tipo;
	
	TipoPagamento(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}


	

	
	
	
}
