package br.com.caelum.contas.modelo;

/**
 * Classe responsável por moldar as Contas do Banco
 * 
 * @author Nielter Brenno Batista Cirqueira
 *
 */


public abstract class Conta implements Comparable<Conta> {
	private double saldo;
	private String titular;
	private int numero;
	private String agencia;
	private static int identificador;


	public abstract String getTipo();

	public void saca(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Você tentou " + " um valor negativo");
		} else {	
			saldo -= valor;
		}	
	}

	public void deposita(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Você tentou depositar" + " um valor negativo");
		} else {
			saldo += valor;
		}		
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

	public String toString() {
		return "[titular=" + titular.toUpperCase() + ", numero=" + numero
				+ ",agencia=" + agencia +"]";
	}

	/*
	 * public boolean equals(Object obj) { if (obj == null) { return false; } Conta
	 * outraConta = (Conta) obj; return this.numero == outraConta.numero &&
	 * this.agencia.equals(outraConta.agencia); }
	 */
	
	

	public int compareTo(Conta outraConta) { return
			this.titular.compareTo(outraConta.titular); }


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (numero != other.numero)
			return false;
		return true;
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
