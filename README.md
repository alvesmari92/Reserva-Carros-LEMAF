# Como usar:

1- Carregar o arquivo Clientes.txt presente no GitHub. 
Para isso, insira o caminho desse documento em seu computador, por exemplo: c:\Clientes.txt.

2- Carregar o arquivo Carros.txt presente no GitHub.
Para isso, insira o caminho desse documento em seu computador, por exemplo: c:\Carros.txt.

3- Carregar o arquivo Locadoras.txt presente no GitHub. 
Para isso, insira o caminho desse documento em seu computador, por exemplo: c:\Locadoras.txt.

4- Insira a entrada no programa via terminal, respeitando o formato da mesma.
Formato entrada-> <Quantidade de Passageiros>:<Data1 (formato dd/mm/aaaa)>,<Data2 (formato dd/mm/aaaa)>
Por exemplo-> 2:08/08/2018,09/08/2018

** Como saída o programa irá retornar o nome do veículo a ser locado e o nome da Locadora do mesmo.
Formato saída-> <Nome Carro> : <Nome Locadora>
Por exemplo-> Fiesta : SouthCar

**********************************************************************************************************
# Observações relevantes:

1- A entrada do programa foi alterada, pois não foi possível compreender o <Tipo_Carro> apresentado no
exemplo de entrada do escopo do problema, visto que os valores (Normal e Premium) atribuídos a esse campo
não haviam sido apresentados no texto.

2- A entrada apresentada na solução é equivalente à descrita no escopo do problema.

3- A solução apresenta um cliente regular fixo devido ao escopo do problema apresentado. Sendo assim, todos
os cálculo de valores das tarifas de locação foram realizados apenas considerando o perfil do cliente regular.

4- Também é possível ver que independente do veículo, todos os veículos que se enquadram em um mesmo tipo 
possuem o mesmo valor de tarifa.

************************************************************************************************************
# Para o futuro:

1- Implementar o controle das reservas, sendo que um carro não poderá ser alocado a mais de um cliente
em uma mesma data.

2- Implementar uma solução que permita à locação a clientes regulares e fidelizados.

