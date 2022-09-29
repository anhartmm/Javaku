import java.util.*;

public class StringMain {
	public static void main(String[] args) {
		String kata = "Halo";
		System.out.println(kata);

		System.out.println("\n--Sebelum--");
		printAddress(kata); System.out.println();

		char c[] = {'h','a','l','o'};
		System.out.println(c);
		System.out.println(Arrays.toString(c));

		// Mengakses komponen dari string
		System.out.printf("komponen pertama dari %s adalah %c\n",kata,kata.charAt(0));
	
		// Merubah komponen
		c[0] = 'C'; 
		// kata.charAt(0) = 'C'; // Merubah komponen dari String itu tidak bisa
		// Karena string itu immutable

		System.out.println(c);
		
		// kita bisa merubah komponen secara tidak langsung
		// substring
		System.out.println(kata.substring(1,4));
		kata = "C" + kata.substring(1,4);
		System.out.println(kata.substring(0,4));

		System.out.println();
		byte a = 12;
		String a_bits = String.format("%8s",Integer.toBinaryString(a)).replace(' ', '0'); 
		System.out.println(a_bits);
		String str = "12345678910111213141516";
		System.out.println(str.substring(8));

		System.out.println("\n--Setelah--");
		printAddress(kata);

		System.out.println("\n\n");
		int aawe = 10;
		int id = System.identityHashCode(aawe);
		String hex = Integer.toHexString(id);
		System.out.printf("id=%d, hex=%s",id,hex);
		aawe = 11;
		int ewa = aawe;
		ewa = 123;
		System.out.println();
		id = System.identityHashCode(aawe);
		hex = Integer.toHexString(id);
		System.out.printf("id=%d, hex=%s",id,hex);
		System.out.println();
		id = System.identityHashCode(ewa);
		hex = Integer.toHexString(id);
		System.out.printf("id=%d, hex=%s",id,hex);
		System.out.println("\n\n");
		
		// memory dari string (String pool / satu slot memory untuk string)
		// di java String itu reusable
		String str_1 = "test";
		String str_2 = "test";
		printAddress(str_1);
		printAddress(str_2);
		str_2 = "hello";
		printAddress(str_2);

		// Kesimpulan
		// 1. String di java itu immutable
		// 2. String yang berada di String Pool itu akan reusable, jadi memorynya lebih efisien
		// 3. Membuat string dengan method baru maka dia akan dialokasikan di memory lain bukan di String Pool
		
		String ayam = new  String("hello"); // heap memory seperti array
		printAddress(ayam);
		String hello = "hello";
		printAddress(hello);

	}

	private static void printAddress(String data) {
		int addressID = System.identityHashCode(data);
		String addressHEX = Integer.toHexString(addressID);
		System.out.printf("String: %s \t|| ",data);
		System.out.printf("Address: id=%d, hex=%s\n",addressID,addressHEX);
	}

}