
public class Mian {

	public static void main(String[] args) {
		ThreadCounter threads[] = new ThreadCounter[2];
		
		threads[0] = new ThreadCounter(500,false);
		threads[0].start();
		
		threads[1] = new ThreadCounter(500,true);
		threads[1].start();

		System.out.println("Fim de execução");
		
	
}
	}
