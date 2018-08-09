
public class Carro {

	private String nomeCarro;
	private int renavam;
	private int limPessoas;
	private String tipo;

	private Locadora loc; // Objeto do tipo Locadora (representa que cada carro possui uma locadora
							// associada)

	public Carro() {
		// TODO Auto-generated constructor stub
		loc = new Locadora(); // Inicializa o objeto 'loc'
	}

	// Métodos get e set
	public String getNomeCarro() {
		return nomeCarro;
	}

	public void setNomeCarro(String nomeCarro) {
		this.nomeCarro = nomeCarro;
	}

	public int getRenavam() {
		return renavam;
	}

	public void setRenavam(int renavam) {
		this.renavam = renavam;
	}

	public int getLimPessoas() {
		return limPessoas;
	}

	public void setLimPessoas(int limPessoas) {
		this.limPessoas = limPessoas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setLocadora(Locadora locad) {
		loc = locad;
	}

	public Locadora getLocadora() {
		return loc;
	}

}
