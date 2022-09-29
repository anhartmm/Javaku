import java.util.*;
import java.lang.StringBuilder;

// Selengkapnya cari di google StringBuilder Docs

public class StringBuilderMain {
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder("halo");
		printBuilder(builder);

		// operasi di builder
		// 1. append
		builder.append("-halo semuanya");
		printBuilder(builder);
		builder.append(", apa kabsssssssssssss");
		printBuilder(builder);

		// 2. Insert
		builder.insert(20,"hari ini ");
		printBuilder(builder);

		//delete
		builder.delete(33,49);
		printBuilder(builder);

		// replace
		builder.replace(25,33,"jum'at");
		printBuilder(builder);

		// casting menjadi string
		String str = builder.toString();
		int id = System.identityHashCode(str);
		System.out.printf("string: %s\n",str);
		System.out.printf("address: %s\n\n",Integer.toHexString(id));

	}

	private static void printBuilder(StringBuilder builder) {
		System.out.println("data: " + builder);
		// default kapasitas stringbuilder adalah 16 character ketika new Stringbuilder() (kosong)
		System.out.println("panjang: " + builder.length());
		System.out.println("kapasitas: " + builder.capacity()); // di string capacity takde
		int addressBuilder = System.identityHashCode(builder);
		System.out.println("address: " + Integer.toHexString(addressBuilder));
		System.out.printf("\n");
	}

}