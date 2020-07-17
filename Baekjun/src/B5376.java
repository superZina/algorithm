import java.util.*;
public class B5376 {
	public static int GCD(int A, int B) {
		int gcd = 1;
		int Max =0; int min =0;
		if(A > B) {
			Max = A; min = B;
		}else if(B>A) {
			Max = B;min = A;
		}else {
			Max = A ; min = B;
		}
		while(gcd > 0) {
			gcd = Max%min;
			if(gcd ==0) break;
			Max = min;
			min = gcd;
		}
		return gcd;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			String str = sc.next();
			String[] num = str.split("\\.");
				System.out.println(num[1]);
		}
	}

}
