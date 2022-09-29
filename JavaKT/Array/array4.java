import java.util.Arrays;

public class Array4 {
	public static void main(String[] args) {
		int arrAngka[] = {1,2,3,4,5};

		// merubah array menjadi string
		System.out.print("\nMerubah array menjadi String: ");
		printArr(arrAngka);
		System.out.printf("address: %s\n\n",arrAngka);

		// mengcopy array 
		System.out.print("Mencopy array dengan loop: ");
		int arrAngka2[] = new int[5];
		
		// Mencopy dengan loop
		for(int i = 0; i < 5; i++) {
			arrAngka2[i] = arrAngka[i];
		}
		printArr(arrAngka2);
		System.out.printf("address: %s\n\n",arrAngka2);
		
		// Mencopy dengan copyof
		int arrAngka3[] = Arrays.copyOf(arrAngka,5);
		System.out.print("Mencopy array dengan Arrays.copyOf: ");
		printArr(arrAngka3);
		System.out.printf("address: %s\n\n",arrAngka3);
		
		// Mencopy dengan copyOfRange()
		int arrAngka4[] = Arrays.copyOfRange(arrAngka,0,5); 
		// Arrays.copyOfRange(nama,index awal,index akhir)
		System.out.print("Mencopy array dengan Arrays.copyOfRange: ");
		printArr(arrAngka4);
		System.out.printf("address: %s\n\n",arrAngka4);
		
		// Mencopy dengan mengalokasikan address yang sama
		System.out.print("Mencopy dengan address yang sama: ");
		int arrAngka5[] = new int[5];
		arrAngka5 = arrAngka;
		printArr(arrAngka5);
		System.out.printf("address: %s\n\n",arrAngka5);

		// fill array, membuat array isinya sama semua
		int arrAngka6[] = new int[5];
		System.out.print("Fill array: \n");
		printArr(arrAngka6);
		System.out.println(arrAngka6);
		Arrays.fill(arrAngka6,3); 
		printArr(arrAngka6);
		System.out.printf("%s\n",arrAngka6);
		int arrAngka7[] = {1, 2, 3, 2, 5};
		Arrays.fill(arrAngka7,4);
		printArr(arrAngka7);
		System.out.printf("%s\n\n",arrAngka7);

		// Komparasi array
		System.out.println("Komparasi array");
		printArr(arrAngka6);
		printArr(arrAngka7);
		System.out.println(Arrays.equals(arrAngka7,arrAngka6));
		System.out.println(Arrays.compare(arrAngka6,arrAngka3));
		// 1 = lebih besar, -1 = kurang, 0 = sama

		// ngecek mana index yang berbeda
		System.out.println(Arrays.mismatch(arrAngka7,arrAngka));

		// Sort Array
		int arr2[] = {5,4,3,2,1};
		int awe[] = {1,2,3,4,5};
		printArr(arr2);
		Arrays.sort(arr2);
		printArr(arr2);
		arraySort(arr2);
		printArr(arr2);
		arraySort2(awe);
		System.out.println();

		// Search array
		int arr[] = {11,12,13,14,15};
		int cari = 13;
		System.out.println(Arrays.toString(arr));
		System.out.printf("(linear search) angka berada di index ke-%d",cariArray(arr,cari));
		System.out.printf("\n(binary search) angka berada di index ke-%d",binarysearch(cari,arr,5));
		System.out.printf("\n(Arrays.binarySearch) angka berada di index ke-%d",Arrays.binarySearch(arr,cari));
	
		// tambah
		tambahArray(arr2,arr);

		// menggabungkan dua buah array


	}

	private static void printArr(int arr[]) {
		System.out.println(Arrays.toString(arr));
	}

	private static int cariArray(int arr[], int cari) {
		for(int i = 0; i < 5; i++) {
			if(cari == arr[i]) return i;
		}
		return -1;
	}

	private static int binarysearch(int cari, int arr[], int n) {
		int kiri = 0;
		int kanan = n;
		while(kiri <= kanan) {
			int mid = (kiri+kanan) / 2;
			if(cari < arr[mid]) {
				kanan = mid - 1;
			}else if(cari > arr[mid]) {
				kiri = mid + 1;
			}else {
				return mid;
			}
		}
		return -1;
	}

	private static void arraySort(int arr[]) {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4-i; j++) {
				if(arr[j] < arr[j+1]) {
					int swap = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = swap;
				}
			}
		}
	}

	private static void arraySort2(int arr[]) {
		int buffer;
		for(int i = 0; i < arr.length/2; i++) {
			buffer = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = buffer;
		}
		printArr(arr);
	}

	private static void tambahArray(int arr1[], int arr2[]) {
		int res[] = new int[arr1.length];
		for(int i = 0; i < 5; i++) {
			res[i] = arr1[i] + arr2[i];
		}
		System.out.println();
		printArr(res);
	}

}