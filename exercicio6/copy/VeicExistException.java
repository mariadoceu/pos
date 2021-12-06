package exercicio6.copy;

public class VeicExistException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VeicExistException() {
		System.out.println("\n Já existe um veículo com esta placa, por favor cadastre novamente"); // método construtor avisando que já existe veículo cadastrado com essa placa		
	}
		
}
