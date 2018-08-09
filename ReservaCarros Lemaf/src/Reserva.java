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

	// M�todos get e set
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

	// M�todo para realizar a contagem de dias da semana presentes nas datas
	// inseridas pelo usu�rio
	public int contSemana() {
		int cont = 0;
		int i = 0;
		int diaSemana = 0;

		for (i = 0; i < dias.size(); i++) {
			diaSemana = dias.get(i).getDay();// Recupera o dia da semana presente na data
			// Dias da semana: 1-Segunda, 2-Ter�a, 3-Quarta, 4-Quinta, 5-Sexta
			if ((diaSemana == 1) || (diaSemana == 2) || (diaSemana == 3) || (diaSemana == 4) || (diaSemana == 5)) {
				cont++;
			}
		}
		return cont;
	}

	// M�todo para realizar a contagem de dias referentes ao fim de semana presentes
	// nas datas inseridas pelo usu�rio
	public int contFDS() {
		int contFDS = 0;
		int i = 0;
		int diaFDS = 0;

		for (i = 0; i < dias.size(); i++) {
			diaFDS = dias.get(i).getDay();// Recupera o dia da semana presente na data
			// Dias da semana: 0-Domingo, 6-S�bado
			if ((diaFDS == 0) || (diaFDS == 6)) {
				contFDS++;
			}
		}
		return contFDS;
	}

	/*
	 * M�todo que calcula o valor total da loca��o de um determinado ve�culo,
	 * baseado nas datas inseridas pelo usu�rio e qtd de passageiros. IMPORTANTE:
	 * Como o escopo do exerc�cio delimita que o cliente � regular, ent�o todos os
	 * valores calculados s�o sem desconto de fidelidade.
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
		valTotal = valSemana + valFDS;// Valor total da loca��o

		return valTotal;
	}

	// M�todo que realiza a reserva
	public void setReserva(int qtdPassageiros, ArrayList<Carro> car, ArrayList<Reserva> res) {

		ArrayList<Carro> carCompactos = new ArrayList<Carro>();// Lista dos carros compactos
		ArrayList<Carro> carEsportivos = new ArrayList<Carro>();// Lista dos carros esportivos
		ArrayList<Carro> carSUVs = new ArrayList<Carro>();// Lista dos carros SUVs
		Random gerador = new Random();// Escolha aleat�rio do carro, dado o tipo do mesmo
		Double valTComp = 0.0;// Valor loca��o do carro compacto
		Double valTEsp = 0.0;// Valor da loca��o do carro esportivo
		Double valTSUVs = 0.0;// Valor da loca��o do carro SUV
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

		// Calcula o valor da loca��o do carro de acordo com a quantidade de passageiros
		if ((qtdPassageiros > 0) && (qtdPassageiros <= 2)) {// M�nimo 0 e M�ximo 2 passageiros: pode ser carro esportivo
															// ou compacto
			valTComp = calValorTotal(carCompactos.get(0));
			valTEsp = calValorTotal(carEsportivos.get(0));
		} else {
			if ((qtdPassageiros > 2) && (qtdPassageiros <= 4)) {// M�nimo 3 e M�ximo 4 passageiros: carro compacto
				valTComp = calValorTotal(carCompactos.get(0));
			} else { // M�nimo 5 passageiros: carro SUV
				valTSUVs = calValorTotal(carSUVs.get(0));
			}
		}

		posicao = gerador.nextInt(5);// Guarda valor rand�mico sorteado

		if ((qtdPassageiros > 0) && (qtdPassageiros <= 2)) {
			if (valTComp < valTEsp) {// Se o valor do carro compacto � mais barato, ent�o seleciona algum carro do
										// tipo compacto
				setCarro(carCompactos.get(posicao));// Armazena o carro selecionado
				setValTotal(valTComp);// Armazena o valor total da loca��o
				setLocadora(carCompactos.get(posicao).getLocadora());// Armazena a locadora do carro selecionado
			} else {// Se valor do carro esportivo � mais barato, ent�o seleciona algum carro do
					// tipo esportivo
				setCarro(carEsportivos.get(posicao));// Armazena o carro selecionado
				setValTotal(valTEsp);// Armazena o valor total da loca��o
				setLocadora(carEsportivos.get(posicao).getLocadora());// Armazena a locadora do carro selecionado
			}
		} else {
			if ((qtdPassageiros > 2) && (qtdPassageiros <= 4)) {// Seleciona algum carro do tipo compacto
				setCarro(carCompactos.get(posicao));// Armazena o carro selecionado
				setValTotal(valTComp);// Armazena o valor total da loca��o
				setLocadora(carCompactos.get(posicao).getLocadora());// Armazena a locadora do carro selecionado
			} else { // Seleciona algum carro do tipo compacto
				setCarro(carSUVs.get(posicao));// Armazena o carro selecionado
				setValTotal(valTSUVs);// Armazena o valor total da loca��o
				setLocadora(carSUVs.get(posicao).getLocadora());// Armazena a locadora do carro selecionado
			}
		}

	}

}
