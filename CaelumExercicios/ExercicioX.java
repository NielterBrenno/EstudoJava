class ExercicioX{
	public static void main(String Arg[]){
		//Imprima todos os numeros de 150 a 300
		System.out.println("\nImprima todos os numeros de 150 a 300");			
		for(int x = 150;x<=300;x++){  
			System.out.println(x);	
		}

		//Imprima soma de 1 a 1000	
		System.out.println("\nImprima soma de 1 a 1000");			
		int soma = 0;
		int j = 0;
		while (j <= 1000) {
			soma = soma + j;
			j = j + 1;  
		}
		System.out.println(soma);	

		//Imprima todos os multiplos de 3, entre 1 e 100
		System.out.println("\nImprima todos os multiplos de 3, entre 1 e 100");			
		for(int x = 1;x<=100;x++){
			if(x % 3 == 0){  
				System.out.println(x);
			}
		}
		//Imprima o fatorial de 1 e 10
		System.out.println("\nImprima o fatorial de 1 e 10");					
		int fatorial = 10;
		for(int x = 10;x>1;x--){
			fatorial = fatorial *(x-1);
			System.out.println(fatorial);
		}

		//Imprima o fatorial de 1 e 40
		System.out.println("\nImprima o fatorial de 1 e 10");					
		double fatorialCompleto = 40;
		for(int x = 40;x>1;x--){
			fatorialCompleto = fatorialCompleto *(x-1);
			System.out.println(fatorialCompleto);
		}		
	}
}
