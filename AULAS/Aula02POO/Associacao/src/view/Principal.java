package view;

import model.Cliente;
import model.Endereco;

public class Principal {
	public static void main (String args []) {
		Cliente c = new Cliente();
		c.setNome("Bianca");
		c.setCPF("111222333444");
		
		Endereco endereco = new Endereco();
		endereco.setCEP("08895690");
		endereco.setLograduro("Rua A");
		endereco.setNumero(25);
		
		c.setEndereco(endereco);
		
		System.out.println(c.getNome());
		System.out.println(c.getCPF());
		System.out.println(c.getEndereco().getLograduro());
		
	}
}
