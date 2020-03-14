package br.com.caelum.contas.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class TestaPerformace {
	public static void main(String[] args) {
		System.out.println("Iniciando ...");

		//Collection<Integer> teste = new ArrayList<>();
		Collection<Integer> teste = new HashSet<>();
	
		long inicio = System.currentTimeMillis();
		
		int total = 30000;
		
		for (int i = 0; i < total; i++) {
			teste.add(1);
		}
		
		for (int i = 0; i < total; i++) {
			teste.contains(i);
		}
		
		long fim = System.currentTimeMillis();
		long tempo = fim - inicio;
		System.out.println("Tempo gasto:  " + tempo);
	}

}
