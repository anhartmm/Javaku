package com.crudProject;

import java.util.*;
import java.io.*;
import java.time.Year;

import com.crudProject.Utility;

public class Operasi {

	public static void dataDisplay() throws IOException {
		FileReader fileInput;
		BufferedReader bufferedInput;

		try { // ngecek apakah filenya ada
			fileInput = new FileReader("database.txt");
			bufferedInput = new BufferedReader(fileInput);
		} catch(IOException e) {
			System.err.println("Database masih kosong");
			System.err.println("Silahkan tambah data terlebih dahulu");

			FileWriter a = new FileWriter("database.txt");
			BufferedWriter b = new BufferedWriter(a);
			b.write("0,0,kosong,kosong,kosong");
			b.newLine();
			b.flush();
			a.close();
			b.close();
			return;
		}

		int noData = 1;
		String data = bufferedInput.readLine();
		StringTokenizer stringToken = new StringTokenizer(data,",");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("| No |	Tahun 	|		Penulis			|		Penerbit		|	      Judul Buku 	       |");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
		while(data != null) {
			stringToken = new StringTokenizer(data,",");
			stringToken.nextToken();
			System.out.printf("|%2d",noData);
			System.out.printf(" | %6.5s",stringToken.nextToken());
			System.out.printf("  \t| %-25s",stringToken.nextToken());
			System.out.printf("  \t\t| %-25s",stringToken.nextToken());
			System.out.printf("  \t\t| %-35s  |",stringToken.nextToken());
			data = bufferedInput.readLine();
			System.out.println();
			noData++;
		}
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

		fileInput.close();
		bufferedInput.close();

	}

	public static void findData() throws IOException {
		// Membaca database data ada atau tidak
		try {
			File file = new File("database.txt");
		} catch(Exception e) {
			System.err.println("Database tidak ditemukan");
			System.err.println("Silahkan tambah data terlebih dahulu!");
			addData();
		}


		// kita ambil keyword dari user
		Scanner sc = new Scanner(System.in);
		System.out.print("Masukan kata kunci: ");
		String cari = sc.nextLine();		
		String[] keywords = cari.split("\\s+");

		// kita cek keyword di database
		Utility.cariBukuDiDatabase(keywords);

	}

	public static void addData() throws IOException {
		FileWriter fileOutput = new FileWriter("database.txt",true /* append, alias menambah dibawahnya */);
		BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);
		
		Scanner sc = new Scanner(System.in);
		String penulis, judul, penerbit, tahun;
		
		System.out.print("Masukan nama penulis : ");
		penulis = sc.nextLine();
		System.out.print("Masukan judul buku   : ");
		judul = sc.nextLine();
		System.out.print("Masukan nama penerbit: ");
		penerbit = sc.nextLine();
		System.out.print("Masukan tahun terbit : ");
		tahun = sc.nextLine();

		// validasi tahun
		boolean tahunValid = false;
		while(!tahunValid) {
			try {
				Year.parse(tahun);
				tahunValid = true;
			} catch(Exception e) {
				System.err.print("\nTahun yang anda masukan tidak valid, format=(YYYY) \nSilahkan coba lagi: ");
				tahun = sc.nextLine();
			}
		}

		// cek buku di database 
		String[] keywords = {tahun+","+penulis+","+penerbit+","+judul};

