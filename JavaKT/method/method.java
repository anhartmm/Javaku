import java.util.*;

public class Method {
	public static void main(String[] args) {
		for(int i = 0; i <= 5; i++) {
			System.out.printf("%d ",fungsi(i));
		}
		Scanner sc = new Scanner(System.in);
		String input  = sc.nextLine();
		halo(input);
	}
	private static int fungsi(int n) {
		if(n <= 1) return 1;
		else return fungsi(n-1) + fungsi(n-2);
	}

	private static void halo(String input) {
		System.out.println(input);
	}

}


	