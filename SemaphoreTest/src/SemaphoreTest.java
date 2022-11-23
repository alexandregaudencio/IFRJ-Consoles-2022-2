import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	private static final Semaphore semaforo = new Semaphore(3);
	
	
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		Runnable r1 = () -> {
			String name = Thread.currentThread().getName();
			int usuario = new Random().nextInt(10000);
			
			//tenta passar se houver thread disponível. (que está limitada a 3 threads máximas)
			acquire();
			System.out.println("Usuário "+usuario+ ". Name: "+ name);
			
			sleep();
			semaforo.release();
		};
		
		
		for(int i = 0; i < 500; i++) {
			executor.execute(r1);
		}
		executor.shutdown();
		
	}
	
	
	private static void acquire() {
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void sleep() {
		try {
			int tempoEspera = new Random().nextInt(6);
			tempoEspera++;
			Thread.sleep(tempoEspera*100);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}
	
}
