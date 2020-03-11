package br.com.projetofuncionario.models;

/**
 * @author oo8968
 *
 */
public class Funcionario {
	
	private double salario;
	private String nome;
	private int id;
	private Endereco endereco;

	public Funcionario(int id, String nome) {
		
		this.id = id;
		this.nome = nome;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
