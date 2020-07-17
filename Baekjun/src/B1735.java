import java.util.*;
public class B1735 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		int b1 = sc.nextInt();
		int b2 = sc.nextInt();
		int A = a1*b2 + a2*b1;
		int B = a2*b2;
		int Max =0; int min =0;
		if(A > B) {
			Max = A; min = B;
		}else if(B>A) {
			Max = B;min = A;
		}else {
			Max = A ; min = B;
		}
		int gcd = 1;
		while(gcd > 0) {
			gcd = Max%min;
			if(gcd ==0) break;
			Max = min;
			min = gcd;
		}
		System.out.println(A/min+" "+B/min);
	}
}
