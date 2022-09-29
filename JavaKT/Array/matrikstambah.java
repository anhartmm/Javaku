import java.util.*;

public class MatriksTambah {
	public static void main(String[] args) {
		int satu[][] = {
			{4,5,6},
			{2,7,3},
			{8,9,2}
		};
		int dua[][] = {
			{3,7,8},
			{6,1,9},
			{5,2,1}
		};

		printarray(satu);
		System.out.println();
		printarray(dua);
		TambahMatriks(satu,dua);
		System.out.println();
		KaliMatriks(satu,dua);
		System.out.println();

	}

	private static void printarray(int arr[][]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("%s \n",Arrays.toString(arr[i]));
		}
	}

	private static void TambahMatriks(int arr[][],int arr2[][]) {
		int res[][] = new int[arr.length][arr.length];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				res[i][j] = arr[i][j] + arr2[i][j];
			}
			System.out.println();
		}
		printarray(res);
	}

	private static void KaliMatriks(int arr[][], int arr2[][]) {
		int res[][] = new int[arr.length][arr.length];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					res[i][j] = res[i][j] + (arr[i][k] * arr2[k][j]);
				}
			}
		}

		// 00 00 	00 01 
		// 01 10 	01 11
		// 02 20 	02 21
		printarray(res);

	}


}