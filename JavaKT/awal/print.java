
public class Main{
	public static void main(String[] args){
		System.out.println("Halo dunia dengan new line");
		System.out.print("Halo ");
		System.out.println(args[0]);
		System.out.printf("Halo dunia tanpa new line %d",123);

		// comment
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.BYTES);
		System.out.println(Float.MAX_VALUE);
		System.out.println(Float.MIN_VALUE);
		System.out.println(Float.BYTES); // byte
		System.out.println(Integer.SIZE); // bit
		System.out.println(Integer.SIZE / Integer.BYTES);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.BYTES);
		long data_long = 1000l;
		float data_float = 0.5f;
		double data_double = 0.12313123121232d;
		char data_char = 'a';
		boolean data_boolean = true;
		System.out.println(data_float);
		System.out.println(data_long);
		System.out.println(data_double);
		System.out.println(Long.SIZE);
		System.out.println(Double.SIZE);

	}
} 