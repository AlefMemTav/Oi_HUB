/*
1. Gerenciar Temas: o programa deverá ser capaz de armazenar até 50 diferentes temas.
	(a) Cadastro: o usuário poderá cadastrar temas no programa. Não poderão existir temas com nomes iguais.
	(b) Exclusão: o usuário poderá excluir temas desde que não existam palavras associadas a ele. Caso não seja possível realizar exclusão, o programa deverá exibir e mensagem “Não foi possível excluir o tema. Verifique se existem palavras cadastradas nesse tema.”
	(c) Busca: o usuário poderá buscar por temas cadastrados no sistema.
2. Gerenciar Palavras: o programa deverá ser capaz de armazenar até 50 palavras para cada um dos temas cadastrados.
	(a) Cadastro: o usuário poderá cadastrar palavras no programa. Para tanto, ele deve escolher um tema e só então realizar o cadastro. Atenção! não poderão existir palavras iguais dentro de um mesmo tema.
	(b) Exclusão: o usuário poderá excluir palavras cadastradas no programa.
	(c) Busca: o usuário deve ser capaz de buscar por uma palavra no conjunto de todas as palavras cadastradas no programa. Caso uma palavra não seja encontrada, deve ser retornada a mensagem “Palavra não encontrada”, caso contrário a mensagem a ser retornada é “Palavra encontrada no tema XYZ”, onde XYZ é o tema em que a palavra está.
	(d) Listagem: o usuário poderá selecionar um tema e ver todas as palavras cadastrada naquele tema.
3. Jogar
	(a) Seleção de tema: antes de iniciar um jogo, o usuário deverá selecionar um tema onde será buscada a palavra.
	(b) Jogo:
		i. Em cada rodada, o usuário deve escolher uma letra.
		ii. Caso a letra já tenha sido tentada, o programa deverá mostrar a mensagem: “Tente outra letra!”
		iii. Para cada letra tentada pelo usuário e não presente na palavra, deverá ser contabilizado um erro.
		iv. O usuário poderá ter no máximo cinco erro. Após a quinta tentativa errada, o programa deverá mostrar a mensagem “Você perdeu! Deseja Deseja jogar novamente?”. Não é necessário mostrar a palavra no final da partida.
		v. Caso o usuário acerte a palavra, o programa deverá mostrar a mensagem: “Parabéns! Você acertou a palavra! Deseja jogar novamente?”.
	(c) Jogar novamente: caso o usuário, ao final de um jogo, decida jogar novamente, deve ser mostrada novamente a opção de escolha de tema. Depois disso, um novo jogo é iniciado.
	(d) Sair: caso o usuário decida não jogar novamente, o programa deve mostrar o menu inicial.
4. Sair. O programa deverá imprimir o menu inicial até que essa opção seja escolhida. Caso a opção “Sair” seja escolhida, o programa irá se encerrar. */
import java.util.Scanner;
import java.util.Random;	

public class JogoJava {
		//Variaveis estáticas
		static String[][] matrizForca = new String[51][51];
		static Scanner entrada = new Scanner(System.in);
		static Random aleatorio = new Random();
			
