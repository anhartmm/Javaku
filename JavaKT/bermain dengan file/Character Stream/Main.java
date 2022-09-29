// import java.io.IOException;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.FileReader;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		// Membuka File

		// byte stream --> FileInputStream
		// Character stream --> FileReader

		FileInputStream byteFile = new FileInputStream("input.txt");
		FileReader charFile = new FileReader("input.txt");
		
		FileOutputStream outByte = new FileOutputStream("out.txt");
		FileWriter outFile = new FileWriter("out2.txt");


		// Membaca File
		//System.out.println(byteFile.read());
		//System.out.println(charFile.read());
		System.out.println();

		// byte file
		int buffer = byteFile.read();
		while(buffer != -1) {
			System.out.print((char)buffer);
			outByte.write(buffer);
			buffer = byteFile.read();
		}

		System.out.println();

		// char file
		buffer = charFile.read();
		while(buffer != -1) {
			System.out.print((char)buffer);
			outFile.write(buffer);
			buffer = charFile.read();
		}

		// Menutup File
		byteFile.close();
		charFile.close();
		outByte.close();
		outFile.close();


	}
}