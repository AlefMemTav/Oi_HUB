/*
1. Gerenciar Temas: o programa dever� ser capaz de armazenar at� 50 diferentes temas.
	(a) Cadastro: o usu�rio poder� cadastrar temas no programa. N�o poder�o existir temas com nomes iguais.
	(b) Exclus�o: o usu�rio poder� excluir temas desde que n�o existam palavras associadas a ele. Caso n�o seja poss�vel realizar exclus�o, o programa dever� exibir e mensagem �N�o foi poss�vel excluir o tema. Verifique se existem palavras cadastradas nesse tema.�
	(c) Busca: o usu�rio poder� buscar por temas cadastrados no sistema.
2. Gerenciar Palavras: o programa dever� ser capaz de armazenar at� 50 palavras para cada um dos temas cadastrados.
	(a) Cadastro: o usu�rio poder� cadastrar palavras no programa. Para tanto, ele deve escolher um tema e s� ent�o realizar o cadastro. Aten��o! n�o poder�o existir palavras iguais dentro de um mesmo tema.
	(b) Exclus�o: o usu�rio poder� excluir palavras cadastradas no programa.
	(c) Busca: o usu�rio deve ser capaz de buscar por uma palavra no conjunto de todas as palavras cadastradas no programa. Caso uma palavra n�o seja encontrada, deve ser retornada a mensagem �Palavra n�o encontrada�, caso contr�rio a mensagem a ser retornada � �Palavra encontrada no tema XYZ�, onde XYZ � o tema em que a palavra est�.
	(d) Listagem: o usu�rio poder� selecionar um tema e ver todas as palavras cadastrada naquele tema.
3. Jogar
	(a) Sele��o de tema: antes de iniciar um jogo, o usu�rio dever� selecionar um tema onde ser� buscada a palavra.
	(b) Jogo:
		i. Em cada rodada, o usu�rio deve escolher uma letra.
		ii. Caso a letra j� tenha sido tentada, o programa dever� mostrar a mensagem: �Tente outra letra!�
		iii. Para cada letra tentada pelo usu�rio e n�o presente na palavra, dever� ser contabilizado um erro.
		iv. O usu�rio poder� ter no m�ximo cinco erro. Ap�s a quinta tentativa errada, o programa dever� mostrar a mensagem �Voc� perdeu! Deseja Deseja jogar novamente?�. N�o � necess�rio mostrar a palavra no final da partida.
		v. Caso o usu�rio acerte a palavra, o programa dever� mostrar a mensagem: �Parab�ns! Voc� acertou a palavra! Deseja jogar novamente?�.
	(c) Jogar novamente: caso o usu�rio, ao final de um jogo, decida jogar novamente, deve ser mostrada novamente a op��o de escolha de tema. Depois disso, um novo jogo � iniciado.
	(d) Sair: caso o usu�rio decida n�o jogar novamente, o programa deve mostrar o menu inicial.
4. Sair. O programa dever� imprimir o menu inicial at� que essa op��o seja escolhida. Caso a op��o �Sair� seja escolhida, o programa ir� se encerrar. */
import java.util.Scanner;
import java.util.Random;
	
public class JogoJava {
		//Variaveis est�ticas
		static String[][] matrizForca = new String[51][51];
		static Scanner entrada = new Scanner(System.in);
		static Random aleatorio = new Random();
			
