import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int arr[] = {0,1,2,3};

		Scanner sc = new Scanner(System.in);
		System.out.print("data ke: ");
		int indexInput = sc.nextInt();

		System.out.println("\n/// Exception biasa ///");
		try {
			System.out.printf("data dari array ke-%d adalah %d\n", indexInput, arr[indexInput]);
		} catch(Exception e) {
			System.err.println(e);
		} 

		System.out.println("\n/// Exception dengan Method ///");
		int data = ambilDataDariArray(arr,indexInput);
		System.out.printf("data dari array ke-%d adalah %d\n", indexInput, data);

		// exception throw by method
		System.out.println("\n/// Exception throws by method ///");
		int data2 = 0;
		try {
			data2 = ambilData(arr,indexInput);
		} catch(Exception e) {
			System.err.println(e);
		}
		System.out.printf("data dari array ke-%d adalah %d\n", indexInput, data2);
	}

	private static int ambilData(int arr[], int n) throws Exception {
		int res = arr[n];
		return res;
	}

	private static int ambilDataDariArray(int arr[], int n) {
		int res = 0;
		try {
			res = arr[n];
		} catch(Exception e) {
			System.out.println(e);
		}
		return res;
	}


}



