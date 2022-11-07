
public class ThreadCounter extends Thread {
	public int number = 500;
	public boolean descending;
	public ThreadCounter(int number, boolean descending) {
		this.number = number;
		this.descending = descending;
		
	}
	
	@Override
	public void run() {
		super.run();
		
		PrintNumbers();
		
	}
	
	public void PrintNumbers() {
		long start = System.currentTimeMillis();
		if(descending) {
			for(int i = 1; i <= number; i++) {
				System.out.println(descending+" :"+i);
			}
		} else {
			for(int i = 500; i >= 1; i--) {
				System.out.println(descending+" :"+i);
			}
		}
		System.out.println("Tem de execução em "+ this.descending+": "+ (long)(System.currentTimeMillis() - start));

	}
	

	
	
}
