package br.com.projetofuncionario.main;

import br.com.projetofuncionario.models.Motorista;
import br.com.projetofuncionario.models.Programador;

public class UsaFuncionario {
	
	public static void main(String[] args) {
	
	Programador p = new Programador(289, "Ana","php");
	
	Motorista m = new Motorista(2,"pedro");
	
	System.out.println(p.getId());
	
	}


}
