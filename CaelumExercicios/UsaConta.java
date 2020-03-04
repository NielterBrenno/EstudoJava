class UsaConta{
	public static void main(String[]args){
	
		Conta c = new Conta();

		c.titular = "Hugi";
		c.numero = 123;
		c.agencia = "45678-9";
		c.saldo = 50.0;
		c.dataAbertura = "04/06/2015";

		c.deposita(100.0);

		System.out.println("\n\t|Saldo Atual: " + c.saldo);
	
		System.out.println("\t|Saldo Mensal: " + c.calculaRendimento());
	
		System.out.println(c.recuperarDadosParaImpressao());
	
	

		Conta c2 = new Conta();
	
		c2.titular = "Hugi";
		c2.numero = 123;
		c2.agencia = "45678-9";
		c2.saldo = 50.0;
		c2.dataAbertura = "04/06/2015";
	
		//c2 = c;
	
		if (c == c2) {
			System.out.println("\n\t|Iguais");
		} else {
			System.out.println("\n\t|Diferentes");
		}
	}
}
