import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Reserva {

	private ArrayList<Date> dias;
	private double valTotal;

	private Carro car; // Objeto do tipo carro (Toda reserva possui um carro associado)
	private Cliente cli; // Objeto do tipo cliente (Toda reserva possui um cliente associado)
	private Locadora loc; // Objeto do tipo locadora (Toda reserva possui uma locadora associada)

	public Reserva() {
		// TODO Auto-generated constructor stub
		car = new Carro(); // Inicializando o objeto 'car'
		cli = new Cliente(); // Inicializando o objeto 'cli'
		loc = new Locadora(); // Inicializando o objeto 'loc'
	}

	// Métodos get e set
	public double getValTotal() {
		return valTotal;
	}

	public void setValTotal(double valTotal) {
		this.valTotal = valTotal;
	}

	public ArrayList<Date> getDias() {
		return dias;
	}

	public void setDias(ArrayList<Date> dias) {
		this.dias = dias;
	}

	public void setCliente(Cliente cliente) {
		cli = cliente;
	}

	public Cliente getCliente() {
		return cli;
	}

	public void setCarro(Carro carro) {
		car = carro;
	}

	public Carro getCarro() {
		return car;
	}

	public void setLocadora(Locadora locad) {
		loc = locad;
	}

	public Locadora getLocadora() {
		return loc;
	}

	// Método para realizar a contagem de dias da semana presentes nas datas
	// inseridas pelo usuário
	public int contSemana() {
		int cont = 0;
		int i = 0;
		int diaSemana = 0;

		for (i = 0; i < dias.size(); i++) {
			diaSemana = dias.get(i).getDay();// Recupera o dia da semana presente na data
			// Dias da semana: 1-Segunda, 2-Terça, 3-Quarta, 4-Quinta, 5-Sexta
			if ((diaSemana == 1) || (diaSemana == 2) || (diaSemana == 3) || (diaSemana == 4) || (diaSemana == 5)) {
				cont++;
			}
		}
		return cont;
	}

	// Método para realizar a contagem de dias referentes ao fim de semana presentes
	// nas datas inseridas pelo usuário
	public int contFDS() {
		int contFDS = 0;
		int i = 0;
		int diaFDS = 0;

		for (i = 0; i < dias.size(); i++) {
			diaFDS = dias.get(i).getDay();// Recupera o dia da semana presente na data
			// Dias da semana: 0-Domingo, 6-Sábado
			if ((diaFDS == 0) || (diaFDS == 6)) {
				contFDS++;
			}
		}
		return contFDS;
	}

	/*
	 * Método que calcula o valor total da locação de um determinado veículo,
	 * baseado nas datas inseridas pelo usuário e qtd de passageiros. IMPORTANTE:
	 * Como o escopo do exercício delimita que o cliente é regular, então todos os
	 * valores calculados são sem desconto de fidelidade.
	 */
	public Double calValorTotal(Carro car) {

		int contSemana = 0;
		int contFDS = 0;
		Double valSemana = 0.0;
		Double valFDS = 0.0;
		Double valTotal = 0.0;
		contSemana = contSemana();
		contFDS = contFDS();

		valSemana = contSemana * car.getLocadora().getValSemNormal();// Valor total para os dias da semana
		valFDS = contFDS * car.getLocadora().getValFdsNormal();// Valor total para os dias do fim de semana
		valTotal = valSemana + valFDS;// Valor total da locação

		return valTotal;
	}

	// Método que realiza a reserva
	public void setReserva(int qtdPassageiros, ArrayList<Carro> car, ArrayList<Reserva> res) {

		ArrayList<Carro> carCompactos = new ArrayList<Carro>();// Lista dos carros compactos
		ArrayList<Carro> carEsportivos = new ArrayList<Carro>();// Lista dos carros esportivos
		ArrayList<Carro> carSUVs = new ArrayList<Carro>();// Lista dos carros SUVs
		Random gerador = new Random();// Escolha aleatório do carro, dado o tipo do mesmo
		Double valTComp = 0.0;// Valor locação do carro compacto
		Double valTEsp = 0.0;// Valor da locação do carro esportivo
		Double valTSUVs = 0.0;// Valor da locação do carro SUV
		int posicao = 0;
		int i = 0;

		// Agrupa os carros presente em 'car' de acordo com seus 3 tipos
		for (i = 0; i < car.size(); i++) {
			if (car.get(i).getTipo().equalsIgnoreCase("Compacto")) {
				carCompactos.add(car.get(i));
			} else {
				if (car.get(i).getTipo().equalsIgnoreCase("Esportivo")) {
					carEsportivos.add(car.get(i));
				} else {
					carSUVs.add(car.get(i));
				}
			}
		}

		// Calcula o valor da locação do carro de acordo com a quantidade de passageiros
		if ((qtdPassageiros > 0) && (qtdPassageiros <= 2)) {// Mínimo 0 e Máximo 2 passageiros: pode ser carro esportivo
															// ou compacto
			valTComp = calValorTotal(carCompactos.get(0));
			valTEsp = calValorTotal(carEsportivos.get(0));
		} else {
			if ((qtdPassageiros > 2) && (qtdPassageiros <= 4)) {// Mínimo 3 e Máximo 4 passageiros: carro compacto
				valTComp = calValorTotal(carCompactos.get(0));
			} else { // Mínimo 5 passageiros: carro SUV
				valTSUVs = calValorTotal(carSUVs.get(0));
			}
		}

		posicao = gerador.nextInt(5);// Guarda valor randômico sorteado

		if ((qtdPassageiros > 0) && (qtdPassageiros <= 2)) {
			if (valTComp < valTEsp) {// Se o valor do carro compacto é mais barato, então seleciona algum carro do
										// tipo compacto
				setCarro(carCompactos.get(posicao));// Armazena o carro selecionado
				setValTotal(valTComp);// Armazena o valor total da locação
				setLocadora(carCompactos.get(posicao).getLocadora());// Armazena a locadora do carro selecionado
			} else {// Se valor do carro esportivo é mais barato, então seleciona algum carro do
					// tipo esportivo
				setCarro(carEsportivos.get(posicao));// Armazena o carro selecionado
				setValTotal(valTEsp);// Armazena o valor total da locação
				setLocadora(carEsportivos.get(posicao).getLocadora());// Armazena a locadora do carro selecionado
			}
		} else {
			if ((qtdPassageiros > 2) && (qtdPassageiros <= 4)) {// Seleciona algum carro do tipo compacto
				setCarro(carCompactos.get(posicao));// Armazena o carro selecionado
				setValTotal(valTComp);// Armazena o valor total da locação
				setLocadora(carCompactos.get(posicao).getLocadora());// Armazena a locadora do carro selecionado
			} else { // Seleciona algum carro do tipo compacto
				setCarro(carSUVs.get(posicao));// Armazena o carro selecionado
				setValTotal(valTSUVs);// Armazena o valor total da locação
				setLocadora(carSUVs.get(posicao).getLocadora());// Armazena a locadora do carro selecionado
			}
		}

	}

}
