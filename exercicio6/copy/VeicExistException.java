package exercicio6.copy;

public class VeicExistException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VeicExistException() {
		System.out.println("\n J� existe um ve�culo com esta placa, por favor cadastre novamente"); // m�todo construtor avisando que j� existe ve�culo cadastrado com essa placa		
	}
		
}
