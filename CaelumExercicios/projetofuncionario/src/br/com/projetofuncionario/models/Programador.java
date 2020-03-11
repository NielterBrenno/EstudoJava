package br.com.projetofuncionario.models;

public class Programador extends Funcionario {
	private String linguagem;

	public Programador(int id, String nome, String ling) {
		
		super(id, nome);
		this.linguagem = ling;
		
	}

	public String getLinguagem() {
		return linguagem;
	}

	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}
}
