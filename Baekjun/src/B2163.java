import java.util.*;
public class B2163 {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] dp = new long[N*M+1];
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		
		for(int i=2; i<=N*M; i++) {
			long min = 9999999;
			int a = i/2;
			int b = i-a;
			min = Math.min(min, dp[a]+dp[b] +1);
			dp[i] = min;
//			System.out.println();
		}
//		for(int i=0; i<=N; i++) {
//			for(int j=0; j<=M; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.print(dp[N*M]);
	}
}
