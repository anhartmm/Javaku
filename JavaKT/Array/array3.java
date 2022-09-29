import java.util.*;

public class Array3 {
	public static void main(String[] args) {
		int arr1[] = {1,2,3,4,5};
		int arr2[] = new int[5];
		arr2 = arr1;

		System.out.println(arr1);
		System.out.println(arr2);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));

		ubahArray(arr1);
		System.out.println();
		arr1[0] = 123;
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(arr1);
		System.out.println(arr2);
	}

	// pass by reference, contohnya pada argument ubahArray()
	// pass by reference -> tidak menambah alokasi memory baru

	// pass by value
	private static void passByValue(int pass) {}

	private static void ubahArray(int arr[]) {
		arr[3] = 125;
		for(int i : arr) {
			System.out.printf("%d ", i);
		}
	}

}