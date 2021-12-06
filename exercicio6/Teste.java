package exercicio6;
import java.lang.NumberFormatException;

public class Teste {
	
	//Usar a classe leitura do exerc�cio anterior
	private static Leitura l = new Leitura();
	
	//Instancia das classes passeio e carga
	private static Passeio passeio =  new Passeio();
	private static Carga carga = new Carga();
	
	public static void main(String[] args) {
		
		boolean continua = true;
		int opcao = 0;
		
		//INFORMAR VE�CULOS
		
		System.out.println("\nOl� usu�rio! Este � um sistema de cadastro de ve�culos ! \nVoc� poder� nos informar at� 5 ve�culos de cada categoria e depois ser� bloqueado."
			+ "\n ##################   Cadastro de ve�culos - Vamos come�ar!?   ##################\n");
		

		// COME�ANDO O MENU //
		
		
		while(continua) {
			
			System.out.println("\n #####  MENU INICIAL #####");
			System.out.println(" 1 - Cadastrar ve�culo Passeio");
			System.out.println(" 2 - Cadastrar ve�culo Carga");
			System.out.println(" 3 - Imprimir ve�culos Passeio");
			System.out.println(" 4 - Imprimir ve�culos Carga");
			System.out.println(" 5 - Imprimir ve�culos de Passeio pela placa");	
			System.out.println(" 6 - Imprimir ve�culos de Carga pela placa");
			System.out.println(" 7 - Sair do sistema");
			
			
			try {
				opcao = Integer.parseInt(l.entDados("\nEscolha uma op��o de 1 a 7"));
			}	
			
			catch(NumberFormatException nfe) {
				System.out.println("Deve ser um valor inteiro - Pressione <Enter>");
				l.entDados("");					
				
			} 
			
			switch(opcao) {
				
				
				case 1: {
					try {
						
						for(int i = BDVeiculos.verificaPosicaoPasseio();i< BDVeiculos.vetorPasseio.length;i++) {
							if(i == -1) {
								l.entDados("\nVetor de Passeio est� cheio  -press <ENTER>");
								break;
							}else {
								
								String placa = "";								
								
								passeio = new Passeio();
								
								try {
									passeio = BDVeiculos.cadastrarPasseio(passeio);
								} catch (VelocException e) {
									e.printStackTrace();
								}	
								

								if (passeio == null ) {								
									VerificaDuplicidadePasseio();
									break;
								}
								
								
								BDVeiculos.vetorPasseio[i] = passeio;
								
								l.entDados("\n\tVe�culo de passeio armazenado na posi��o "+ i +" do vetor, pressione <enter> para ver mais op��es");
								
								String respostaPasseio = l.entDados("\nDeseja cadastrar outro ve�culo de passeio? Digite S para sim e N para n�o");
								
								if(respostaPasseio.equalsIgnoreCase("n")) {
									break;
								}
								
								if(BDVeiculos.verificaPosicaoPasseio() == -1) {
									l.entDados("\nVetor de Passeio est� cheio  -press <ENTER>");
									break;
								}
							}
						}
					}
					
					catch(NumberFormatException nfe) {
						System.out.println("\n##### Deve ser um valor inteiro - Pressione <Enter>#####");
						l.entDados("");					
						
					} 
					
					break;
				}
				
				
				case 2: {
					try {
						
						for(int i = BDVeiculos.verificaPosicaoCarga();i< BDVeiculos.vetorCarga.length;i++) {
							if(i == -1) {
								l.entDados("\nVetor de Carga est� cheio  -press <ENTER>");
								break;
							}else {
								String placa = "";
								
								carga = new Carga();
								
								try {
									carga = BDVeiculos.cadastrarCarga(carga);
								} catch (VelocException e) {
									e.printStackTrace();
								}	
								
								if (carga == null ) {								
									VerificaDuplicidadeCarga();
									break;
								}
								
								
								BDVeiculos.vetorCarga[i] = carga;
								
								l.entDados("\n\tVe�culo de carga armazenado na posi��o "+ i +" do vetor, pressione <enter> para ver mais op��es");
								
								String respostaCarga = l.entDados("\nDeseja cadastrar outro ve�culo de Carga? Digite S para sim e N para n�o");
								
								if(respostaCarga.equalsIgnoreCase("n")) {
									break;
								}
								
								if(BDVeiculos.verificaPosicaoCarga() == -1) {
									l.entDados("\nVetor de Carga est� cheio  -press <ENTER>");
									break;
								}
							}
						}
					}
					
					catch(NumberFormatException nfe) {
						System.out.println("\n##### Deve ser um valor inteiro - Pressione <Enter>#####");
						l.entDados("");					
						
					} 
					
					break;
				}
				
				
				case 3:
				for (int i=0; i < BDVeiculos.vetorPasseio.length; i++) {
					if(BDVeiculos.vetorPasseio[i] != null) {
						BDVeiculos.imprimirPasseio(BDVeiculos.vetorPasseio[i],i);
					} else {
						l.entDados("\nVe�culos de passeio impresso - pressione <enter> para ver mais op��es");
						break;
						
					}
					
				}
				break;
				
				case 4:
				for (int i=0; i < BDVeiculos.vetorCarga.length; i++) {
					if(BDVeiculos.vetorCarga[i] != null) {
						BDVeiculos.imprimirCarga(BDVeiculos.vetorCarga[i],i);
					} else {
						l.entDados("\nVe�culos de Carga impresso - pressione <enter> para ver mais op��es");
						break;
					}
					
				}
				break;	
				
				case 5: 
				System.out.println("\nConsulta pela PLACA - ve�culo de PASSEIO");
								
				passeio = new Passeio();
				
				boolean existePlacaPasseio = false;
				
				String placaPasseio = l.entDados("Informe a placa para pesquisa: ");			
				
				passeio.setPlaca(placaPasseio);
				
				for (int i = 0; i < BDVeiculos.vetorPasseio.length; i++) {
					if (BDVeiculos.vetorPasseio[i] == null) {
						existePlacaPasseio = false;
						break;
					}
					if(BDVeiculos.vetorPasseio[i].getPlaca().equalsIgnoreCase(passeio.getPlaca())) {
						BDVeiculos.imprimirPasseio(BDVeiculos.vetorPasseio[i],i);
						existePlacaPasseio = true;
						break;
					} 
					
				}
				
				if(!existePlacaPasseio) {
					l.entDados("\n\tN�o existe ve�culo de passeio com essa placa, pressione <enter> para ver mais op��es");	
					break;
					
				}
				
				break;
				
				case 6: 
				System.out.println("\nConsulta pela PLACA - ve�culo de CARGA");
				carga = new Carga();
				boolean existePlacaCarga = false;
				String placaCarga = l.entDados("Informe a placa para pesquisa: ");
				carga.setPlaca(placaCarga);
				
				for (int i = 0; i < BDVeiculos.vetorCarga.length; i++) {
					if (BDVeiculos.vetorCarga[i] == null) {
						existePlacaCarga = false;
						break;
					}
					if(BDVeiculos.vetorCarga[i].getPlaca().equalsIgnoreCase(carga.getPlaca())) {
						BDVeiculos.imprimirCarga(BDVeiculos.vetorCarga[i],i);
						existePlacaCarga = true;
						break;
					}
				}
				
				if(!existePlacaCarga) {
					l.entDados("\n\tN�o existe ve�culo de carga com essa placa, pressione <enter> para ver mais op��es");	
				}
				
				
				
				break;
				
				case 7:
				continua = false;
				break;
				
				default:
				l.entDados("\nO valor deve ser >= 1 e <=7 pressione <enter> para ver mais op��es");
				break;
				
			}
			
		}	
		
		
	}

	private static void VerificaDuplicidadePasseio() {
		try {
			if (passeio == null ) {								
				throw new VeicExistException();	
				
			}
		} catch (VeicExistException pla) {
			
		}
		
	}
	
	
	private static void VerificaDuplicidadeCarga() {
		try {
			if (carga == null ) {								
				throw new VeicExistException();	
				
			}
		} catch (VeicExistException pla) {
			
		}
		
	}
	
	
	
					
					
					
				
				

} //fim






