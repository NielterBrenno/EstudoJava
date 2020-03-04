class Conta{
	String titular;
	int numero;
	String agencia;
	double saldo;
	String dataAbertura;

	void saca(double valor){	
		saldo -= valor;	
	}	
	
	void deposita(double valor){
		saldo += valor;	
	}	

	double calculaRendimento(){
		return saldo * 0.1;	
	}	

	String recuperarDadosParaImpressao(){
		return "\n\t|Nome:          " + titular + 
			   "\n\t|Conta:         " + numero +
			   "\n\t|Agencia:       " + agencia + 
			   "\n\t|Saldo:         " + saldo + 
			   "\n\t|Data Abertura: " + dataAbertura;	
	}	
}
