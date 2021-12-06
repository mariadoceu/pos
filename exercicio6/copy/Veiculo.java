package exercicio6.copy;

public abstract class Veiculo {
	
	
	//variaveis da classe	
	private String placa;
	private String marca;
	private String modelo;	
	private String cor;
	private float velocMax;
	private int qtdRodas;	
	
	private Passeio passeio;
	private Carga carga;
	private Motor motor;
	
	
	Veiculo (){
		placa=""; 
		marca =""; 
		modelo="";  
		cor=""; 
		qtdRodas=0; 
		velocMax=0; 
		motor = new Motor(); // instancia Motor
	
	}

	
	//métodos não podem serem sobrescrito
	public final String getMarca() {
		return marca;
	}

	public final void setMarca(String marca) {
		this.marca = marca;
	}

	public final int getQtdRodas() {
		return qtdRodas;
	}

	public final void setQtdRodas(int qtdRodas) {
		this.qtdRodas = qtdRodas;
	}

	public final Motor getMotor() {
		return motor;
	}

	public final void setMotor(Motor motor) {
		this.motor = motor;
	}

	public final String getPlaca() {
		return placa;
	}
	
	public final void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public final String getModelo() {
		return modelo;
	}
	
	public final void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public final String getCor() {
		return cor;
	}
	
	public final void setCor(String cor) {
		this.cor = cor;
	}
	
	public final float getVelocMax() {
		return velocMax;
	}
	
	public final void setVelocMax(float velocMax){		
		this.velocMax = velocMax;
	}
	
//	public final void setVelocMax(float velocMax) throws VelocException{		
//		try {
//			if (velocMax < 80 || velocMax > 110) {			
//				throw new VelocException();
//			} else {
//				this.velocMax = velocMax;
//			}
//		}catch (VelocException e) {			
//			e.printStackTrace();
//		}
//		
//	}
	
	public final Passeio getPasseio() {
		return passeio;
	}
	
	public final void setPasseio(Passeio passeio) {
		this.passeio = passeio;
	}
	
	public final Carga getCarga() {
		return carga;
	}
	
	public final void setCarga(Carga carga) {
		this.carga = carga;
	}


	public abstract void calcVel() throws VelocException;

	
}
