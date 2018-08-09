import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class main {

	public main() {

	}

	public static void main(String[] args) {

		Cliente cl = new Cliente();// Objeto do tipo Cliente
		List<Cliente> clientes = new ArrayList<Cliente>();// Lista de objetos do tipo Cliente
		String linha = null;// Variável utilizada para guardar o conteúdo presente nos arquivos de texto
		Scanner ler = new Scanner(System.in);// Utilizado para recuperar a resposta repassada pelo usuário

		// Leitura dos clientes previamente cadastrados em um arquivo.txt
		System.out.printf("Informe o caminho juntamento com o nome do arquivo texto:\n");
		String nome = ler.nextLine();// Guarda o arquivo apresentado pelo cliente

		// Leitura linha por linha do arquivo de Clientes e inserção dos dados nos
		// atributos do objeto 'cl'.
		try {
			FileReader arq = new FileReader(nome);// Abre o arquivo
			BufferedReader lerArq = new BufferedReader(arq);

			linha = lerArq.readLine();
			while (linha != null) {// A variável 'linha' recebe valor null quando o arquivo chegar ao seu final
				cl.setNome(linha);// Armazena o nome do cliente
				linha = lerArq.readLine();
				cl.setCpf(Integer.parseInt(linha));// Armazena o cpf do cliente
				linha = lerArq.readLine();
				cl.setCtFidelidade(linha);// Armazena se o cliente possui ou não cartão fidelidade {regular,fidelizado}
				clientes.add(cl);// Adiciona o novo cliente 'cl' criado à lista de clientes 'clientes'
				cl = new Cliente();
				linha = lerArq.readLine();
			}

			arq.close();// Fecha o arquivo
		} catch (IOException e) {// Exceção caso a abertura do arquivo não seja realizada corretamente
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		Carro car = new Carro();// Objeto do tipo Carro
		ArrayList<Carro> carros = new ArrayList<Carro>();// Lista de objetos do tipo Carro

		// Leitura dos carros previamente cadastrados em um arquivo.txt
		System.out.printf("Informe o caminho juntamento com o nome do arquivo texto:\n");
		nome = ler.nextLine();// Guarda o arquivo apresentado pelo cliente

		// Leitura linha por linha do arquivo de Carros e inserção dos dados nos
		// atributos do objeto 'car'.
		try {
			FileReader arq = new FileReader(nome);// Abre o arquivo
			BufferedReader lerArq = new BufferedReader(arq);

			linha = null;
			linha = lerArq.readLine();
			while (linha != null) {// A variável 'linha' recebe valor null quando o arquivo chegar ao seu final
				car.setNomeCarro(linha);// Armazena o nome do carro
				linha = lerArq.readLine();
				car.setRenavam(Integer.parseInt(linha));// Armazena o renavam do carro
				linha = lerArq.readLine();
				car.setLimPessoas(Integer.parseInt(linha));// Armazena o limite de passageiros no carro
				linha = lerArq.readLine();
				car.setTipo(linha);// Armazena o tipo do carro {compacto, esportivo ou SUV}
				carros.add(car);// Adiciona o novo carro 'car' criado à lista de clientes 'carros'
				car = new Carro();
				linha = lerArq.readLine();
			}

			arq.close();// Fecha o arquivo
		} catch (IOException e) {// Exceção caso a abertura do arquivo não seja realizada corretamente
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		Locadora loc = new Locadora();// Objeto do tipo Locadora
		List<Locadora> locadoras = new ArrayList<Locadora>();// Lista de objetos do tipo Locadora

		// Leitura das locadoras previamente cadastrados em um arquivo.txt
		System.out.printf("Informe o caminho juntamento com o nome do arquivo texto:\n");
		nome = ler.nextLine();// Guarda o arquivo apresentado pelo cliente

		// Leitura linha por linha do arquivo de Locadoras e inserção dos dados nos
		// atributos do objeto 'loc'.
		try {
			FileReader arq = new FileReader(nome);// Abre o arquivo
			BufferedReader lerArq = new BufferedReader(arq);

			linha = null;
			linha = lerArq.readLine();
			while (linha != null) {// A variável 'linha' recebe valor null quando o arquivo chegar ao seu final
				loc.setCnpj(Integer.parseInt(linha));// Armazena o cnpj da locadora
				linha = lerArq.readLine();
				loc.setNome(linha);// Armazena o nome da locadora
				linha = lerArq.readLine();
				loc.setValSemFidelidade(Double.parseDouble(linha));// Armazena o valor/dia durante semana para clientes
																	// fidelizados
				linha = lerArq.readLine();
				loc.setValSemNormal(Double.parseDouble(linha));// Armazena o valor/dia durante semana para clientes não
																// fidelizados
				linha = lerArq.readLine();
				loc.setValFdsFidelidade(Double.parseDouble(linha));// Armazena o valor/dia durante fim de semana para
																	// clientes fidelizados
				linha = lerArq.readLine();
				loc.setValFdsNormal(Double.parseDouble(linha));// Armazena o valor/dia durante fim de semana para
																// clientes não fidelizados
				locadoras.add(loc);// Adiciona a nova locadora 'loc' criada à lista de locadoras 'locadoras'
				loc = new Locadora();
				linha = lerArq.readLine();
			}

			arq.close();// Fecha o arquivo
		} catch (IOException e) {// Exceção caso a abertura do arquivo não seja realizada corretamente
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		// Definindo a locadora de cada carro
		int i = 0;
		for (i = 0; i < carros.size(); i++) {
			// Se o tipo do carro é 'Compacto' ele pertence a locadora SouthCar
			if (carros.get(i).getTipo().equalsIgnoreCase("Compacto")) {
				carros.get(i).setLocadora(locadoras.get(0));
			} else {
				// Se o tipo do carro é 'Esportivo' ele pertence a locadora WestCar
				if (carros.get(i).getTipo().equalsIgnoreCase("Esportivo")) {
					carros.get(i).setLocadora(locadoras.get(1));
				} else {
					// Se o tipo do carro é 'SUV' ele pertence a locadora NorthCar
					carros.get(i).setLocadora(locadoras.get(2));
				}
			}
		}

		// Definindo a locadora de cada cliente
		// Nesse caso, todos os clientes da lista 'clientes' pertencem às 3 locadoras
		// cadastradas em 'locadoras'
		i = 0;
		for (i = 0; i < clientes.size(); i++) {
			clientes.get(i).addLocadoras(locadoras.get(0));
			clientes.get(i).addLocadoras(locadoras.get(1));
			clientes.get(i).addLocadoras(locadoras.get(2));
		}

		// ******* Solicitando primeira locação/reserva de veículos *******
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();// Lista de objetos do tipo Reserva
		Reserva res = new Reserva();// Objeto do tipo Reserva
		res.setCliente(clientes.get(1)); // Cliente Regular fixo (Definido de acordo com o contexto do exercício)

		/*
		 * Input apresentado conforme contexto do exercício. Importante ressaltar que a
		 * entrada deve ser realizada
		 * <QtdPasseiros>:<Data(dd/mm/aaaa)>,<Data(dd/mm/aaaa)> Por exemplo->
		 * 2:08/08/2018,09/08/2018
		 */
		System.out.printf("Informe a quantidade de passageiros desejada e as datas para locacao\n");
		String input = ler.nextLine();
		int qtdPassageiros = Integer.parseInt(input.substring(0, 1));// Variável armazena a qtdPassageiros escolhida
																		// pelo usuário
		String datas = input.substring(2);// Variável armazena as datas escolhidas pelo usuário
		String[] arrayString = datas.split(",");// Insere cada data em uma posição do array 'arrayString'
		ArrayList<Date> data = new ArrayList<Date>();// Lista de objetos do tipo Date
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");// formato definido para a data

		// Transforma cada data armazenada em 'arrayString' para um objeto do tipo Date
		// e adiciona em 'data'
		try {
			for (i = 0; i < arrayString.length; i++) {
				data.add(format.parse(arrayString[i]));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		res.setDias(data);// Armazena as datas no objeto 'res'
		res.setReserva(qtdPassageiros, carros, reservas);// Verifica qual o carro barato

		/*
		 * Gera saída/output definida de acordo com o contexto do exercício. Output ->
		 * nomeCarro : Nome Locadora Por exemplo-> Fiesta : SouthCar
		 */
		String output = res.getCarro().getNomeCarro() + " : " + res.getLocadora().getNome();
		System.out.println(output);
		reservas.add(res);// Adiciona o objeto 'res' em 'reservas'

		// ******* Solicitando segunda locação/reserva de veículos *******
		res = new Reserva();// Objeto do tipo Reserva
		res.setCliente(clientes.get(1)); // Cliente Regular fixo (Definido de acordo com o contexto do exercício)

		/*
		 * Input apresentado conforme contexto do exercício. Importante ressaltar que a
		 * entrada deve ser realizada
		 * <QtdPasseiros>:<Data(dd/mm/aaaa)>,<Data(dd/mm/aaaa)> Por exemplo->
		 * 2:08/08/2018,09/08/2018
		 */
		System.out.printf("Informe a quantidade de passageiros desejada e as datas para locacao\n");
		input = ler.nextLine();
		qtdPassageiros = Integer.parseInt(input.substring(0, 1));// Variável armazena a qtdPassageiros escolhida pelo
																	// usuário
		datas = input.substring(2);// Variável armazena as datas escolhidas pelo usuário
		arrayString = datas.split(",");// Insere cada data em uma posição do array 'arrayString'
		data = new ArrayList<Date>();// Lista de objetos do tipo Date

		// Transforma cada data armazenada em 'arrayString' para um objeto do tipo Date
		// e adiciona em 'data'
		try {
			for (i = 0; i < arrayString.length; i++) {
				data.add(format.parse(arrayString[i]));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		res.setDias(data);// Armazena as datas no objeto 'res'
		res.setReserva(qtdPassageiros, carros, reservas);// Verifica qual o carro barato

		/*
		 * Gera saída/output definida de acordo com o contexto do exercício. Output ->
		 * nomeCarro : Nome Locadora Por exemplo-> Fiesta : SouthCar
		 */
		output = res.getCarro().getNomeCarro() + " : " + res.getLocadora().getNome();
		System.out.println(output);
		reservas.add(res);// Adiciona o objeto 'res' em 'reservas'

		// ******* Solicitando terceira locação/reserva de veículos *******
		res = new Reserva();// Objeto do tipo Reserva
		res.setCliente(clientes.get(1)); // Cliente Regular fixo (Definido de acordo com o contexto do exercício)

		/*
		 * Input apresentado conforme contexto do exercício. Importante ressaltar que a
		 * entrada deve ser realizada
		 * <QtdPasseiros>:<Data(dd/mm/aaaa)>,<Data(dd/mm/aaaa)> Por exemplo->
		 * 2:08/08/2018,09/08/2018
		 */
		System.out.printf("Informe a quantidade de passageiros desejada e as datas para locacao\n");
		input = ler.nextLine();
		qtdPassageiros = Integer.parseInt(input.substring(0, 1));// Variável armazena a qtdPassageiros escolhida pelo
																	// usuário
		datas = input.substring(2);// Variável armazena as datas escolhidas pelo usuário
		arrayString = datas.split(",");// Insere cada data em uma posição do array 'arrayString'
		data = new ArrayList<Date>();// Lista de objetos do tipo Date

		// Transforma cada data armazenada em 'arrayString' para um objeto do tipo Date
		// e adiciona em 'data'
		try {
			for (i = 0; i < arrayString.length; i++) {
				data.add(format.parse(arrayString[i]));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		res.setDias(data);// Armazena as datas no objeto 'res'
		res.setReserva(qtdPassageiros, carros, reservas);// Verifica qual o carro barato

		/*
		 * Gera saída/output definida de acordo com o contexto do exercício. Output ->
		 * nomeCarro : Nome Locadora Por exemplo-> Fiesta : SouthCar
		 */
		output = res.getCarro().getNomeCarro() + " : " + res.getLocadora().getNome();
		System.out.println(output);
		reservas.add(res);// Adiciona o objeto 'res' em 'reservas'

	}

}
