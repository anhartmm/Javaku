
public class Main {
	public static void main(String[] args) {
		byte a = 2;
		byte b = 15;
		String a_bits;
		a_bits = String.format("%8s",Integer.toBinaryString(a)).replace(' ', '0'); 
		System.out.printf("%s = %d\n",a_bits,a);

		// Shift left
		System.out.println("\t\nShift left <<");		
		a = (byte)(a << 1);
		a_bits = String.format("%8s",Integer.toBinaryString(a)).replace(' ', '0'); 
		System.out.printf("%s = %d\n",a_bits,a);

		// Shift right
		System.out.println("\t\nShift right >>");		
		a = (byte)(a >> 1);
		a_bits = String.format("%8s",Integer.toBinaryString(a)).replace(' ', '0'); 
		System.out.printf("%s = %d\n",a_bits,a);

		// And &
		System.out.println("\t\nAnd &");
		byte x = (byte)(a & b);
		String ans_bits = String.format("%8s",Integer.toBinaryString(x)).replace(' ', '0'); 
		String b_bits = String.format("%8s",Integer.toBinaryString(b)).replace(' ', '0'); 
		System.out.printf("%s = %d\n",b_bits,b);
		System.out.printf("%s = %d\n",a_bits,a);
		System.out.printf("------------- &");
		System.out.printf("\n%s = %d\n",ans_bits,x);

		// OR |
		System.out.println("\t\nOr |");
		x = (byte)(a | b);
		ans_bits = String.format("%8s",Integer.toBinaryString(x)).replace(' ', '0'); 
		b_bits = String.format("%8s",Integer.toBinaryString(b)).replace(' ', '0'); 
		System.out.printf("%s = %d\n",b_bits,b);
		System.out.printf("%s = %d\n",a_bits,a);
		System.out.printf("------------- |");
		System.out.printf("\n%s = %d\n",ans_bits,x);

		// XOR ^
		System.out.println("\t\nXOR ^");
		x = (byte)(a ^ b);
		ans_bits = String.format("%8s",Integer.toBinaryString(x)).replace(' ', '0'); 
		b_bits = String.format("%8s",Integer.toBinaryString(b)).replace(' ', '0'); 
		System.out.printf("%s = %d\n",b_bits,b);
		System.out.printf("%s = %d\n",a_bits,a);
		System.out.printf("------------- ^");
		System.out.printf("\n%s = %d\n",ans_bits,x);

		// NOT ~
		System.out.println("\t\nNot ~");
		x = (byte)(~a);
		ans_bits = String.format("%8s",Integer.toBinaryString(x)).substring(24);
		System.out.printf("%s = %d\n",a_bits,a);
		System.out.printf("------------- ~");
		System.out.printf("\n%s = %d\n",ans_bits,x);

	}
}