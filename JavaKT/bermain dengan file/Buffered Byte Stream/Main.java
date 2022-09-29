import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		// Membaca dari file
		FileInputStream byteInput = new FileInputStream("input.txt");
		
		System.out.println(byteInput.available());

		// menghitung waktu pembacaan
		long waktuStart, waktuFinish;
		waktuStart = System.nanoTime();
		System.out.println(byteInput.readAllBytes());
		waktuFinish = System.nanoTime();
		System.out.println("waktu: " + (waktuFinish - waktuStart));
		byteInput.close(); // tidak bisa direuse, harus bikin variable baru lagi

		// Membaca dari memory
		FileInputStream byteInput2 = new FileInputStream("input.txt");
		BufferedInputStream bufferedInput = new BufferedInputStream(byteInput2);

		bufferedInput.mark(200); // maksimum 200, bisa direset atau reuse
		// Menghitung waktu pembacaan
		waktuStart = System.nanoTime();
		System.out.println(bufferedInput.readAllBytes());
		waktuFinish = System.nanoTime();
		System.out.println("waktu: " + (waktuFinish - waktuStart));

		// baca ulang
		bufferedInput.reset();
		byte[] data = bufferedInput.readAllBytes();
		System.out.println(Arrays.toString(data));
		String dataString = new String(data);
		System.out.println(dataString);

		// Menulis dengan bufferedOuput

		FileOutputStream byteOutput = new FileOutputStream("output.txt");
		BufferedOutputStream bufferedOuput = new BufferedOutputStream(byteOutput);

		// write data berupa byte
		bufferedOuput.write(data,0,data.length);
		bufferedOuput.flush();
		bufferedOuput.close();
		bufferedInput.close();
		byteInput2.close();
		byteOutput.close();


	}
}