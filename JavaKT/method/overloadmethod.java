import java.util.*;

public class OverloadMethod {
	public static void main(String[] args) {
		printAngka(5);
		printAngka(2.4f);
		printAngka(12.4d);
	}

	private static void printAngka(float angkaFLOAT) {
		System.out.printf("Angka ini adalah integer yaitu %f\n",angkaFLOAT);
	}

	private static void printAngka(int angkaINT) {
		System.out.printf("Angka ini adalah integer yaitu %d\n",angkaINT);
	}

	private static void printAngka(double angkaDOUBLE) {
		System.out.printf("Angka ini adalah integer yaitu %f\n",angkaDOUBLE);
	}
}