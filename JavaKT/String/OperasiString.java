import java.util.Scanner;
import java.lang.String;
import java.util.Arrays;

// Selengkapnya cari di google String docs

public class OperasiString {
	public static void main(String[] args) {
		String str = "Saya suka makan pisang";
		print(str);
		System.out.println();

		// mengambil komponen string
		System.out.println(str.charAt(5));
		System.out.println();

		//substring
		System.out.println();
		System.out.println("// Substring // ");
		String substr = str.substring(10,15);
		print(substr);
		System.out.println();

		// menggabungkan string (concatenation / concat)
		// concat itu membuat memori baru 
		System.out.println("// concat // ");
		String str_2 = substr + " bakwan";
		print(str_2);
		substr = substr + " bakwan";
		print(substr);
		System.out.println();

		// concat dengan non-string
		System.out.println("// concat non-string // ");
		int jumlah = 20;
		String str_3 = str_2 + " " + jumlah; // casting int to string automatically 
		print(str_3);
		System.out.println();

		// lowercase & uppercase
		System.out.println("// toUpperCase & toLowerCase // ");
		print(str);
		str = str.toUpperCase();
		print(str);
		System.out.println(str.substring(0,15) + str.substring(15,22).toUpperCase());
		str = str.toLowerCase();
		print(str);
		System.out.println();

		// Replace 
		System.out.println("// Replace // ");
		String str_4 = str.replace("pisang","mie ayam");
		print(str_4);
		System.out.println();
		// delete dengan replace()
		String ea = "Selamat pagi cikgu!";
		System.out.println(ea.replace("pagi","\b"));

		// equality, persamaan
		System.out.println("// Persamaan pada lokasi String Pool // ");
		// String kataInput = "test"; // ada di string pool
		String kataTest = "test"; // ada di string pool
		String kataInput = new String("test"); // // bukan string literal, tidak berada di Stringg Pool
		if(kataInput == kataTest) { // untuk string yang dicek adalah addressnya, bukan valuenya
			System.out.println("sama");
		}else {
			System.out.println("tidak sama");
		}
		System.out.println("Menggunakan equals()");
		System.out.println(kataInput.equals(kataTest));
		System.out.println();
		// method untuk mengecek string melalui valuenya bkn addressnya
		Scanner sc = new Scanner(System.in); // jika mengambil input dari user, maka bukan string literal, dan tidak berada di string pool, adanya di heap memory
		System.out.println("// Mengambil String dari user // ");
		System.out.print("Masukan String: ");
		kataInput = sc.nextLine(); // tidak di string pool
		System.out.print("input yang masukan: " + kataInput);

		System.out.println();
		if(kataInput.equals(kataTest)) { // equals() mengecek valuenya bukan addressnya
			System.out.println("sama");
		}else {
			System.out.println("tidak sama");
		}
		System.out.println();

		// Comparasi, membandingkan berdasarkan urutan alphabetic
		System.out.println("// Compare // ");
		String motor_1 = "royal enfield himalayan";
		String motor_2 = "kawasaki w175";
		System.out.println(motor_1.compareTo(motor_2)); // klmnopqr, jarak alphabeticnya
		System.out.println(motor_2.compareTo(motor_1)); 

		// obj_1.compareTo(obj_2); ---> jarak character obj_2 ke obj_1
		// kalau hasilnya mines artinya lebih besar
		// sedangkan positif artinya lebih kecil

		String gorengan1 = "bakwan";
		String gorengan2 = "bala-bala";

		System.out.println(gorengan1.compareTo(gorengan2)); 
		System.out.println(gorengan2.compareTo(gorengan1)); 

		String[] data = {"zeda","ani","ujang","budi","yeda","otong","jokowi","abe","beni","beno","abi"};
		urutLeksografis(data);


	}

	private static void print(String data) {
		int addressID = System.identityHashCode(data);
		String addressHEX = Integer.toHexString(addressID);
		System.out.printf("String: %s || ",data);
		System.out.printf("Address: id=%d, hex=%s\n",addressID,addressHEX);
	}

	private static void urutLeksografis(String[] data) {
		int buffer1;
		int buffer2; 
		for(int i = 0; i < data.length; i++) {
			for(int j = 0 ; j < (data.length - i - 1); j++) {
				buffer1 = data[j].compareTo(data[j+1]); // mengecek apakah character data[j+1] > atau < dari data[j]
				buffer2 = data[j+1].compareTo(data[j]); // mengecek apakah character data[j] > atau < dari data[j+1]
				if(buffer2 < buffer1) {
					String temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				} 
			}
		}
		System.out.print(Arrays.toString(data));
	}

}