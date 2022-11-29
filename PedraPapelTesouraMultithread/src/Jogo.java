import java.util.Hashtable;

public class Jogo extends Thread {

	private  Player player1 = new Player(0);
	private  Player player2 = new Player(1);
	private int jogadas;
	private int jogoAtual = 1;
	static Hashtable hashtable = new Hashtable();
	
	public Jogo(int jogadas) {
		this.jogadas = jogadas;
		
		hashtable.put(0, "pedra");
		hashtable.put(1, "papel");
		hashtable.put(2, "tesoura");
	}
	
	@Override
	public void run() {
		iniciarJogo();
	}
	
	private void iniciarJogo() {
			player1.start();
			player2.start();
			
			lancarRodadas();
	}

	public void lancarRodadas() {
		while(jogoAtual <= jogadas) {	
			if(!player1.getJogou() && !player2.getJogou()) {
				
				player1.jogar();
				player2.jogar();
				
				try {
					player1.join();
					player2.join();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				player1.reiniciar();
				player2.reiniciar();
				jogoAtual++;
				verificarJogo();

			}	
		}

		mostrarResultado();		
			
	}

	private void verificarJogo() {
		System.out.println("jogador1. Jogada"+jogoAtual+" "+hashtable.get(player1.getJogada()));
		System.out.println("jogador2. Jogada"+jogoAtual+" "+hashtable.get(player2.getJogada()));
		
		int diferenca = player1.getJogada() - player2.getJogada();
		if(diferenca == 0) System.out.println("EMPATE");
		else  if(diferenca > 0 || diferenca == -2) {
			System.out.println("JOGADOR 1 GANHOU");
			player1.acrescentaPonto();
		} else if(diferenca < 0 || diferenca == 2) {
			System.out.println("JOGADOR 2 GANHOU");
			player2.acrescentaPonto();
		}

	}

	private void mostrarResultado()  {
		System.out.println("RESULTADO FINAL");
		System.out.println("jogador1 "+player1.getPontos());
		System.out.println("jogador2 "+player2.getPontos());
		if(player1.getPontos() > player2.getPontos()) 
			System.out.println("jogador1 VENCEU!");
		else 
			System.out.println("jogador1 VENCEU!");
	}
	
	

}
