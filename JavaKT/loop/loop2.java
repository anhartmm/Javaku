import java.util.*;

public class Loop2 {
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0 ; j < 5; j++) {
				System.out.print(" * ");
			}
			System.out.println();
		}

		System.out.println();

		for(int i = 0; i < 5; i++) {
			for(int j = 0 ; j < 5; j++) {
				System.out.print(" * ");
				if(i == j) {
					break;
				}
			}
			System.out.println();
		}

		for(int i = 0; i < 5; i++) {
			for(int j = 4 ; j >= 0; j--) {
				System.out.print(" * ");
				if(j == i) {
					break;
				}
			}
			System.out.println();
		}

		int s = 0;
		for(int i = 5; i >= 0; i--) {
			if(i != 5) {
				for(int j = 0; j < s; j++) {
					System.out.print("  ");
				}
				for(int k = 0; k <= i; k++) {
					System.out.print("* ");
				}
			}
			System.out.println();
			s++;
		}

		System.out.println();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9 ; j++) {
				System.out.print("* ");
				if(i == j) break;
				else if(i+j == 8) break;
			}
			System.out.println();
		}

		System.out.println();

		for (int i = 0; i < 8; i++) {
			for(int j = 9-i; j > 0; j--) {
				System.out.print(" ");
			}
			for(int k = 0; k <= i; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		// System.out.println();

		for(int i = 0; i < 9; i++) {
			for(int k = i; k >= 0; k--) {
				System.out.print(" ");
			}
			for(int j = 9-i; j > 0; j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}