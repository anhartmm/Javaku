import java.util.*;

public class Latihan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Program sederhana untuk menebak sebuah angka
		int nilaiBenar = 6;
		int nilaiTebakan;
		Boolean statusTebakan;
		System.out.print("Masukan nilai tebakan anda: ");
		nilaiTebakan = sc.nextInt();
		System.out.println("Nilai tebakan anda adalah " + nilaiTebakan);

		// operasi logika
		statusTebakan = (nilaiTebakan == nilaiBenar);
		System.out.println(statusTebakan);
		System.out.println();

		while(true) {
			System.out.print("Tebak nilai: ");
			nilaiTebakan = sc.nextInt();
			if(nilaiTebakan == nilaiBenar) {
				System.out.println("Selamat tebakan anda benar !");
				break;
			}else {
				System.out.println("Tebakan anda salah, silahkan coba lagi.");
			}
		}

		System.out.print("Masukan nilai dalam interval [3,9]");
		nilaiTebakan = sc.nextInt();
		System.out.println((nilaiTebakan >= 3) && (nilaiTebakan <= 9));
	}
}