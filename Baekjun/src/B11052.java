import java.util.Arrays;
import java.util.Scanner;

public class B11052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] P = new int[N+1];
		for(int i=1;i<=N;i++) {
			P[i] = sc.nextInt();
		}
		int[] R = new int[N+1];
		for(int i=1;i<=N;i++) {
			int[] tmp = new int[i+1];
			for(int j=1;j<=i;j++) {
				tmp[j] = P[j] + R[i-j];
			}
			Arrays.sort(tmp);
			R[i] = tmp[i];
		}
		System.out.print(R[N]);
	}
}
