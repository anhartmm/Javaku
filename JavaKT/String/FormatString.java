import java.util.Formatter;

public class FormatString {
	public static void main(String[] args) {
		String nama = "Udin";
		int umur = 17;

		// output: Nama saya adalah Udin, umur saya adalah 17 tahun
		System.out.println("Nama saya adalah " + nama + ", umur saya adalah " + umur + " tahun");

		// cara lainnya adalah dengan format string
		// printf: print format
		System.out.printf("Nama saya adalah %s, umur %s adalah %d%% tahun",nama,nama,umur);

		// conversion : f=floating point, d=integer. c=character, s=string, b=boolean
		// Selengkapnya cari google https://docs.oracle.com/javase/8/docs

		// struktur format = %[argumen_index$][flags][width][.precision]conversion(f,d,c,b) 

		// argumen_index$
		System.out.println("\n\n[argumen_index$]");
		//udin, wahai udin kemana saya kamu udin
		System.out.printf("%1$s, wahai %1$s kemana saja kamu %1$s?",nama);
		System.out.printf("\nUmur %1$s berapa?, \n%1$s menjawab %2$d tahun, \nwah masih muda juga ya umurnya %2$d tahun\n",nama,umur);
		System.out.printf("wah kalau umur %1$d tahun, berarti %2$s lahir tahun %3$d, \nyang artinya %2$s beda %4$d tahun dari si %5$s\n",umur,nama,2004,10,"Ucup");
	
		// flags
		System.out.println("\n[flags]");
		int int1 = 5;
		int int2 = 8;
		int hasil = int1 - int2;
		System.out.printf("%d - %d = %+d",int1,int2,hasil);

		// width
		System.out.println("\n\n[width]");
		int int3 = 1000;
		System.out.println("INTEGER");
		System.out.printf("%d\n",int3);
		System.out.printf("%5d\n",int3);
		System.out.printf("%-10d\n",int3); // flags = '-' artinya rata kiri
		System.out.printf("%+5d\n",int3); // flags akan mengambil slot di dalam format
		System.out.printf("%+-6d\n",int3); // flags bisa digabungkan
		System.out.printf("%10d\n",int3);
		System.out.printf("% 10d\n",int3);
		System.out.printf("%010d\n",int3); // flasg = '0', kita tambahakn leading "0" di depan
		System.out.printf("%+010d\n",int3);
		int int4 = 1000000000;
		System.out.printf("%,10d\n",int3); // flags = ",", menandakan delimeter per seribu
		System.out.printf("%,10d\n",int4);

		System.out.printf("\nFLOATING POINT\n");
		float float1 = 1.543f;
		System.out.printf("%f\n",float1);
		System.out.printf("%10f\n",float1); // floating point akan mengambil width dengan 6 desimal

		// [.precision]
		System.out.println("\n[.precision]");
		float float2 = 15.678f;
		System.out.printf("%f\n",float2);
		System.out.printf("%.1f\n",float2);
		System.out.printf("%.2f\n",float2);
		System.out.printf("%8.2f\n",float2); // gabungkan dengan width
		System.out.printf("%+08.2f\n",float2); // gabungkan dengan width dan flag
	

		// contoh
		String nama2 = "Ucup";
		float IPK = 3.78512312311f;
		// format = %[argumen_index$][flags][width][.precision]conversion(f,d,c,b)
		System.out.printf("IPK %1$S berapa?\n%1$s berkata \"saya dapet %2$+5.2f\"\n\n",nama2,IPK);
	
		// Kesimpulan
		// Save format ini kedalam variable string

		String info_biasa = "nama: " + nama + ", IPK: " + IPK;
		System.out.println("biasa: " + info_biasa);

		String info_format = String.format("nama: %1$s, IPK: %2$+5.2f",nama,IPK);
		System.out.println("format: " + info_format);

		// save format ini ke dalam StringBuilder

		StringBuilder builder_info = new StringBuilder();
		Formatter formatBuilder = new Formatter(builder_info);
		formatBuilder.format("nama: %1$s, IPK: %2$+5.2f",nama,IPK);
		System.out.println("string builder format: " + builder_info);
	}	
}