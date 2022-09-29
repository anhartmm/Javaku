import java.util.*;

public class Array {
	public static void main(String[] args) {
		int[] arr = new int[5];
		// tipe data[] nama = new tipedata[jumlah index];
		Scanner sc = new Scanner(System.in);

		for(int a = 0; a < 5; a++) {
			arr[a] = sc.nextInt();
		}

		int i,j;
		for(i = 0; i < 4; i++) {
			for(j = 0; j < 4-i; j++) {
				if((arr[j] > arr[j+1])) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			System.out.printf("i = %d\t",i);
			for(int k = 0; k < 5; k++) {
				System.out.printf("%d ",arr[k]);
			}
			System.out.println();
		}

		System.out.printf("\n\n%s",Arrays.toString(arr));

		// for(int i = 0; i < 5; i++) {
		// 	System.out.printf("%d ",arr[i]);
		// }

	}
}