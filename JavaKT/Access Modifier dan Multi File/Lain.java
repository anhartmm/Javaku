

public class Lain {
	// bagian ini dapat diaccess oleh siapa pun
	public static void methodPublic() {
		System.out.println("Lain: Public\n");
	}

	// ini hanya dapat diaccess oleh class yang bersangkutan
	private static void methodPrivate() {
		System.out.println("Private\n")		
	}

	// ini hanya dapat diaccess oleh class dalam package yang sama
	static void methodDefault() {
		System.out.println("Default\n");
	}

	// ini hanya dapat diaccess oleh class dalam package yang sama
	// dan subclassnya
	protected static void methodProtected() {
		System.out.println("Protected\n");
	}
}