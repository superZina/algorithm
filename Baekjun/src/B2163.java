import java.util.*;
public class B2163 {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] dp = new int[N+1][M+1];
		
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=M; j++) {
				if(i==0) {
					dp[i][j] = 0;// 분할한 영역이 없을 시 
				}else if(j==0) {
					dp[i][j] = 0;// 분할한 영역이 없을 시 
				}
				else if(i==1 && j ==1) {
					dp[i][j] = 0;// 1x1 의 정사각형일 때 
				}else if(i == 1 && j>1) {
					dp[i][j] = j-1;
				}else if(i>1 && j==1 ) {
					dp[i][j] = i -1;
				}
			}
		}
		for(int i=0; i<=N; i++) {
			int min = 9999;
			for(int j=0; j<=M; j++) {
				int wmin =99999;
				int hmin = 99999;
				for(int k=0; k<=j;k++) {
					//세로 분할
					int res = dp[i][j-k] + dp[i][k] + 1;
					
					wmin = Math.min(wmin,res);
					
//					System.out.println("wres : "+res);
				}
				dp[i][j] = wmin;
				for(int k=0; k<=i;k++) {
					//세로 분할
					int res = dp[i-k][j] + dp[k][j] + 1;
					
					hmin = Math.min(hmin,res);
					
//					System.out.println("wres : "+res);
				}
				dp[i][j] = Math.min(hmin, dp[i][j]);
			}
//			System.out.println();
		}
//		for(int i=0; i<=N; i++) {
//			for(int j=0; j<=M; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.print(dp[N][M] +1);
	}
}
