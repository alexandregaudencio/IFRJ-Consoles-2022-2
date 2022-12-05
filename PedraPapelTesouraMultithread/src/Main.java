import java.util.concurrent.Semaphore;

public class Main {
	
	private static int numJogadas = 10;
	private static Jogo jogo;
	public static void main(String[] args) {
		jogo = new Jogo(numJogadas);
		jogo.start();
	}



}

