import java.util.ArrayList;

public class Cliente {

	private String nome;
	private int cpf;
	private String ctFidelidade;

	private ArrayList<Locadora> locadoras;// Lista de locadoras (cada cliente deve estar associado a uma ou muitas
											// locadoras)

	public Cliente() {
		// TODO Auto-generated constructor stub
		locadoras = new ArrayList<Locadora>();// Inicializando a lista 'locadoras'
	}

	// Métodos get e set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getCtFidelidade() {
		return ctFidelidade;
	}

	public void setCtFidelidade(String ctFidelidade) {
		this.ctFidelidade = ctFidelidade;
	}

	// Métodos lista 'locadora'
	public void addLocadoras(Locadora loc) {// Adiciona uma nova locadora associado ao objeto cliente
		locadoras.add(loc);
	}

	public int qtdLocadoras() {// Verifica a quantidade de locadoras associadas ao objeto cliente
		return locadoras.size();
	}

	public void excluirLocadora(Locadora loc) {// Exclui alguma locadora associada ao objeto cliente
		locadoras.remove(loc);
	}

	public Locadora getLocadora(int posicao) {// Recupera uma locadora específica do objeto cliente
		return locadoras.get(posicao);
	}

}
