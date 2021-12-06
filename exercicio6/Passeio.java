package exercicio6;


public final class Passeio extends Veiculo implements Calc {
	
	private int qtdPassageiro = 0;
	

	public Passeio (){
		qtdPassageiro = 0;	     
	    }
	
	public void calcVel() {
		int v = (int) (getVelocMax()*1000);			
		System.out.println("Velocidade Máxima Passeio:" + v + "M/H");
	}
	
	public int calcular() {
		int somaLetras = 0;
		somaLetras+=getPlaca().length();
		somaLetras+=getMarca().length();
		somaLetras+=getModelo().length();
		somaLetras+=getCor().length();
		return somaLetras;
		
	}
	
	

	public int getQtdPassageiro() {
		return qtdPassageiro;
	}

	public void setQtdPassageiro(int qtdPassageiro) {
		this.qtdPassageiro = qtdPassageiro;
	}



}
