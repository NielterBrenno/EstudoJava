class BalancoTrimestral{
	public static void main(String Arg[]){
		int gastosJaneiro = 15000;
		int gastosFevereiro = 23000;
		int gastosMarco = 17000;
		int gastosTrimestre = gastosJaneiro + gastosFevereiro + gastosMarco;		
		
		double mediaMensal = gastosTrimestre / 3;

		System.out.println("------------------------------------");
		System.out.println("| Gastos Trimestre: " +gastosTrimestre + "          |");
		System.out.println("|     Média Mensal: " +mediaMensal + "        |");
		System.out.println("------------------------------------");

	}


}
