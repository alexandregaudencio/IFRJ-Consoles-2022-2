import java.util.Hashtable;

public class Main {
	
	private static int numJogadas = 10000;
	static Hashtable hashtable = new Hashtable();
	
	public static void main(String[] args) {
		hashtable.put(0, "pedra");
		hashtable.put(1, "papel");
		hashtable.put(2, "tesoura");
		
		
		//JOGADA MULTITHREAD
//		long tempoInitThread = System.currentTimeMillis();
		Player[] threads = new Player[2];
		for(int i = 0; i < threads.length; i++) {
			threads[i] = new Player(i, numJogadas);
			threads[i].start();
		}
			
		verificarGanhador(threads[0], threads[1], numJogadas);
//		long tempoFinalThread = System.currentTimeMillis();

	
		//JOGA SINGLETHREAD
//		long tempoInit = System.currentTimeMillis();
		Player[] players = new Player[2];
		players[0] = new Player(0, numJogadas);
		players[1] = new Player(1, numJogadas);
		players[0].jogar(numJogadas);
		players[1].jogar(numJogadas);
		verificarGanhador(players[0], players[1], numJogadas);
//		long tempoFinal = System.currentTimeMillis();

//		System.out.println("Tempo total: "+(tempoFinal - tempoInit));
//		System.out.println("Thread Tempo total: "+(tempoFinalThread - tempoInitThread));


		
		
	}
	
	public static void verificarGanhador(Player jogador1, Player jogador2, int numJogadas) {
		for(int i = 0; i < numJogadas; i++) {
			System.out.println("jogador1. Jogada"+i+" "+hashtable.get(jogador1.getJogada(i)));
			System.out.println("jogador2. Jogada"+i+" "+hashtable.get(jogador2.getJogada(i)));
			
			int diferenca = jogador1.getJogada(i) - jogador2.getJogada(i);
			if(diferenca == 0) System.out.println("EMPATE");
			else  if(diferenca > 0 || diferenca == -2) {
				System.out.println("JOGADOR 1 GANHOU");
				jogador1.acrescentaPonto();

			} else if(diferenca < 0 || diferenca == 2) {
				System.out.println("JOGADOR 2 GANHOU");
				jogador2.acrescentaPonto();
			}
			
				
			
		}
		
		mostrarScore(jogador1, jogador2);
		
	}
	
	
	private static void mostrarScore(Player jogador1, Player jogador2)  {
		System.out.println("RESULTADO FINAL");
		System.out.println("jogador1 "+jogador1.getPontos());
		System.out.println("jogador2 "+jogador2.getPontos());
		if(jogador1.getPontos() > jogador2.getPontos()) 
			System.out.println("jogador1 VENCEU!");
		else 
			System.out.println("jogador1 VENCEU!");
	}

}
