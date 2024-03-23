package model;

import java.util.List;

public class Escola {

	private String name;
	private List<Departamento> dptos;
	
	
	
	
	
	public Escola() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Departamento> getDptos() {
		return dptos;
	}

	public void setDptos(List<Departamento> dptos) {
		this.dptos = dptos;
	}
	
	

}
