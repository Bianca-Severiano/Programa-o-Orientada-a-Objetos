package view;

import controller.ControllerIntegral;
import controller.ControllerTempoParcial;
import controller.ControllerTemporario;
import controller.IFuncionario;
import model.Funcionario;


public class Principal {
	public static void main(String[] args) {
		IFuncionario controller = new ControllerIntegral();
		
		Funcionario func = null;
		func = controller.contratacao();
		System.out.println(func.toString());
		
		controller = new ControllerTempoParcial();
		func = controller.contratacao();
		System.out.println(func.toString());
		
		controller = new ControllerTemporario();
		func = controller.contratacao();
		System.out.println(func);
	}

	
}
