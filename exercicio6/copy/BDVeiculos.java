package exercicio6.copy;

import java.util.ArrayList;
import java.util.List;

import exercicio7.Carga;
import exercicio7.Passeio;
import exercicio7.VelocException;

public class BDVeiculos {

	//Criar dois vetores
	public static List<Passeio> vetorPasseio = new ArrayList<Passeio>();
	public static List<Carga> vetorCarga = new ArrayList<Carga>();
	

	
	
	public static int verificaPosicaoPasseio() {
		for (int i = 0; i < vetorPasseio.size(); i++ )
			if (vetorPasseio.get(i) == null) {
				return i;
			}
			return -1;	
		}
	
		
	public static int verificaPosicaoCarga() {
		for (int i = 0; i < vetorCarga.size(); i++ )
			if (vetorCarga.get(i) == null) {
				return i;
			}
			return -1;	
		}
			
			
			
		public static boolean placaPasseioAlocada(String placa) throws  VeicExistException{
			
			for(int i = 0; i <vetorPasseio.size();i++) {
				
				if(vetorPasseio.get(i)  != null && vetorPasseio.get(i) .getPlaca().contains(placa) && placa != "") {
					return true;
				}
				
				if(vetorPasseio.get(i)  != null && vetorPasseio.get(i) .getPlaca().contains(placa)) {
					System.out.println("teste");
					return true;
				}
				
				
			}
			return false;
		}
		
		public static boolean placaCargaAlocada(String placa) throws VeicExistException{
			for(int i = 0; i <vetorCarga.size();i++) {
				if(vetorCarga.get(i) != null && vetorCarga.get(i).getPlaca().contains(placa) && placa != "") {
					return true;
				}
			}
			return false;
		}
		
		public static void verificaVelocidadePasseio(float velocMax) throws VelocException{			
			try {
				for(int i = 0; i <vetorPasseio.size();i++) {
					if(velocMax < 80 || velocMax > 110) {
						throw new VelocException();							
						//return true;						
					} 
				}
			} catch (VelocException vel) {
				
			}
			//return false;
		}
		
		
		public static void verificaVelocidadeCarga(float velocMax) throws VelocException{			
			try {
				for(int i = 0; i <vetorCarga.size();i++) {
					if(velocMax < 80 || velocMax > 110) {
						throw new VelocException();							
						//return true;						
					} 
				}
			} catch (VelocException vel) {
				
			}
			//return false;
		}
		
		public static void teste(String placa) throws VeicExistException{			
			try {
				if (vetorPasseio == null ) {								
					throw new VeicExistException();	
					//break;
				}
			} catch (VeicExistException pla) {
				
			}
			//return false;
		}
		
		
		
		//PASSEIO 
		public static Passeio cadastrarPasseio (Passeio passeio) throws VelocException {


				List <Passeio> passeios = new ArrayList <Passeio>();
				System.out.println("\n\n################ Cadastre veículos de passeio ###############");				
				passeio.setPlaca(Leitura.entDados("Placa: "));
				
//				try {
//					if(placaPasseioAlocada(passeio.getPlaca())) {
//						return null;
//					}
//				} catch (VeicExistException e) {
//					
//					e.printStackTrace();
//				}
//				passeio.setMarca(Leitura.entDados("Marca: "));
//				passeio.setModelo(Leitura.entDados("Modelo: "));
//				passeio.setCor(Leitura.entDados("Cor: "));
//				passeio.setQtdRodas(Integer.parseInt(Leitura.entDados("Quantidade de rodas: ")));
//				passeio.getMotor().setQtdPist((Integer.parseInt(Leitura.entDados("Quantidade de pistões"))));
//				passeio.getMotor().setPotencia((Integer.parseInt(Leitura.entDados("Potencia"))));
//				passeio.setVelocMax(Integer.parseInt(Leitura.entDados("Velocidade Máxima: ")));	
//				verificaVelocidadePasseio(passeio.getVelocMax()); 
//				if (passeio.getVelocMax() > 110 || passeio.getVelocMax() < 80 ) {
//					passeio.setVelocMax(100); 
//				}
				
				passeios.add(passeio);	
				
			
			
			return passeio;
			
			
		}
		
		
		public static void  imprimirPasseio (Passeio passeio, int i) {
			
			System.out.println("\nVeículo posição " + i + " do vetor Passeio");
			System.out.println("Qtd passageiros " + passeio.getQtdPassageiro());
			System.out.println("Placa " + passeio.getPlaca());
			System.out.println("Marca " + passeio.getMarca());
			System.out.println("Cor " + passeio.getCor());
			System.out.println("Qtd de Rodas " + passeio.getQtdRodas());
			System.out.println("Qtd de pistões " + passeio.getMotor().getQtdPist());
			System.out.println("Potencia " + passeio.getMotor().getPotencia());
			System.out.println("Velocidade Máxima " + passeio.getVelocMax());
			System.out.println("Quantidade total de letras " + passeio.calcular());
			passeio.calcVel();
			
			
		}
		
		//CARGA
		
		public static Carga cadastrarCarga (Carga carga) throws VelocException {
			
			System.out.println("\n\n################    Cadastre veículos de Carga    ###############");
			carga.setTara(Integer.parseInt(Leitura.entDados("Tara: ")));
			carga.setCargaMax(Integer.parseInt(Leitura.entDados("Carga: ")));
			carga.setPlaca(Leitura.entDados("Placa: "));
			try {
				if(placaCargaAlocada(carga.getPlaca())) {
					return null;
				}
			} catch (VeicExistException e) {
				e.printStackTrace();
			}
			carga.setMarca(Leitura.entDados("Marca: ")); 
			carga.setModelo(Leitura.entDados("Modelo: "));
			carga.setCor(Leitura.entDados("Cor: "));
			carga.setQtdRodas(Integer.parseInt(Leitura.entDados("Quantidade de rodas: ")));
			carga.getMotor().setQtdPist((Integer.parseInt(Leitura.entDados("Quantidade de pistões"))));
			carga.getMotor().setPotencia(Integer.parseInt(Leitura.entDados("Potencia do Motor")));	
			carga.setVelocMax(Integer.parseInt(Leitura.entDados("Velocidade Máxima: ")));
			verificaVelocidadeCarga(carga.getVelocMax()); 
			if (carga.getVelocMax() > 110) {
				carga.setVelocMax(90); 
			}
			return carga;

		}
		
		
		public static void  imprimirCarga (Carga carga, int i) {			
			System.out.println("\nVeículo posição " + i + " do vetor Carga");
			System.out.println("Tara " + carga.getTara());
			System.out.println("Carga Máxima: " + carga.getCargaMax());
			System.out.println("Placa " + carga.getPlaca());
			System.out.println("Marca " + carga.getMarca());
			System.out.println("Cor " + carga.getCor());
			System.out.println("Qtd de Rodas " + carga.getQtdRodas());
			System.out.println("Qtd de pistões " + carga.getMotor().getQtdPist());
			System.out.println("Potencia " + carga.getMotor().getPotencia());
			System.out.println("Velocidade Máxima " + carga.getVelocMax());
			System.out.println("Quantidade total de letras " + carga.calcular());
			carga.calcVel();
		}
		
		
		
	}
