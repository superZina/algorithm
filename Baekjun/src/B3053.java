import java.util.*;
public class B3053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double b = (n*n*2);
		double a = (Math.PI*n*n);
		System.out.printf("%.6f\n",a);
		System.out.printf("%.6f\n",b);
	}
}
