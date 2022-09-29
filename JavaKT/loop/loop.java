import java.util.*;

public class Loop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nilaiAwal = sc.nextInt();
		int nilaiAkhir = sc.nextInt();
		int total = 0;
		for(int i = nilaiAwal; i <= nilaiAkhir; i++) {
			if(i == nilaiAkhir) {
				total += i;
				System.out.printf("%d = ",i);
				break;
			}
			System.out.printf("%d + ",i);			
			total += i;
		}
		System.out.print(total);
		
		// Deret Fibonacci
		System.out.println();
		int num = sc.nextInt();
		int a = 0;
		int b = 1;
		int res = 0;
		for(int i = 0; i < num; i++) {
			res = a + b;
			a = b;
			b = res;
			System.out.printf("%d ",a);
		} 
		System.out.println(res);
	}
}