		if(Utility.antiDoubleEntry(keywords)) {
			System.out.println("\nData sudah tersedia di database");
			Utility.cariBukuDiDatabase(keywords);
		} else {
			// fiersabesari_2012_1,2012,fiersa besari,media kita,jejak langkah
			long nomorEntry = Utility.ambilEntryPerTahun(penulis,tahun) + 1;
			String penulisTanpaSpasi = penulis.replaceAll("\\s+","");
			String primaryKey = penulisTanpaSpasi+"_"+tahun+"_"+nomorEntry;
			System.out.println("\nData yang anda masukan adalah ");
			System.out.println("----------------------------------");
			System.out.println("primary key : " + primaryKey);
			System.out.println("tahun terbit: " + tahun);
			System.out.println("penulis     : " + penulis);
			System.out.println("judul       : " + judul);
			System.out.println("penerbit    : " + penerbit);

			boolean ok = true;
			if((tahun+penulis+judul+penerbit).contains(",")) {
				System.err.println("\nInvalid\nData gagal dimasukan\nMohon jangan input data yang mengandung tanda baca koma (,)");
				ok = false;
			}

			if(ok) {
				boolean isTambah = Utility.isContinue("Apakah anda ingin menambah data tersebut",false);
				if(isTambah) {
					bufferedOutput.write(primaryKey + "," + tahun + "," + penulis + "," + penerbit + "," + judul);
					bufferedOutput.newLine();
					bufferedOutput.flush();
				}
			}
			dataDisplay();
		}

