import java.util.Random;
import java.util.concurrent.Semaphore;

public class Player extends Thread {
	
	private int id;
	private int pontos = 0;
	private Semaphore semaforo;
	private int numJogadas;
	//0 : Pedra  //1 : Papel  //2 : Tesoura
	private Random escolha = new Random();
	
	private int jogada;
	private int[] jogadas;

	@Override
	public void run() {
		super.run();

		threadJogar(numJogadas);
	}
	
	public Player(int id, int numJogadas) {
		this.id = id;		
		this.numJogadas = numJogadas;
		semaforo = new Semaphore(1);
	}
	

	public long getId() {
		return id;
	}
	public int getJogada(int index) {
		
		return jogadas[index];
	}
	public int[] getJogadas() {
		
		return jogadas;
	}
	public int getPontos() {
		return pontos;
	}
	public void acrescentaPonto() {
		pontos++;
	}
	private int getValue() {
		return escolha.nextInt(3);
	}
	

	public void threadJogar(int count) {
		jogadas = new int[count];
		for(int i = 0; i < count; i++) {
			
			try {
				semaforo.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			jogada = getValue();
			jogadas[i] = jogada;			
			semaforo.release();
		}
		System.out.println("total jogadas: "+jogadas.length);
	}
	
	
	public void jogar(int count) {
		jogadas = new int[count];
		for(int i = 0; i < count; i++) {
			jogada = getValue();
			jogadas[i] = jogada;			
		}
		System.out.println("total jogadas: "+jogadas.length);
	}
	
	
}
