package br.com.caelum.contas;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;
import br.com.caelum.javafx.api.util.Evento;

public class ManipuladorDeContas {

	Conta conta;;

	public void criaConta(Evento evento) {
		String tipo = evento.getSelecionadoNoRadio("tipo");
		if (tipo.equals("Conta Corrente")) {
			this.conta = new ContaCorrente();
		} else if (tipo.equals("Conta Poupança")) {
			this.conta = new ContaPoupanca();
		}
		this.conta.setTitular(evento.getString("titular"));
		this.conta.setAgencia(evento.getString("agencia"));
		this.conta.setNumero(evento.getInt("numero"));
	}

	public void deposita(Evento evento) {
		double valor = evento.getDouble("ValorOperacao");
		this.conta.deposita(valor);
	}

	public void saca(Evento evento) {
		double valor = evento.getDouble("ValorOperacao");
			this.conta.saca(valor);
	}
}
