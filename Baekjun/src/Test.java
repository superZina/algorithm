import java.util.Scanner;

public class Test {
	public static int BEP(int a, int b, int c) {
		int count=0;
		while(a+b*count >= c*count) {
			if(a+b*count> Integer.MAX_VALUE) return -1;
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); int B = sc.nextInt(); int C = sc.nextInt();
		int result = BEP(A,B,C);
		System.out.print(result );
	}
}
