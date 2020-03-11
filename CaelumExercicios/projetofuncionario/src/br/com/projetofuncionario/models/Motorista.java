package br.com.projetofuncionario.models;

public class Motorista extends Funcionario {
	
	public Motorista(int id, String nome) {
		super(id, nome);
	}

	private int cnh;

	public int getCnh() {
		return cnh;
	}

	public void setCnh(int cnh) {
		this.cnh = cnh;
	}
}
