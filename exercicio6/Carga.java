package exercicio6;


public final class Carga extends Veiculo implements Calc{
	
	
	private int cargaMax = 0;
	private int tara = 0;
	
	
	  public Carga (){
		cargaMax = 0;
		tara = 0;
			 
	    }
	  
		public void calcVel() {
			int v = (int) (getVelocMax()*10000);
			System.out.println("Velocidade Máxima Passeio:" + v + "CM/H");
		}  
		
		
		public int calcular() {
			int somaNum = 0;
			
			somaNum+=getMotor().getQtdPist();
			somaNum+=getMotor().getPotencia();
			somaNum+=getQtdRodas();
			somaNum+=getVelocMax();
			somaNum+=getTara();
			somaNum+=getCargaMax();
			return somaNum;
			
		}
		

	public int getCargaMax() {
		return cargaMax;
	}

	public void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}


	public int getTara() {
		return tara;
	}


	public void setTara(int tara) {
		this.tara = tara;
	}
	
	
}
