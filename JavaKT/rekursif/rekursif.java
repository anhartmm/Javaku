import java.util.*;

public class Rekursif {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(faktorial(n)); 
		System.out.print("angka: ");
		int x = sc.nextInt();
		System.out.print("pangkat: ");
		int y = sc.nextInt();
		pangkat(x,y);
	}

	private static int faktorial(int n ) {
		if(n == 1) return 1;
		else return n * faktorial(n-1);
	}

	private static void pangkat(int x, int y) {
		int hasil = x;
		for(int i = 1; i < y; i++) {
			hasil = hasil * x;
		}
		System.out.printf("hasil: %d",hasil);
	}
}

