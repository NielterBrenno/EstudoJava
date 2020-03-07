package br.com.caelum.contas;

import br.com.caelum.javafx.api.main.SistemaBancario;
import br.com.caelum.javafx.api.main.TelaDeContas;

public class TestaContas {

	public static void main(String[] args) {
		SistemaBancario.mostraTela(false);
		//TelaDeContas.main(args);
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * Conta c = new Conta("nielter");
	 * 
	 * c.setNumero(123); c.setAgencia("45678-9"); c.setSaldo(50.0);
	 * 
	 * c.deposita(100.0);
	 * 
	 * Conta c2 = new Conta(); c2.setTitular("Hugi");
	 * 
	 * Conta c3 = new Conta(); c3.setTitular("joão");
	 * 
	 * System.out.println("\n\t|Saldo Atual: " + c.getSaldo());
	 * 
	 * System.out.println(c.recuperarDadosParaImpressao());
	 * 
	 * System.out.println("\n\t|Valor Identificador: " + Conta.getIdentificador());
	 * 
	 * }
	 */

}
