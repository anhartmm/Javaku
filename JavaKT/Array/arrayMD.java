import java.util.Arrays;

public class ArrayMD {
	public static void main(String[] args) {
		int arrMD[][] = new int[3][4];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				arrMD[i][j] = j+1;
				System.out.printf("%d ",arrMD[i][j]);
			}
			System.out.println();
		}			

		System.out.println(arrMD.length);

		int arr_2D[][] = {
			{1,2},
			{3,4}
		};

		System.out.println();

		for(int baris[] : arrMD) {
			for(int i : baris) {
				System.out.printf("%d ",i);
			}
			System.out.println();
		}

		System.out.println();
		print(arr_2D);
		System.out.println();
		printArray2D(arr_2D);
		System.out.println();
		printArray2D(arrMD);
	}
	
	private static void print(int arr_2D[][]) {
		System.out.println(Arrays.deepToString(arr_2D));
	}

	private static void printArray2D(int arr[][]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("%s \n", Arrays.toString(arr[i]));
		}
	}

}