
public class ThreadMultiply extends Thread {

	public int[] numbers;
	public int index;
	public int multiplier;
	
	public ThreadMultiply(int[] numbers, int multiplier, int index) {
		this.numbers = numbers;
		this.index = index;
		this.multiplier = multiplier;

		
	}
	
	public void run() {
		for(int i = 0+index*100; i < numbers.length; i++) {
			numbers[i] = numbers[i]*multiplier;
		}
		
	}
	

	
	
}
