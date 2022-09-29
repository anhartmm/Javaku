import java.util.*;

public class Kalkulator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b;
		char operator;

		System.out.print("Angka pertama	: ");
		a = sc.nextInt();
		System.out.print("Angka kedua	: ");
		b = sc.nextInt();
		System.out.print("Jenis Operasi (+, -, x, /, %) : ");
		operator = sc.next().charAt(0);

		switch(operator) {
			case '+':
				System.out.printf("%d + %d = %d",a,b,a+b);
				break;
			case '-':
				System.out.printf("%d - %d = %d",a,b,a-b);
				break;
			case 'x':
				System.out.printf("%d x %d = %d",a,b,a*b);
				break;
			case '/':
				System.out.printf("%d / %d = %d",a,b,a/b);
				break;
			case '%':
				System.out.printf("%d % %d = %d",a,b,a%b);
				break;
			default:
				System.out.println("Error");
		}

		do {
			System.out.println("\nawe");
		}while(true);

	}
}
