package com.crudProject;

import java.util.*;
import java.io.*;
import java.time.Year;

import com.crudProject.Operasi;

public class Utility {

	public static void menu() throws IOException {
			System.out.println("\n\tDatabase Perpustakaan\n");
			System.out.println("	1. Lihat Seluruh Buku");
			System.out.println("	2. Cari Data Buku");
			System.out.println("	3. Tambah Data Buku");
			System.out.println("	4. Ubah Data Buku");
			System.out.println("	5. Hapus Data Buku");
			System.out.print("\nPilihan Anda: ");	
			Scanner terminalInput = new Scanner(System.in);
			String pilihanUser = terminalInput.next();

			switch(pilihanUser) {
				case "1":
					System.out.println("\n=================");
					System.out.println("LIST SELURUH BUKU");
					System.out.println("=================");
					// tampilkan data
					Operasi.dataDisplay();
					break;
				case "2":
					System.out.println("\n=================");
					System.out.println("CARI DATA BUKU");
					System.out.println("=================");
					// cari data
					Operasi.findData();
					break;
				case "3":
					System.out.println("\n=================");
					System.out.println("TAMBAH DATA BUKU");
					System.out.println("=================");
					// tambah data
					Operasi.addData();
					break;
				case "4":
					System.out.println("\n=================");
					System.out.println("UBAH DATA BUKU");
					System.out.println("=================");
					// ubah data
					Operasi.updateData();
					break;
				case "5":
					System.out.println("\n=================");
					System.out.println("HAPUS DATA BUKU");
					System.out.println("=================");
					// hapus data
					Operasi.deleteData();
					break;
				default:
					System.err.println("\nInput Anda Tidak Valid\nPilihan (1-5)");
			}
	}

	public static void cariBukuDiDatabase(String[] keywords) throws IOException {
		FileReader fileInput = new FileReader("database.txt");
		BufferedReader bufferedInput = new BufferedReader(fileInput);

		String data = bufferedInput.readLine();
		boolean isExist = true;
		int noData = 1;
		boolean sudah = false;
		boolean notExist = true;

		while(data != null) {
			
			// cek keywords di dalam baris
			isExist = true;
			for(String kw : keywords) {
				isExist = isExist && data.toLowerCase().contains(kw.toLowerCase());
			}

			if(isExist) {
				notExist = false;
				if(sudah) { 
					StringTokenizer stringToken = new StringTokenizer(data,",");
					stringToken.nextToken();
					System.out.printf("|%2d",noData);
					System.out.printf("  | %6.5s",stringToken.nextToken());
					System.out.printf("  \t| %-25s",stringToken.nextToken());
					System.out.printf("  \t\t| %-25s",stringToken.nextToken());
					System.out.printf("  \t\t| %-35s  |",stringToken.nextToken());
					noData++;
					System.out.println();
				} else {
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("| No |	Tahun 	|		Penulis			|		Penerbit		|	      Judul Buku 	       |");
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
					StringTokenizer stringToken = new StringTokenizer(data,",");
					stringToken.nextToken();
					System.out.printf("|%2d",noData);
					System.out.printf("  | %6.5s",stringToken.nextToken());
					System.out.printf("  \t| %-25s",stringToken.nextToken());
					System.out.printf("  \t\t| %-25s",stringToken.nextToken());
					System.out.printf("  \t\t| %-35s  |",stringToken.nextToken());
					noData++;
					System.out.println();
					sudah = true;
				}
			}

			data = bufferedInput.readLine();
			
		}
		if(notExist) {
			System.err.println("\nData yang anda cari tidak ditemukan\nPastikan kata kunci yang dimasukan sesuai");
		}
		fileInput.close();
		bufferedInput.close();
	}

	public static long ambilEntryPerTahun(String penulis, String tahun) throws IOException {
		FileReader fileInput = 	new FileReader("database.txt");
		BufferedReader bufferedInput = new BufferedReader(fileInput);
		long entry = 0;
		String data = bufferedInput.readLine();
		Scanner sc;
		String primaryKey;

		while(data != null) {
			sc = new Scanner(data);
			sc.useDelimiter(","); // mengambil primary key, dari koma paling depan
			primaryKey = sc.next(); // mengambil bagian depannya aja, alias si primary key
			sc = new Scanner(primaryKey);
			sc.useDelimiter("_");
			penulis = penulis.replaceAll("\\s+","");

			if(penulis.equalsIgnoreCase(sc.next()) && tahun.equalsIgnoreCase(sc.next())) {
				entry = sc.nextInt();
			}
			data = bufferedInput.readLine();
		}

		fileInput.close();
		bufferedInput.close();
		return entry;
	}

	public static boolean antiDoubleEntry(String[] keywords) throws IOException {
		FileReader fileInput = new FileReader("database.txt");
		BufferedReader bufferedInput = new BufferedReader(fileInput);

		String data = bufferedInput.readLine();
		boolean isExist = true;

		while(data != null) {
			isExist = true;
			for(String kw : keywords) {
				isExist = isExist && data.toLowerCase().contains(kw.toLowerCase());
			}
			if(isExist) break;
			data = bufferedInput.readLine();
		}

		fileInput.close();
		bufferedInput.close();
		return isExist;
	}

	public static void clearScreen() {
		try {
			if(System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033\143");
			} 
		} catch (Exception e) {
				System.err.println("Tidak bisa clear screen.\n");
		}
	}

	public static boolean isContinue(String message, boolean ok) {
			Scanner sc = new Scanner(System.in);
			System.out.printf("\n%s (y/n)? ",message);
			String pilihanUser = sc.next();
			if(pilihanUser.equalsIgnoreCase("y")) { 
				if(ok)clearScreen(); 
				return true; 
			} else if(pilihanUser.equalsIgnoreCase("n")) { 
				return false; 
			} else { 
				System.err.println("Input Anda Tidak Valid\nPilih (y/n)"); 
				return isContinue(message,false); 
			}
	}

}