import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		FileReader fileInput = new FileReader("input.txt");
		BufferedReader bufferedReader = new BufferedReader(fileInput);

		Scanner sc = new Scanner(bufferedReader);

		System.out.println(sc.next());

		// untuk membaca kata, dengan pemisah/delimeter, dalam kasus ini spasi
		System.out.println(sc.next());
		System.out.println(sc.next());


		// mengecek apakah ada kata selanjutnya atau tidak (false/true)
		System.out.println(sc.hasNext());

		// menggunakan delimeter tertentu
		FileReader in = new FileReader("input2.txt");
		bufferedReader = new BufferedReader(in);
		bufferedReader.mark(200);

		sc = new Scanner(bufferedReader);

		sc.useDelimiter(",");

		// dengan while
		while(sc.hasNext()) {
			System.out.print(sc.next() + " ");
		}

		System.out.println();

		// menggunakan string tokenizer
		bufferedReader.reset();
		String data = bufferedReader.readLine();
		System.out.println(data);

		// baris 1
		StringTokenizer stringToken = new StringTokenizer(data,",");
		while(stringToken.hasMoreTokens()) {
			System.out.print(stringToken.nextToken() + " ");
		}

		data = bufferedReader.readLine();
		System.out.println("\n"+data);
		stringToken = new StringTokenizer(data,",");
		while(stringToken.hasMoreTokens()) {
			System.out.print(stringToken.nextToken() + " ");
		}
		fileInput.close();
		bufferedReader.close();
	}
}