package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.Calculo;

public class UsaCalculo {

	public static void main(String[] args) {


		try {
			double x = Double.parseDouble(args[0]);
			double y = Double.parseDouble(args[1]);
			System.out.println("Somando: " + Calculo.soma(x, y));
			System.out.println("Multiplicando: " + Calculo.multiplica(x, y));
			System.out.println("Dividindo: " + Calculo.divide(x, y));
			System.out.println("Subtraindo: " + Calculo.subtrai(x, y));
		} catch (Exception e) {
			System.out.println("Deve ser digitado números");
		}	

	}
}
