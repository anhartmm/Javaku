package programku;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// FileInputStream fileInput = null;
		// System.out.println(fileInput);
		
		// fileInput = new FileInputStream("input.txt");
		// System.out.println("file input bernilai : " + fileInput);
		
		// fileInput.close();
		// System.out.println("file input bernilai : " + fileInput);

		// fileInput = new FileInputStream("input2.txt");
		// System.out.println("file input bernilai : " + fileInput);

		FileInputStream fileInput = null;
		FileOutputStream fileOutput = null;

		
		// Membuka file
		fileInput = new FileInputStream("input.txt");

		// Membaca file
		int data = fileInput.read();
		while(data != -1) {
			System.out.print((char)data);
			data = fileInput.read();
		}

		// Menutup file
		fileInput.close();
	
		// Salah satu contoh skenario program pembukaan file 
		// bisa otomatis membuat file jika tidak ada
		try {
			// membuka file
			fileInput = new FileInputStream("input2.txt");
			fileOutput = new FileOutputStream("output2.txt");
			
			// // membaca file
			// int buffer = fileInput.read();

			// // Menulis file
			// fileOutput.write(buffer);

			int buffer = fileInput.read();

			while(buffer != -1) { // menulis dari input2.txt ke output2.txt
				fileOutput.write(buffer);
				buffer = fileInput.read();
			}

		} finally {
			if(fileInput != null) fileInput.close();
			if(fileOutput != null) fileOutput.close();
		}

		// try with resources

		try(FileInputStream in = new FileInputStream("input.txt")) {
			System.out.println();
			int bacaData = in.read();
			while(bacaData != -1) {
				System.out.print((char)bacaData);
				bacaData = in.read();
			}
			System.out.println();
		} // otomatis close

		// gabungin
		try(
			FileInputStream in = new FileInputStream("input.txt");
			FileOutputStream out = new FileOutputStream("output.txt");
			) {
			System.out.println();
			int bacaData = in.read();
			while(bacaData != -1) {
				System.out.print((char)bacaData);
				out.write(bacaData);
				bacaData = in.read();
			}
			System.out.println();
		} 
	}
}