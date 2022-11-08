import java.util.Random;

public class Main {

	private static int multiplier = 10;
	
	private static int[] numbers = new int[1000];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateRandomArray(numbers.length);

		printArrayValues(numbers);

		ThreadMultiply threads[] = new ThreadMultiply[10];
		
		
		for(int i = 0; i < threads.length; i++) {
			threads[i] = new ThreadMultiply(numbers,  multiplier, i*100 );
			threads[i].start();
		}
	
		
		printArrayValues(numbers);
	
	}

	
	
	
	
	private static void printArrayValues(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" \n");
		}
	}
	
	private static void generateRandomArray(int maxValue) {
		for(int i = 0; i < maxValue; i++) {
			numbers[i] = i;
			//System.out.println(numbers[i]);
		}
	}
	
	
	
}

