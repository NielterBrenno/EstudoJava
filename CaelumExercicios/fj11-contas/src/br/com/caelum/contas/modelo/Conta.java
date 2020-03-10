package br.com.caelum.contas.modelo;

/**
 * Classe responsável por moldar as Contas do Banco
 * 
 * @author Nielter Brenno Batista Cirqueira
 *
 */


public abstract class Conta {
	private double saldo;
	private String titular;
	private int numero;
	private String agencia;
	private static int identificador;

	
	public abstract String getTipo();

	public void saca(double valor) {
		saldo -= valor;
	}

	public void deposita(double valor) {
		saldo += valor;
	}

	public void transfere(double valor, Conta conta) {
		this.saca(valor);
		conta.deposita(valor);
	}

	public String recuperarDadosParaImpressao() {
		String dados =  "\n\t|Titular:     " + titular;
		dados += 	"\n\t|Numero:      " + numero;
		dados += 	"\n\t|Agencia:     " + agencia;
		dados += 	"\n\t|Saldo:       " + saldo;
		dados += 	"\n\t|Tipo:        " + getTipo();
		return dados;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public Conta() {
		identificador++;
	}

	public Conta(String nome) {
		this.titular = nome;
		identificador++;
	}

	public static int getIdentificador() {
		return identificador;
	}

}
