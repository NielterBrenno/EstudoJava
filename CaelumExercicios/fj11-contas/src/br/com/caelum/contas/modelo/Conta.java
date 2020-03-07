package br.com.caelum.contas.modelo;

/**
 * Classe responsável por moldar as Contas do Banco
 * 
 * @author Nielter Brenno Batista Cirqueira
 *
 */


public class Conta {
	protected double saldo;
	private String titular;
	private int numero;
	private String agencia;
	private static int identificador;
	private String tipo;


	public String getTipo() {
		return "Conta";
	}

	public void saca(double valor) {
		saldo -= valor;
	}

	public void deposita(double valor) {
		saldo += valor;
	}

	public String recuperarDadosParaImpressao() {
		return "\n\t|Nome:          " + titular + "\n\t|Conta:         " + numero + "\n\t|Agencia:       " + agencia
				+ "\n\t|Saldo:         " + saldo;
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
