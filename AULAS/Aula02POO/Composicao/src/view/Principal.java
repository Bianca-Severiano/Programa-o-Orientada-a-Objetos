package view;

import java.util.ArrayList;
import java.util.List;

import model.Departamento;
import model.Escola;

public class Principal {

	public static void main(String[] args) {
		
		
		Departamento d1 = new Departamento();
		Departamento d2 = new Departamento();
		Departamento d3 = new Departamento();
		
		d1.setNome("DTI");
		d2.setNome("URH");
		d3.setNome("Secretaria");
		
		List<Departamento> dptos = new ArrayList<Departamento>();
		dptos.add(d1);
		dptos.add(d2);
		dptos.add(d3);
		
		Escola escola = new Escola();
		escola.setName("Escola A");
		escola.setDptos(dptos);
		
		System.out.println(escola.getName());
		for (Departamento departamento : escola.getDptos()) {
			System.out.println(departamento.getNome());
		}
		

	}

}
