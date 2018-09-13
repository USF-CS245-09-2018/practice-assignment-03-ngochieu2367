import java.util.Random;


public class Practice03Test {

	protected int count = 0;
	protected double [] arr;


	/**
	 * Constructor
	 */
	public Practice03Test (String [] args) {
		try {
			count = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("Defaulting array size to 20.");
			count = 20;
		}
		arr = new double[count];
		generate_array();
	}


	/**
	 * print_array: prints the array of doubles... formatted so it fits
	 * ... on many small screens.
	 */
	public void print_array() {
		System.out.println("------------------------------------");
		System.out.println("Array contains the values:");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%.2f ", arr[i]);
			if (i > 0 && i % 9 == 0)
				System.out.println();
		}
		System.out.println("\n------------------------------------");
	}


	/**
	 * Fills the array with random double instances.
	 */
	public void generate_array() {
		Random rand = new Random();
		double min = 1.0;
		double max = 100.0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = min + rand.nextDouble() * (max-min);
		}
	}


	public int find_min_iterative () {
		// TODO: Fill in this iterative function.    
		int lowest = 0;                           			// O(1)          
		for (int i = 0; i < arr.length; i++)				// O(3)		
			if (arr[lowest] > arr[i])						// O 3(n-1)
				lowest = i;									// O 2(n-1)
		return lowest;										// O(1)
	}														// Running time for Find min Iterative: O(n-1)

	public int find_min_recursive(int start, int end){
		if(start == end){									// O(1)
			return start;									// O(1)
		}
		int mid = (start + end) / 2;                        // O(3)
		int r1 = find_min_recursive(start,mid);				// O(n)
		int r2 = find_min_recursive(mid+1,end);				// O(n)
		if(arr[r1] < arr[r2]){                              // O(1)
			return r1;										// O(1)
		}
		else{
			return r2;										// O(1)
		}
	}

	public int find_min_recursive () {
		// TODO: Fill in this recursive function.
		return find_min_recursive(0,arr.length-1);         // O(1)

	}														//Running time for Find min Recursive: O(n)


	/**
	 * print_min: determines the min iteratively and recursively.
	 * ... and prints them both.
	 */
	public void print_min() {
		System.out.println("Iteratively determined min at index " + find_min_iterative());
		System.out.println("Recursively determined min at index " + find_min_recursive());
	}


	/**
	 * main for Practice 03: print the array and determine the min.
	 */
	public static void main(String [] args) {
		Practice03Test test = new Practice03Test(args);
		test.print_array();
		test.print_min();
	}

}
