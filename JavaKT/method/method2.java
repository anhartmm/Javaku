import java.util.*;

public class Method2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("x: ");
		int x = sc.nextInt();
		System.out.print("y: ");
		int y = sc.nextInt();
		printPersegi(x,y);
		printSegitiga(x);
		printSiku(x);
	}

	private static void printPersegi(int panjang, int lebar) {
		System.out.println();
		for(int i = 0; i < lebar; i++) {
			for(int j = 0; j < panjang; j++) {
				System.out.print(" * ");
			}
			System.out.println();
		}
	}

	private static void printSegitiga(int x) {
		System.out.println();
		for(int i = 0; i < x; i++) {
			for(int j = x-i; j > 0; j--) {
				System.out.print(" ");
			}
			int ascii = 65;
			for(int k = 0; k <= i; k++) {
				System.out.printf("%c ",(char)ascii);
				ascii++;
			}
			System.out.println();
		}
	}

	private static void printSiku(int x) {
		System.out.println();
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < x; j++) {
				System.out.printf(" %d ",j+1);
				if(j == i) break;
			}
			System.out.println();
		}
	}
}