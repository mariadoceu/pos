package exercicio6.copy;
import java.lang.NumberFormatException;
import java.util.ArrayList;
import java.util.List;

import exercicio7.BDVeiculos;
import exercicio7.Carga;
import exercicio7.Passeio;
import exercicio7.VelocException;

public class Teste {
	
	//Usar a classe leitura do exerc�cio anterior
	private static Leitura l = new Leitura();
	
	//Instancia das classes passeio e carga
	private static List<Passeio> passeio =  new ArrayList<Passeio>();
	private static List<Carga> carga =  new ArrayList<Carga>();
	
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
						
						for(int i = BDVeiculos.verificaPosicaoPasseio();i< BDVeiculos.vetorPasseio.size();i++) {
							
								
								String placa = "";								
								
								Passeio passeio = new Passeio();
								
			
								if (BDVeiculos.vetorPasseio == null ) {								
									VerificaDuplicidadePasseio();
									break;
								}
								
						
								l.entDados("\n\tVe�culo de passeio armazenado na posi��o "+ i +" do vetor, pressione <enter> para ver mais op��es");
								
								String respostaPasseio = l.entDados("\nDeseja cadastrar outro ve�culo de passeio? Digite S para sim e N para n�o");
								
								if(respostaPasseio.equalsIgnoreCase("n")) {
									break;
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
//					try {
//						
//						for(int i = BDVeiculos.verificaPosicaoCarga();i< BDVeiculos.vetorCarga.size();i++) {
//							if(i == -1) {
//								l.entDados("\nVetor de Carga est� cheio  -press <ENTER>");
//								break;
//							}else {
//								String placa = "";
//								
//								carga = new Carga();
//								
//								try {
//									carga = BDVeiculos.cadastrarCarga(carga);
//								} catch (VelocException e) {
//									e.printStackTrace();
//								}	
//								
//								if (carga == null ) {								
//									VerificaDuplicidadeCarga();
//									break;
//								}
//								
//								
//								BDVeiculos.vetorCarga.get(i) = carga;
//								
//								l.entDados("\n\tVe�culo de carga armazenado na posi��o "+ i +" do vetor, pressione <enter> para ver mais op��es");
//								
//								String respostaCarga = l.entDados("\nDeseja cadastrar outro ve�culo de Carga? Digite S para sim e N para n�o");
//								
//								if(respostaCarga.equalsIgnoreCase("n")) {
//									break;
//								}
//								
//								if(BDVeiculos.verificaPosicaoCarga() == -1) {
//									l.entDados("\nVetor de Carga est� cheio  -press <ENTER>");
//									break;
//								}
//							}
//						}
//					}
//					
//					catch(NumberFormatException nfe) {
//						System.out.println("\n##### Deve ser um valor inteiro - Pressione <Enter>#####");
//						l.entDados("");					
//						
//					} 
//					
//					break;
				}
				
				
				case 3:
				for (int i=0; i < BDVeiculos.vetorPasseio.size(); i++) {
					if(BDVeiculos.vetorPasseio.get(i) != null) {
						BDVeiculos.imprimirPasseio(BDVeiculos.vetorPasseio.get(i),i);
					} else {
						l.entDados("\nVe�culos de passeio impresso - pressione <enter> para ver mais op��es");
						break;
						
					}
					
				}
				break;
				
				case 4:
				for (int i=0; i < BDVeiculos.vetorCarga.size(); i++) {
					if(BDVeiculos.vetorCarga.get(i) != null) {
						BDVeiculos.imprimirCarga(BDVeiculos.vetorCarga.get(i),i);
					} else {
						l.entDados("\nVe�culos de Carga impresso - pressione <enter> para ver mais op��es");
						break;
					}
					
				}
				break;	
				
				case 5: 
				System.out.println("\nConsulta pela PLACA - ve�culo de PASSEIO");
								
				Passeio passeio = new Passeio();
				
				boolean existePlacaPasseio = false;
				
				String placaPasseio = l.entDados("Informe a placa para pesquisa: ");			
				
				passeio.setPlaca(placaPasseio);
				
				for (int i = 0; i < BDVeiculos.vetorPasseio.size(); i++) {
					if (BDVeiculos.vetorPasseio.get(i) == null) {
						existePlacaPasseio = false;
						break;
					}
					if(BDVeiculos.vetorPasseio.get(i).getPlaca().equalsIgnoreCase(passeio.getPlaca())) {
						BDVeiculos.imprimirPasseio(BDVeiculos.vetorPasseio.get(i),i);
						existePlacaPasseio = true;
						break;
					} 
					
				}
				
				if(!existePlacaPasseio) {
					l.entDados("\n\tN�o existe ve�culo de passeio com essa placa, pressione <enter> para ver mais op��es");	
					break;
					
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






