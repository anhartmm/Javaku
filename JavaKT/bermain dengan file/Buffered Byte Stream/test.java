import java.io.*;

public class Test {
	public static void main(String[] args) throws IOException {
		
		FileInputStream in = new FileInputStream("input.txt");
		BufferedInputStream bufIn = new BufferedInputStream(in);

		byte[] baca = bufIn.readAllBytes();
		String str = new String(baca);
		System.out.println(str);

	}
}