		bufferedOutput.close(); // untuk writer harus di close, reader autoclose
		fileOutput.close();

	}

	public static void updateData() throws IOException {

		try {
			File file = new File("database.txt");
		} catch(Exception e) {
			System.err.println("Database tidak ditemukan");
			System.err.println("Silahkan tambah data terlebih dahulu!");
			FileWriter a = new FileWriter("database.txt");
			BufferedWriter b = new BufferedWriter(a);
			b.write("0,0,kosong,kosong,kosong");
			b.newLine();
			b.flush();
			a.close();
			b.close();
			return;
		}

		// kita ambil database original
		File database = new File("database.txt");
		FileReader fileInput = new FileReader(database);
		BufferedReader bufferedInput = new BufferedReader(fileInput);

		// kita buat database sementara
		File tempDB = new File("tempDB.txt");
		FileWriter fileOutput = new FileWriter(tempDB);
		BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);


		// tampilkan data
		System.out.println("List Buku");
		dataDisplay();

		// ambil user input
		Scanner sc = new Scanner(System.in);
		System.out.print("\nMasukan nomor data yang ingin diupdate: ");
		int updateNum = sc.nextInt();

		// tampilkan data yang ingin diupdate
		String data = bufferedInput.readLine();
		int entryCounts = 0;
		boolean isFound = false;

		while(data != null) {
			entryCounts++;
			StringTokenizer st = new StringTokenizer(data,",");
			if(entryCounts == updateNum) {
				System.out.println("\nData yang ingin anda update adalah: ");
				System.out.println("--------------------------------------");
				System.out.println("Referensi	: " + st.nextToken());
				System.out.println("Tahun		: " + st.nextToken());
				System.out.println("Penulis		: " + st.nextToken());
				System.out.println("Penerbit	: " + st.nextToken());
				System.out.println("Judul		: " + st.nextToken());
				isFound = true;
				// update data

				// mengambil input dari user
				String[] fieldsData = {"tahun","penulis","penerbit","judul"};
				String[] tempData = new String[4];

				// refresh token
				st = new StringTokenizer(data,",");
				String originalData = st.nextToken();
				
				for (int i = 0; i < 4; i++) {
					boolean isUpdate = Utility.isContinue("Apakah ingin merubah " + fieldsData[i],false);
					originalData = st.nextToken();

					if(isUpdate) {
						// user input
						sc = new Scanner(System.in);
						System.out.print("Masukan data " + fieldsData[i] + " yang baru: ");
						tempData[i] = sc.nextLine();
					} else {
						tempData[i] = originalData;
					}

				}

				// tampilkan data baru ke layar
				st = new StringTokenizer(data,",");
				System.out.println("\nData baru anda adalah: ");
				System.out.println("--------------------------------------");
				System.out.println("Tahun		: " + tempData[0]);
				System.out.println("Penulis		: " + tempData[1]);
				System.out.println("Penerbit	: " + tempData[2]);
				System.out.println("Judul		: " + tempData[3]);

				boolean isUpdate = Utility.isContinue("Apakah anda yakin ingin mengupdate data tersebut",false);

				if(isUpdate) {
					boolean isExist = Utility.antiDoubleEntry(tempData);

					if(isExist) {
						System.err.println("\nData sudah ada di database, proses update dibatalkan");
						Utility.cariBukuDiDatabase(tempData);
					} else {
						// format data baru ke dalam database

						// kita bikin primary key
						long nomorEntry = Utility.ambilEntryPerTahun(tempData[1],tempData[0]) + 1;
						String penulisTanpaSpasi = tempData[1].replaceAll("\\s+","");
						String primaryKey = penulisTanpaSpasi+"_"+tempData[0]+"_"+nomorEntry; 

						// tulis data ke database
						bufferedOutput.write(primaryKey + "," + tempData[0] + "," + tempData[1] + "," + tempData[2] + "," + tempData[3]);
					
						System.out.println("Data berhasil diupdate");
					}
				} else {
					// copy data
					bufferedOutput.write(data);
				}

			} else {
				// copy data
				bufferedOutput.write(data);
			}
			bufferedOutput.newLine();
			data = bufferedInput.readLine();
		}

		bufferedOutput.flush();

		bufferedOutput.close();
		bufferedInput.close();
		fileOutput.close();
		fileInput.close();

		database.delete();
		tempDB.renameTo(database);

		if(!isFound) System.out.println("Nomor yang anda masukan invalid");
		else dataDisplay();

	}

	public static void deleteData() throws IOException {

		try {
			File file = new File("database.txt");
		} catch(Exception e) {
			System.err.println("Database tidak ditemukan");
			System.err.println("Silahkan tambah data terlebih dahulu!");
			FileWriter a = new FileWriter("database.txt");
			BufferedWriter b = new BufferedWriter(a);
			b.write("0,0,kosong,kosong,kosong");
			b.newLine();
			b.flush();
			a.close();
			b.close();
			return;
		}

		// kita ambil database original
		File database = new File("database.txt"); // membaca saja dan bisa direname
		FileReader fileInput = new FileReader(database);
		BufferedReader bufferedInput = new BufferedReader(fileInput);

		// kita buat database sementara
		File tempDB = new File("tempDB.txt");
		FileWriter fileOutput = new FileWriter(tempDB);
		BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);


		// tampilkan data
		System.out.println("List Buku\n");
		dataDisplay();

		// kita ambil user input untuk mendelete data
		Scanner sc = new Scanner(System.in);
		System.out.print("\nMasukan nomor data yang akan dihapus: ");
		int deleteNum = sc.nextInt();

		// looping untuk membaca tiap data baris dan skip data yang akan didelete
		boolean isFound = false;
		int entryCounts = 1;
		String data = bufferedInput.readLine();
		boolean isDelete = false;

		while(data != null) {
			isDelete = false;
			StringTokenizer st = new StringTokenizer(data,",");
			if(deleteNum == entryCounts){
				System.out.println("\nData yang ingin anda hapus adalah: ");
				System.out.println("-------------------------------------");
				System.out.println("Referensi	: " + st.nextToken());
				System.out.println("Tahun		: " + st.nextToken());
				System.out.println("Penulis		: " + st.nextToken());
				System.out.println("Penerbit	: " + st.nextToken());
				System.out.println("Judul		: " + st.nextToken());
				isDelete = Utility.isContinue("Apakah anda yakin menghapus data tersebut",false);
				isFound = true;
			}

			if(isDelete) {
				// skip pindahkan data dari orginal ke sementara
				System.out.println("Data berhasil dihapus");
			} else {
				// kita pindahkan data dari original ke sementara
				bufferedOutput.write(data);
				bufferedOutput.newLine();
			}

			data = bufferedInput.readLine();
			entryCounts++;
		}

		// menulis data ke file
		bufferedOutput.flush();

		fileInput.close();
		fileOutput.close();
		bufferedOutput.close();
		bufferedInput.close();

		// delete original file
		database.delete();

		// rename file sementara ke database.txt 
		tempDB.renameTo(database);

		if(!isFound) System.out.println("Nomor yang anda masukan invalid");
		else dataDisplay();


	}

}