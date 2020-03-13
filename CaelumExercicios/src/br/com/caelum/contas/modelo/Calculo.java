package br.com.caelum.contas.modelo;

public class Calculo {



	public static double soma(double x, double y){
		try {
			return x + y;	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
			
	}
	
	public static double multiplica(double x, double y){
		return x * y;	
	}

	public static double divide(double x, double y){
		return x / y;	
	}
	
	public static double subtrai(double x, double y){
		return x - y;	
	}
}
