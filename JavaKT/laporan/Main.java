import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
			
		boolean isLanjut = true;	

		clearScreen();
		
		while(isLanjut) {
			System.out.println("\t\nDatabase Pengeluaran\n");

			menu();

			isLanjut = isContinue("Kembali ke Menu Utama",true);
		}
	}

	public static void menu() throws IOException {
		Scanner sc = new Scanner(System.in);
		int opsi;

		bulanTahunDisplay();
		
		System.out.println("\n1. Tambah\t2. Update\t3. Delete\t4. Cari\t\t5. Detail data");
		System.out.print("\nMasukan Pilihan: ");
		opsi = sc.nextInt();

		switch(opsi) {
			case 1:
				addBulanTahun();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				System.err.println("\n!!! ERROR !!!");
		} 		
	}

	public static void addBulanTahun() throws IOException {
		FileWriter fileOutput = new FileWriter("blnthn.txt");
		BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

		Scanner sc = new Scanner(System.in);
		String bulan, tahun;
		boolean isYakin;

		System.out.println("Masukan bulan dan tahun");
		System.out.print("Bulan		: "); bulan = sc.next();
		System.out.print("Tahun		: "); tahun = sc.next();

		isYakin = isContinue("Apakah anda yakin ingin menambah data tersebut",false);

		if(isYakin) {
			bufferedOutput.write(bulan + "," + tahun);
			bufferedOutput.newLine();
			System.out.println("\nData berhasil ditambah");
			bulanTahunDisplay()
		}


	}

	public static void bulanTahunDisplay() throws IOException {

		FileReader fileInput;
		BufferedReader bufferedInput;

		String data;
		int noData = 1;
		StringTokenizer st;

		try {
			fileInput = new FileReader("blnthn.txt");
			bufferedInput = new BufferedReader(fileInput);
		} catch(Exception e) {
			FileWriter fileOutput = new FileWriter("blnthn.txt");
			BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);
			bufferedOutput.write("kosong,kosong");
			bufferedOutput.newLine();
			bufferedOutput.flush();
			fileOutput.close();
			bufferedOutput.close();
			return;
		}

		System.out.println("--------------------------------------------------");
		System.out.println("--------------------------------------------------");

		data = bufferedInput.readLine();

		while(data != null) {
			st = new StringTokenizer(data,",");
			System.out.printf("%2d | ",noData);
			System.out.printf("%-20s | ",st.nextToken());
			System.out.printf("%-20s | ",st.nextToken());
			noData++;
			data = bufferedInput.readLine();
		}

		System.out.println("\n--------------------------------------------------");

	}

	private static void clearScreen() {
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

	private static boolean isContinue(String message, boolean ok) {
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