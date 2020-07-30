import java.util.*;
public class B11051 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		long[][] dp = new long[N+1][K+1];
		for(int i = 1; i<N+1 ; i++) {
			for(int j =0 ; j<K+1; j++) {
				if( j ==0 ) {
					dp[i][j] = 1;
				}else if(j== 1) {
					dp[i][j] = i;
				}else if (i == j) {
					dp[i][j] = 1;
				}else{
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
					dp[i][j] = dp[i][j]%10007;
				}
			}
		}
		System.out.print(dp[N][K]);
		System.out.print(dp[N][K]);
	}
}