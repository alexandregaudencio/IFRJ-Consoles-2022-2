public class ThreadWorker extends Thread{
	public int[] arr;

	public ThreadWorker(int[] arr) {
		this.arr = arr;
	}
	
	@Override
	public void run() {
		super.run();
		
		arr = InverseArray(arr);
	}
	
	private static  int[]  InverseArray(int[] arr) {
		int[] arrAux = new int[3];
		for(int i = 0; i < arr.length; i++) {
			arrAux[i] = arr[2-i];
		}
		return arrAux;
	}

}