		//Método para criar matriz inicial que armazena as palavras e os temas
		public static String matrizInicial(int i, int j) {
			//Declarações
			//Instruções
			//Temas pré-definidos
			matrizForca[0][0] = "coelho";
			matrizForca[1][0] = "oceano";
			matrizForca[2][0] = "floresta";
			matrizForca[3][0] = "rato";
			matrizForca[4][0] = "cozinha";
			//Palavras pré-definidas
			matrizForca[0][1] = "cenoura";
			matrizForca[0][2] = "dentes";
			matrizForca[1][1] = "baleia";
			matrizForca[2][1] = "pinheiro";
			matrizForca[3][1] = "ratoeira";
			matrizForca[4][1] = "faca";
				
			return matrizForca[i][j];
		}
		//Atualizar a matriz com os valores novos iniciais
		public static void atualizarMatriz() {
			for(int i = 0; i < 51; i++) {
				for(int j = 0; j < 51; j++) {
					matrizInicial(i,j);
				}
			}
		}
		//Método para verificar se há posição nula no tema
		public static int verificarTemaNulo() {
			//Declarações
			int bandeira;
			bandeira = 0;
			//Instruções
			atualizarMatriz();
			for(int i = 0; i < 51; i++) {
				bandeira = bandeira + 1;
				if(matrizForca[i][0] == null){//"null".equals(matrizForca[i][j])
					return bandeira;//Informar onde há espaço nulo
				}
			}
			return 0;//Não há espaços nulos
		}
		//Método para verificar se há posição nula na palavra
		public static int verificarPalavraNula(String temaDigitado) {
		/*
			Receber a posicao do tema em bandeiraDois pelo metodo procurandoTema
			Se o tema for achado, procurar primeira palavra nula no tema
			Se a primeira palavra nula for achada, retornar a posição j dela
			Senão, não há palavras nulas
			Se retorno for -1, há pelo menos uma palavra registrada no tema
		*/
			//Declarações
			int bandeira;
			int procurandoPalavras;
			int bandeiraDois;//Posição do tema procurado
			//Instruções
			bandeira = 0;
			procurandoPalavras = 0;
			bandeiraDois = procurandoTema(temaDigitado);
			//System.out.println("Linha do tema: " + bandeiraDois);
			if(bandeiraDois >= 0 ) {//Se tema for achado
				for(int j = 1; j < 51; j++) {
					bandeira = j;
					//System.out.println("A posição atual da coluna é: " + bandeira);//OBS
					//Se a palavra nula for achada
					if(matrizForca[bandeiraDois][j] == null){
						//System.out.println("A posição da palavra nula é: " + bandeira);//OBS
						return bandeira;//Informar onde há palavras nula
					}
					//Procurando palavras, onde elas estão?
					if(matrizForca[bandeiraDois][j] != null) {
						procurandoPalavras++;
						if(procurandoPalavras > 0) {
							return -1;//Há pelo menos uma palavra registrada no tema
						}
					}
					//Verificar se há tema cadastrado com mesmo nome
					if(matrizForca[bandeiraDois][j].equals(temaDigitado)) {
						return -1;//Há tema igual registrado
					}
				}
			}
			return 0;//Não há espaços nulos
		}
		//Método procurando palavra, onde ela está? Será que eu vou encontrar?
		public static int procurandoPalavra(String temaDigitado, String palavraDigitada) {
			//Declarações
			int bandeira;
			int bandeiraDois;
			int j;
			//Instruções
			bandeira = procurandoTema(temaDigitado);
			bandeiraDois = verificarPalavraNula(temaDigitado);
			for(j = 1; j < bandeiraDois; j++) {
				System.out.println(matrizForca[bandeira][j]);
				if(matrizForca[bandeira][j].equals(palavraDigitada)) {
					return 1;//Já há palavra digitada no tema
				}
				System.out.println(matrizForca[bandeira][j]);
			}
			
			return 0;
		}
		//Método procurando tema, onde ele está? Eu quero saber como chegar lá
		public static int procurandoTema(String temaDigitado) {
			//Declarações
			int bandeira;
			//Instruções
			for(int i = 0; i < 51; i++) {
				bandeira = i;
				//Tema foi achado
				if(temaDigitado.equals(matrizForca[i][0])) {
					//Receber posicao onde o tema se localiza
					return bandeira;//Retorna posição do tema
				}
			}
			return -1;//Não achou o tema
		}
		//Método imprimir a matriz
		public static String imprimirMatriz() {
			//Percorrer as linhas
			for(int i = 0; i < 51; i++) {
				//Percorrer as colunas por linha i
				for(int j = 0; j < 51; j++) {
					//Imprimir as colunas por linha i
					System.out.printf(" " + matrizForca[i][j]);//Matriz inicial
				}
				System.out.println("\n");
			}
			return null;
		}
		//Imprimir temas
		public static String imprimirTemasMatriz() {
			//Declarações
			int bandeira;//Onde há espaço nulo
			//Instruções
			bandeira = verificarTemaNulo();
			for(int i = 0; i < bandeira - 1; i++) {
				System.out.printf(matrizForca[i][0] + " ");
			}
			return null;
		}
		//Método escrever novo tema
		public static String novoTemaMatriz(String temaDigitado) {
			//Declarações
			int bandeira;//Gravar a primeira linha em que há null
			//Instruções
			//Verificar se há linhas nulas nos temas
			bandeira = verificarTemaNulo();
			//Se há linhas nulas
			if(bandeira != 0) {
				matrizForca[bandeira][0] = temaDigitado;
			}
			return matrizForca[bandeira][0];//Retorna elemento da matriz com tema novo
		}
		//Método para escrever nova palavra em tema selecionado
		public static String novaPalavraMatriz(String temaDigitado, String palavraDigitada) {
			//Declarações
			int bandeira;
			int bandeiraDois;
			//Instruções
			bandeira = verificarPalavraNula(temaDigitado);//Informar posição da primeira palavra nula
			bandeiraDois = procurandoTema(temaDigitado);//Informar posição do tema procurado pelo usuário
			//System.out.println("Coluna" + bandeira);//OBS ERRADO
			//System.out.println("Linha" + bandeiraDois);//OBS OK
			//Se tema foi achado
			if(bandeiraDois >= 0) {
				//Se há espaço nulo para adicionar palavra
				if(bandeira != 0) {
					matrizForca[bandeiraDois][bandeira] = palavraDigitada;
				}
			}
			return matrizForca[bandeiraDois][bandeira];
		}
		//Método do menu
		public static void metodoMenu() {
			System.out.println("JOGO DA FORCA. BEM-VINDO.");
			System.out.println("ESCOLHA UMA OPÇÃO. DIGITE UM NÚMERO.");
			System.out.println("1. Gerenciar temas.		 2. Gerenciar palavas.		3. Jogar.		4. Sair.");
		}
		//Método gerenciar temas
		public static void metodoGerenciarTemas() {
			//Declarações
			int opcao;
			String novoTema;
			int posicao;
			int posicaoDois;
			//Instruções
			System.out.println("Você escolheu: GERENCIAR TEMAS. DIGITE UM NÚMERO:");
			System.out.println("1.Cadastrar tema.		2. Excluir tema. 		3.Buscar tema. ");
			opcao = entrada.nextInt();//Receber opcao do usuário
			switch(opcao) {
		 	//Cadastrar temas
		 	case 1:
		 		System.out.println("Digite o tema para cadastrar. (Letras minusculas): ");
		 		novoTema = entrada.next();//Receber string do usuário
		 		posicaoDois = verificarPalavraNula(novoTema);
		 		if(posicaoDois >= 0) {
		 			novoTemaMatriz(novoTema);
		 			System.out.println( "O tema cadastrado foi: " + novoTemaMatriz(novoTema) );
		 		}else {
		 			System.out.println("Este tema já existe. Não é possível cadastrá-lo.");
		 		}
		 		break;
			case 2:
				System.out.println("Digite um tema para excluir. (Letras minusculas): ");
				novoTema = entrada.next();//Receber posicao do usuário
				posicao = procurandoTema(novoTema);
	 			posicaoDois = verificarPalavraNula(novoTema);//Se retornar -1, não deve excluir tema
	 			if(posicao >= 0) {
	 				if(posicaoDois >= 0) {
						matrizForca[posicao][0] = novoTemaMatriz(null);//Excluir tema
		 				System.out.println("Tema excluído com sucesso!");
					}else {
		 				System.out.println("Não foi possível excluir o tema. Verifique se existem palavras cadastradas nesse tema.");
		 			}
		 		}
		 		break;
			//Procurar tema
		 	case 3:
		 		System.out.println("Digite o tema que deseja achar: ");
		 		imprimirTemasMatriz();
		 		novoTema = entrada.next();
		 		posicao = procurandoTema(novoTema);
		 		if(posicao >= 0) {
		 			System.out.printf(novoTema +" pertence aos temas do jogo.");
		 		}else {
		 			System.out.printf(novoTema +" não pertence aos temas do jogo.");
		 		}
				break;
			}
		}
		//Método gerenciar palavras
		public static void metodoGerenciarPalavras() {
			//Declarações
			int opcao;
			String temaDigitado;
			String novaPalavra;
			int i, j;
			int posicao;
			//Instruções
			System.out.println("Você escolheu: GERENCIAR PALAVRAS. DIGITE UM NÚMERO:");
			System.out.println("1.Cadastrar palavras.		2. Excluir palavras. 		3.Buscar palavras. 		4. Listar palavras");
			opcao = entrada.nextInt();//Receber opcao do usuário
			switch(opcao) {
		 	//Cadastrar temas
		 	case 1:
		 		System.out.println("Digite o tema onde quer cadastrar uma nova palavra. (Letras minusculas):");
		 		temaDigitado = entrada.next();//Receber string do usuário
		 		System.out.println("Digite a palavra que deseja cadastrar. (Letras minusculas):");
		 		novaPalavra = entrada.next();//Receber a nova palavra
		 		posicao = procurandoPalavra(temaDigitado, novaPalavra);
		 		if(posicao == 0){
		 			novaPalavraMatriz(temaDigitado, novaPalavra);
		 			System.out.println( "Palavra " + novaPalavraMatriz(temaDigitado, novaPalavra) + " encontrada no tema " + temaDigitado);
		 		}else {
		 			System.out.println("Palavra já existe no tema procurado.");
		 		}
		 		break;
		 	//Excluir tema
		 	case 2:
		 		System.out.println("Escolha uma posicao para excluir o tema:");
		 		posicao = entrada.nextInt();//Receber posicao do usuário
		 		//Atualizar matriz
		 		for(i = 0; i < 51; i++) {
		 			if(i == posicao) {
		 				matrizForca[i][0] = novoTemaMatriz(null);
		 			}
		 		}
		 		System.out.println("Tema excluído com sucesso!");
		 		break;
		 	//Procurar tema
		 	case 3:
		 		System.out.println("Digite o tema que deseja achar:");
		 		//novoTema = entrada.next();
		 		//Percorrer as linhas
				for(i = 0; i < 51; i++) {
					//Percorrer as colunas por linha i
					for(j = 0; j < 51; j++) {
						//if(novoTema.equals(matrizForca[i][0])) {
							//Imprimir as colunas por linha i
							//System.out.printf(novoTema +" pertence aos temas do jogo.");
						}
					System.out.println("\n");
					}
				break;
			}
		}
		//Método sortear palavra
		public static String sortearPalavra(int posicao){
			//Declarações
			String sorteada;
			int numeroAleatorio;
			//Declarações
			numeroAleatorio = aleatorio.nextInt(50);//De 0 a 50 são 51 números
			sorteada = matrizForca[posicao][numeroAleatorio];
			//Verificar se palavra sorteada é nula
			if(sorteada == null) {
				while(sorteada == null) {
					numeroAleatorio = aleatorio.nextInt(50);
					sorteada = matrizForca[posicao][numeroAleatorio];
				}
			}
			return sorteada;
		}
		//Método ver se tem caracter
		public static int procurandoCaracter(String palavraSorteada, String caracterDigitado) {
			//Declarações
			//Instruções
			if(palavraSorteada.contains(caracterDigitado)) {
				return 1;//Acertou um caracter
			}
			return 0;//Errou um caracter
		}
		//Método jogar
		public static void metodoJogar() {
			//Declarações
			String temaDigitado;
			String[] vetorTentativas;
			String[] vetorAcertos;
			char resposta;
			int bandeira;
			int posicao;
			int erros;
			int pontos;
			int chutes;
			int tamanhoPalavra;
			String tentativa;
			String palavraSorteada;
			//Instruções
			vetorTentativas = new String[42];
			vetorAcertos = new String[42];
			erros = 5;//Máximo cinco tentativas
			pontos = 0;
			chutes = 0;
			System.out.println("Você escolheu: JOGAR.");
			System.out.println("Os temas para adivinhar são: ");
			imprimirTemasMatriz();
			System.out.println(" ");
			System.out.println("Digite um dos temas para jogar com este tema.");
			temaDigitado = entrada.next();
			posicao = procurandoTema(temaDigitado);//Achar a posição do tema digitado
			if(posicao >= 0) {//Se achar tema digitado
				//Sortear palavra não nula
				palavraSorteada = sortearPalavra(posicao);
				tamanhoPalavra = palavraSorteada.length();
				System.out.println("O tema é: " + temaDigitado);//Mostrar tema digitado
				//Começar jogo
				do {
					System.out.println("Digite uma letra, mas não perca a cabeça!");
					tentativa = entrada.next();//Ler letra
					//Ver se está na palavra
					bandeira = procurandoCaracter(palavraSorteada, tentativa);//Retorna 1 se acertar letra
					//Ver se tentativa é repetida
					if(chutes > 0) {
						do {//Na primeira vez nada acontecerá
							if(vetorTentativas[chutes - 1].equals(tentativa)) {//Se a nova tentativa for igual a anterior
								System.out.println("Tente outra letra!");
								tentativa = entrada.next();//Ler tentativa
							}
						}while(vetorTentativas[chutes - 1].equals(tentativa));
					}
					vetorTentativas[chutes] = tentativa;//Armazenar cada tentativa em uma posição do vetor tentativa
					chutes++;
					//Se 1, usuário acertou uma palavra
					if(bandeira == 1) {
						vetorAcertos[pontos] = tentativa;
						pontos++;
						System.out.println("Parabéns, você acertou uma palavra!");
						System.out.println("Palavra acertada: " + tentativa);
						if(pontos == tamanhoPalavra) {
							System.out.println("Parabéns! Você acertou a palavra! Deseja jogar novamente?");
							resposta = entrada.next().charAt(0);
							if(resposta == 's' || resposta == 'S') {
								//Jogar novamente
								metodoJogar();
							}else {
								//Terminar jogo
								metodoSair();
							}
						}
					}else {
						if(bandeira == 0 ) {
							erros--;
						System.out.println("Você errou uma palavra! Restam " + erros + " tentativas!");
						}
					}
				}while(erros > 0);
				if(erros == 0) {
					//Perguntar se usuário deseja jogar novamente
					System.out.println("Você perdeu! Deseja jogar novamente?");
					resposta = entrada.next().charAt(0);
					if(resposta == 's' || resposta == 'S') {
						//Jogar novamente
						metodoJogar();
					}else {
						//Terminar jogo
						metodoSair();
					}
				}
			}
		}
		//Método sair
		public static void metodoSair() {
			System.out.println("Você escolheu: SAIR.");
			System.exit(0);
		}
		//Método principal
	 	public static void main(String[] args) {
	 	//Declarações
	 	int escolhaMenu;
	 	//Instruções
		atualizarMatriz();
	 	metodoMenu();//Chamar menu
	 	escolhaMenu = entrada.nextInt();//Ler opcao do menu
		//Menu retorna a opcao desejada
	 	switch(escolhaMenu) {
	 	//Gerenciar temas
		case 1:
		 	metodoGerenciarTemas();
			break;
		case 2:
		 	//Chamar método gerenciarPalavras
		 	metodoGerenciarPalavras();
		 	break;
		 case 3:
		 	//Chamar método Jogar
		 	metodoJogar();
		 	break;
		 case 4:
		 	//Chamar método sair
		 	metodoSair();
		 	break;
	 	}
	 }
}
