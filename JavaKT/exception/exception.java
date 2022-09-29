import java.util.*;
import java.io.FileInputStream;

public class ExceptionMain {
	public static void main(String[] args) {
		int arr[] = {0,1,22,3};

		Scanner sc = new Scanner(System.in);
		System.out.print("Nilai array ke: ");
		int index = sc.nextInt();

		// exception handling (try, catch, finally)

		// ngecek dimana exceptionnya berada
		System.out.println(" \n// Handling Array out of bounds //");
		try { // "coba lakukan ini"
			System.out.printf("Index ke %1$d adalah %2$d ",index,arr[index]);		
		} catch(Exception e) { // bisa pake ArrayIndexOutOfBoundsException e) { // kalau ada exception ditangkap
			System.err.println(e);
		}

		// runtime error, jika file tidak ada
		FileInputStream fileInput = null;

		System.out.println("\n // Handling IO not found // ");
		try {
			fileInput = new FileInputStream("input.txt");
		} catch(Exception e) { // bisa pake IOException
			System.err.println(e);
		}
	
		// menggabungkan dua exception
		System.out.println("\n // Menggabungkan dua buah exception //");
		try {
			System.out.printf("Index ke %1$d adalah %2$d \n",index,arr[index]);
			fileInput = new FileInputStream("input.txt");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.println(e);
		} catch(Exception e) {
			System.err.println(e);

		}

		// finally
		System.out.println(" \n// Menambahkan Finally //");
		try {
			System.out.printf("Index ke %1$d adalah %2$d \n",index,arr[index]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.println(e);
		}finally {
			System.out.println("Finally"); // biasanya digunakan untuk menclose file
		} 

		System.out.println("\n\nAkhir dari Program");
	}	
}