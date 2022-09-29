
public class Main{
	public static void main(String[] args){

		int nilai_int = 120;
		System.out.println(nilai_int);

		// memperluas rentang ke tipe data yang lebih besar
		long nilai_long = nilai_int;
		System.out.println(nilai_long);

		// memperkecil rentang ke tipe data yang lebih kecil
		byte nilai_byte = (byte) nilai_int;
		System.out.println(nilai_byte);

		int a = 10;
		System.out.println((double) a);
		System.out.println((float) a);
		System.out.println((long) a);

		int b = 4;
		System.out.printf("%d / %d = %f\n",a,b,(float)a/b);
		System.out.printf("%f / %d = %f\n",(float)a,b,(float)a/b);
		System.out.println((byte)a);
		System.out.println((byte)b);
		// byte ab = (byte)a/(byte)b;
		// System.out.println(ab);
	}
}