		//M�todo para criar matriz inicial que armazena as palavras e os temas
		public static String matrizInicial(int i, int j) {
			//Declara��es
			//Instru��es
			//Temas pr�-definidos
			matrizForca[0][0] = "Coelho";
			matrizForca[1][0] = "Oceano";
			matrizForca[2][0] = "Floresta";
			matrizForca[3][0] = "Rato";
			matrizForca[4][0] = "Cozinha";
			//Palavras pr�-definidas
			matrizForca[0][1] = "Cenoura";
			matrizForca[0][2] = "Dentes";
			matrizForca[1][1] = "Baleia";
			matrizForca[2][1] = "Pinheiro";
			matrizForca[3][1] = "Ratoeira";
			matrizForca[4][1] = "Faca";
				
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
		//M�todo para verificar se h� posi��o nula no tema
		public static int verificarTemaNulo() {
			//Declara��es
			int bandeira;
			bandeira = 0;
			//Instru��es
			atualizarMatriz();
			for(int i = 0; i < 51; i++) {
				bandeira = bandeira + 1;
				if(matrizForca[i][0] == null){//"null".equals(matrizForca[i][j])
					return bandeira;//Informar onde h� espa�o nulo
				}
			}
			return 0;//N�o h� espa�os nulos
		}
		//M�todo para verificar se h� posi��o nula na palavra
		public static int verificarPalavraNula(String temaDigitado) {
		/*
			Receber a posicao do tema em bandeiraDois pelo metodo procurandoTema
			Se o tema for achado, procurar primeira palavra nula no tema
			Se a primeira palavra nula for achada, retornar a posi��o j dela
			Sen�o, n�o h� palavras nulas
			Se retorno for -1, h� pelo menos uma palavra registrada no tema
		*/
			//Declara��es
			int bandeira;
			int procurandoPalavras;
			int bandeiraDois;//Posi��o do tema procurado
			//Instru��es
			bandeira = 0;
			procurandoPalavras = 0;
			bandeiraDois = procurandoTema(temaDigitado);
			//System.out.println("Linha do tema: " + bandeiraDois);
			if(bandeiraDois >= 0 ) {//Se tema for achado
				for(int j = 1; j < 51; j++) {
					bandeira = j;
					//System.out.println("A posi��o atual da coluna �: " + bandeira);//OBS
					//Se a palavra nula for achada
					if(matrizForca[bandeiraDois][j] == null){
						//System.out.println("A posi��o da palavra nula �: " + bandeira);//OBS
						return bandeira;//Informar onde h� palavras nula
					}
					//Procurando palavras, onde elas est�o?
					if(matrizForca[bandeiraDois][j] != null) {
						procurandoPalavras++;
						if(procurandoPalavras > 0) {
							return -1;//H� pelo menos uma palavra registrada no tema
						}
					}
					//Verificar se h� tema cadastrado com mesmo nome
					if(matrizForca[bandeiraDois][j].equals(temaDigitado)) {
						return -1;//H� tema igual registrado
					}
				}
			}
			return 0;//N�o h� espa�os nulos
		}
		//M�todo procurando tema, onde ele est�?
		public static int procurandoTema(String temaDigitado) {
			//Declara��es
			int bandeira;
			//Instru��es
			for(int i = 0; i < 51; i++) {
				bandeira = i;
				//Tema foi achado
				if(temaDigitado.equals(matrizForca[i][0])) {
					//Receber posicao onde o tema se localiza
					return bandeira;//Retorna posi��o do tema
				}
			}
			return -1;//N�o achou o tema
		}
		//M�todo imprimir a matriz
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
			//Declara��es
			int bandeira;//Onde h� espa�o nulo
			//Instru��es
			bandeira = verificarTemaNulo();
			for(int i = 0; i < bandeira - 1; i++) {
				System.out.printf(matrizForca[i][0] + " ");
			}
			return null;
		}
		//M�todo escrever novo tema
		public static String novoTemaMatriz(String temaDigitado) {
			//Declara��es
			int bandeira;//Gravar a primeira linha em que h� null
			//Instru��es
			//Verificar se h� linhas nulas nos temas
			bandeira = verificarTemaNulo();
			//Se h� linhas nulas
			if(bandeira != 0) {
				matrizForca[bandeira][0] = temaDigitado;
			}
			return matrizForca[bandeira][0];//Retorna elemento da matriz com tema novo
		}
		//M�todo para escrever nova palavra em tema selecionado
		public static String novaPalavraMatriz(String temaDigitado, String palavraDigitada) {
			//Declara��es
			int bandeira;
			int bandeiraDois;
			//Instru��es
			bandeira = verificarPalavraNula(temaDigitado);//Informar posi��o da primeira palavra nula
			bandeiraDois = procurandoTema(temaDigitado);//Informar posi��o do tema procurado pelo usu�rio
			//System.out.println("Coluna" + bandeira);//OBS ERRADO
			//System.out.println("Linha" + bandeiraDois);//OBS OK
			//Se tema foi achado
			if(bandeiraDois >= 0) {
				//Se h� espa�o nulo para adicionar palavra
				if(bandeira != 0) {
					matrizForca[bandeiraDois][bandeira] = palavraDigitada;
				}
			}
			return matrizForca[bandeiraDois][bandeira];
		}
		//M�todo do menu
		public static void metodoMenu() {
			System.out.println("JOGO DA FORCA. BEM-VINDO.");
			System.out.println("ESCOLHA UMA OP��O. DIGITE UM N�MERO.");
			System.out.println("1. Gerenciar temas.		 2. Gerenciar palavas.		3. Jogar.		4. Sair.");
		}
		//M�todo gerenciar temas
		public static void metodoGerenciarTemas() {
			//Declara��es
			int opcao;
			String novoTema;
			int posicao;
			int posicaoDois;
			//Instru��es
			System.out.println("Voc� escolheu: GERENCIAR TEMAS. DIGITE UM N�MERO:");
			System.out.println("1.Cadastrar tema.		2. Excluir tema. 		3.Buscar tema. ");
			opcao = entrada.nextInt();//Receber opcao do usu�rio
			switch(opcao) {
		 	//Cadastrar temas
		 	case 1:
		 		System.out.println("Digite o tema para cadastrar: ");
		 		novoTema = entrada.next();//Receber string do usu�rio
		 		posicaoDois = verificarPalavraNula(novoTema);//Se for 200, temas repetidos
		 		if(posicaoDois >= 0) {
		 			novoTemaMatriz(novoTema);
		 			System.out.println( "O tema cadastrado foi: " + novoTemaMatriz(novoTema) );
		 		}else {
		 			System.out.println("Este tema j� existe. N�o � poss�vel cadastr�-lo.");
		 		}
		 		break;
			case 2:
				System.out.println("Digite um tema para excluir: ");
				novoTema = entrada.next();//Receber posicao do usu�rio
				posicao = procurandoTema(novoTema);
	 			posicaoDois = verificarPalavraNula(novoTema);//Se retornar -1, n�o deve excluir tema
	 			if(posicao >= 0) {
	 				if(posicaoDois >= 0) {
						matrizForca[posicao][0] = novoTemaMatriz(null);//Excluir tema
		 				System.out.println("Tema exclu�do com sucesso!");
					}else {
		 				System.out.println("N�o foi poss�vel excluir o tema. Verifique se existem palavras cadastradas nesse tema.");
		 			}
		 		}
		 		break;
			//Procurar tema
		 	case 3:
		 		System.out.println("Digite o tema que deseja achar: ");
		 		novoTema = entrada.next();
		 		posicao = procurandoTema(novoTema);
		 		if(posicao >= 0) {
		 			System.out.printf(novoTema +" pertence aos temas do jogo.");
		 		}else {
		 			System.out.printf(novoTema +" n�o pertence aos temas do jogo.");
		 		}
				break;
			}
		}
		//M�todo gerenciar palavras
		public static void metodoGerenciarPalavras() {
			//Declara��es
			int opcao;
			String temaDigitado;
			String novaPalavra;
			int i, j;
			int posicao;
			//Instru��es
			System.out.println("Voc� escolheu: GERENCIAR PALAVRAS. DIGITE UM N�MERO:");
			System.out.println("1.Cadastrar palavras.		2. Excluir palavras. 		3.Buscar palavras. 		4. Listar palavras");
			opcao = entrada.nextInt();//Receber opcao do usu�rio
			switch(opcao) {
		 	//Cadastrar temas
		 	case 1:
		 		System.out.println("Digite o tema onde quer cadastrar uma nova palavra:");
		 		temaDigitado = entrada.next();//Receber string do usu�rio
		 		System.out.println("Digite a palavra que deseja cadastrar:");
		 		novaPalavra = entrada.next();//Receber a nova palavra
		 		novaPalavraMatriz(temaDigitado, novaPalavra);
		 		System.out.println( "O tema " + temaDigitado + " recebeu " + novaPalavraMatriz(temaDigitado, novaPalavra) );
		 		break;
		 	//Excluir tema
		 	case 2:
		 		System.out.println("Escolha uma posicao para excluir o tema:");
		 		posicao = entrada.nextInt();//Receber posicao do usu�rio
		 		//Atualizar matriz
		 		for(i = 0; i < 51; i++) {
		 			if(i == posicao) {
		 				matrizForca[i][0] = novoTemaMatriz(null);
		 			}
		 		}
		 		System.out.println("Tema exclu�do com sucesso!");
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
		//M�todo sortear palavra
		public static String sortearPalavra(int posicao){
			//Declara��es
			String sorteada;
			int numeroAleatorio;
			//Declara��es
			numeroAleatorio = aleatorio.nextInt(50);//De 0 a 50 s�o 51 n�meros
			sorteada = matrizForca[posicao][numeroAleatorio];
			//Verificar se palavra sorteada � nula
			if(sorteada == null) {
				while(sorteada == null) {
					numeroAleatorio = aleatorio.nextInt(50);
					sorteada = matrizForca[posicao][numeroAleatorio];
				}
			}
			return sorteada;
		}
		//M�todo ver se tem caracter
		public static int procurandoCaracter(String palavraSorteada, String caracterDigitado) {
			//Declara��es
			//Instru��es
			if(palavraSorteada.contains(caracterDigitado)) {
				return 1;//Acertou um caracter
			}
			return 0;//Errou um caracter
		}
		//M�todo acertou/errou
		public static void acertouErrou() {
			//Declara��es
			//Instru��es
		}
		//M�todo jogar
		public static void metodoJogar() {
			//Declara��es
			String temaDigitado;
			String[] vetorTentativas;
			int bandeira;
			int posicao;
			int erros;
			int pontos;
			String tentativa;
			String palavraSorteada;
			//Instru��es
			vetorTentativas = new String[5];
			erros = 0;//M�ximo cinco tentativas
			pontos = 0;
			System.out.println("Voc� escolheu: JOGAR.");
			System.out.println("Os temas para adivinhar s�o: ");
			imprimirTemasMatriz();
			System.out.println(" ");
			System.out.println("Digite um dos temas para jogar com este tema.");
			temaDigitado = entrada.next();
			posicao = procurandoTema(temaDigitado);//Achar a posi��o do tema digitado
			//Se achar tema digitado
			if(posicao >= 0) {
				//Sortear palavra n�o nula
				palavraSorteada = sortearPalavra(posicao);
				System.out.println("O tema �: " + temaDigitado);
				//Come�ar jogo
				System.out.println("Digite uma letra, mas n�o perca a cabe�a!");
				tentativa = entrada.next();//Ler char
				//Ver se string est� na palavra
				bandeira = procurandoCaracter(palavraSorteada, tentativa);//Retorna 1 se verdadeiro
				vetorTentativas[pontos] = tentativa;//Armazenar cada tentativa em uma posi��o do vetor tentativa
				pontos++;
				//Se 1, usu�rio acertou uma palavra
				if(bandeira == 1) {
					System.out.println("Parab�ns, voc� acertou uma palavra!");
				}else {
					if(bandeira == 0 ) {
						System.out.println("Voc� errou uma palavra! Restam somente " + (5 - pontos) + " tentativas");
					}
				}
				//Se n�o, perdeu uma chance pontos--
			}
		}
		//M�todo sair
		public static void metodoSair() {
			System.out.println("Voc� escolheu: SAIR.");
			System.exit(0);
		}
		//M�todo principal
	 	public static void main(String[] args) {
	 	//Declara��es
	 	int escolhaMenu;
	 	//Instru��es
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
		 	//Chamar m�todo gerenciarPalavras
		 	metodoGerenciarPalavras();
		 	break;
		 case 3:
		 	//Chamar m�todo Jogar
		 	metodoJogar();
		 	break;
		 case 4:
		 	//Chamar m�todo sair
		 	metodoSair();
		 	break;
	 	}
	 }
}
