
public class Livro {
	
	String nome;
	String descricao;
	private double Valor;
	String isbn;
	Autor autor;
	
	public Livro(){
		System.out.println("Novo Livro Criado");
	}
	
	boolean temAutor(){
		return this.autor != null;
	}

	
	
	void mostrarDetralhes() {
		
		System.out.println("Mostrando Detralhes do Livro");
		System.out.println("Nome: "+nome);
		System.out.println("Descri��o: "+descricao);
		System.out.println("Valor: "+Valor);
		System.out.println("ISBN: "+isbn);
		
		if (this.temAutor()) {
			
			autor.mostrarDetalhes();
				
		}
		System.out.println("--");
		
		
	
		
	}
	
	public void aplicaDescontoDe(double porcentagem){
		if (porcentagem > 0.3) {
			System.out.println("Desconto n�o pode ser maior do que 30%");
		}
		
		this.Valor -= this.Valor * porcentagem;
	
	}
}
