import java.util.*;

public class Rekursif2 {
	public static void main(String[] args) {
		System.out.print(fibonacci(5));
	}
	
	private static int fibonacci(int n) {
		if(n == 1 || n == 0) {
			return 1;
		}else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}

}
