public class Main {
	
	static int[][] matrix3 = { 
		{ 1,2,3 },
		{ 4,5,6 },
	    { 7,8,9 },
	};


	public static void main(String[] args) {
		//Singlethread work
		long start = System.currentTimeMillis();
		int[][] seqMatrix3 = Matrix3Inverse(matrix3);
		PrintMatrix(seqMatrix3);
		long seqTime = System.currentTimeMillis() - start;
		
		System.out.println("Tempo sequencial: "+seqTime);

		
		
		//multithread work
		start = System.currentTimeMillis();
		ThreadWorker threads[] = new ThreadWorker[3];
		for (int i = 0; i <= 2; i++) {
			threads[i] = new ThreadWorker(matrix3[i]);
			threads[i].start();
		}
		
		
		try {
			for (int i = 0; i < threads.length; i++)
				threads[i].join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int[][] parlMatrix3 = BuildMatrix3(threads[0].arr, threads[1].arr, threads[2].arr);
		PrintMatrix(parlMatrix3);
		long paralTime = System.currentTimeMillis() - start;
		System.out.println("Tempo paralelo "+paralTime);

		
		
	}
	
	
	
	private static void PrintMatrix(int[][] matrix3) {
		for (int [] row : matrix3){
			// traverses through number of rows
			for (int element : row)
			{
				// 'element' has current element of row index
				System.out.print( element  + "   ");
			}
			System.out.println();
		}

	}
	
	private static int[][] Matrix3Inverse(int[][] matrix3) {
		int[][] matrix3Aux = new int[3][3];
		
		for(int i = 0; i < matrix3.length; i++) {
			for(int j = 0; j < matrix3[i].length; j++) {
				matrix3Aux[i][j] = matrix3[i][2-j];
			}
		}
		return matrix3Aux;
	}
	
	private static int[][] BuildMatrix3(int[] row1, int[] row2, int[] row3) {
		 int[][] matrix3Aux = new int[3][3];
		for(int j = 0; j < row1.length; j++) {
			matrix3Aux[0][j] = row1[j];
		}
		for(int j = 0; j < row2.length; j++) {
			matrix3Aux[1][j] = row2[j];
		}
		for(int j = 0; j < row3.length; j++) {
			matrix3Aux[2][j] = row3[j];
		}

		return matrix3Aux;
	}
	
}
