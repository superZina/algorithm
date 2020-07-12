import java.util.*;
public class B1789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long result = 0;
		long count = 1; 
		double disc = 1 + 4.0*n*2.0;
		double sqr = Math.sqrt(disc);
		double max = Math.max(-1 + sqr, -1 - sqr);
		System.out.println((long)(max/2));
	}
 }