package br.com.caelum.contas.modelo;

public class ContaCorrente extends Conta implements Tributavel {
	@Override
	public void saca(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Você tentou sacar" + " um valor negativo");
		}	
		if (this.getSaldo() < valor) {
			throw new SaldoInsuficienteException(valor);
		}
		super.setSaldo(super.getSaldo() - (valor + 0.10));
	}

	@Override
	public String getTipo() {
		return "Conta Corrente";
	}

	public double getValorImposto() {
		return this.getSaldo() * 0.01;
	}
}
