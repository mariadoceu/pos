package exercicio6.copy;
import java.lang.NumberFormatException;
import java.util.ArrayList;
import java.util.List;

import exercicio7.BDVeiculos;
import exercicio7.Carga;
import exercicio7.Passeio;
import exercicio7.VelocException;

public class Teste {
	
	//Usar a classe leitura do exercício anterior
	private static Leitura l = new Leitura();
	
	//Instancia das classes passeio e carga
	private static List<Passeio> passeio =  new ArrayList<Passeio>();
	private static List<Carga> carga =  new ArrayList<Carga>();
	
	public static void main(String[] args) {
		
		boolean continua = true;
		int opcao = 0;
		
		//INFORMAR VEÍCULOS
		
		System.out.println("\nOlá usuário! Este é um sistema de cadastro de veículos ! \nVocê poderá nos informar até 5 veículos de cada categoria e depois será bloqueado."
			+ "\n ##################   Cadastro de veículos - Vamos começar!?   ##################\n");
		

		// COMEÇANDO O MENU //
		
		
		while(continua) {
			
			System.out.println("\n #####  MENU INICIAL #####");
			System.out.println(" 1 - Cadastrar veículo Passeio");
			System.out.println(" 2 - Cadastrar veículo Carga");
			System.out.println(" 3 - Imprimir veículos Passeio");
			System.out.println(" 4 - Imprimir veículos Carga");
			System.out.println(" 5 - Imprimir veículos de Passeio pela placa");	
			System.out.println(" 6 - Imprimir veículos de Carga pela placa");
			System.out.println(" 7 - Sair do sistema");
			
			
			try {
				opcao = Integer.parseInt(l.entDados("\nEscolha uma opção de 1 a 7"));
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
								
						
								l.entDados("\n\tVeículo de passeio armazenado na posição "+ i +" do vetor, pressione <enter> para ver mais opções");
								
								String respostaPasseio = l.entDados("\nDeseja cadastrar outro veículo de passeio? Digite S para sim e N para não");
								
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
//								l.entDados("\nVetor de Carga está cheio  -press <ENTER>");
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
//								l.entDados("\n\tVeículo de carga armazenado na posição "+ i +" do vetor, pressione <enter> para ver mais opções");
//								
//								String respostaCarga = l.entDados("\nDeseja cadastrar outro veículo de Carga? Digite S para sim e N para não");
//								
//								if(respostaCarga.equalsIgnoreCase("n")) {
//									break;
//								}
//								
//								if(BDVeiculos.verificaPosicaoCarga() == -1) {
//									l.entDados("\nVetor de Carga está cheio  -press <ENTER>");
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
						l.entDados("\nVeículos de passeio impresso - pressione <enter> para ver mais opções");
						break;
						
					}
					
				}
				break;
				
				case 4:
				for (int i=0; i < BDVeiculos.vetorCarga.size(); i++) {
					if(BDVeiculos.vetorCarga.get(i) != null) {
						BDVeiculos.imprimirCarga(BDVeiculos.vetorCarga.get(i),i);
					} else {
						l.entDados("\nVeículos de Carga impresso - pressione <enter> para ver mais opções");
						break;
					}
					
				}
				break;	
				
				case 5: 
				System.out.println("\nConsulta pela PLACA - veículo de PASSEIO");
								
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
					l.entDados("\n\tNão existe veículo de passeio com essa placa, pressione <enter> para ver mais opções");	
					break;
					
				}
				
				break;
				
				
				case 7:
				continua = false;
				break;
				
				default:
				l.entDados("\nO valor deve ser >= 1 e <=7 pressione <enter> para ver mais opções");
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






