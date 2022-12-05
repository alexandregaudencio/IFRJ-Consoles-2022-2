import java.util.Random;
import java.util.concurrent.Semaphore;

public class Player extends Thread {
	
	private int id;
	private int jogada;
	private int pontos = 0;
	private Semaphore semaforo;
	private boolean jogou = false;
	//0 : Pedra  //1 : Papel  //2 : Tesoura
	private Random escolha = new Random();
	
	public Player(int id) {
		this.id = id;
		semaforo = new Semaphore(1);
	}
		
	public long getId() {
		return id;
	}
	public int getPontos() {
		return pontos;
	}
	public void acrescentaPonto() {
		pontos++;
	}

	public int getJogada() {
		return jogada;
	}
	
	public boolean getJogou() {
		return jogou;
	}
	
	private int escolher() {
		return escolha.nextInt(3);
	}

	public void jogar() {
			try {
				semaforo.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			jogada = escolher();
			jogou = true;
			semaforo.release();
	}
		

	public void reiniciar() {
		jogou = false;
	}
	
}
