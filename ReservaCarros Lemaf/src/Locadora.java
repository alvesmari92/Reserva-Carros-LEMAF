import java.util.ArrayList;

public class Locadora {

	private String nome;
	private int cnpj;
	private double valSemNormal;
	private double valSemFidelidade;
	private double valFdsNormal;
	private double valFdsFidelidade;

	public Locadora() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public double getValSemNormal() {
		return valSemNormal;
	}

	public void setValSemNormal(double valSemNormal) {
		this.valSemNormal = valSemNormal;
	}

	public double getValSemFidelidade() {
		return valSemFidelidade;
	}

	public void setValSemFidelidade(double valSemFidelidade) {
		this.valSemFidelidade = valSemFidelidade;
	}

	public double getValFdsNormal() {
		return valFdsNormal;
	}

	public void setValFdsNormal(double valFdsNormal) {
		this.valFdsNormal = valFdsNormal;
	}

	public double getValFdsFidelidade() {
		return valFdsFidelidade;
	}

	public void setValFdsFidelidade(double valFdsFidelidade) {
		this.valFdsFidelidade = valFdsFidelidade;
	}

}
