import java.util.Scanner;

public class inputUser {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Input first num: ");
		int p = input.nextInt();
		System.out.print("Input second num: ");
		int l = input.nextInt();
		System.out.printf("%d x %d = %d",p,l,p*l);

		/*
		int nextInt()	
		It is used to scan the next token of the input as an integer.
		
		float nextFloat()
		It is used to scan the next token of the input as a float.
		
		double nextDouble()
		It is used to scan the next token of the input as a double.
		
		byte nextByte()	
		It is used to scan the next token of the input as a byte.
		
		String nextLine()
		Advances this scanner past the current line.
		
		boolean nextBoolean()
		It is used to scan the next token of the input into a boolean value.
		
		long nextLong()
		It is used to scan the next token of the input as a long.
		
		short nextShort()	
		It is used to scan the next token of the input as a Short.
		
		BigInteger nextBigInteger()
		It is used to scan the next token of the input as a BigInteger.
		
		BigDecimal nextBigDecimal()
		It is used to scan the next token of the input as a BigDecimal.
		*/
	}
}