
import java.util.*; 
//1. f(1) = 1 
//f(2) = 3
//f(3) = 
//f(n) = f(n-1) + 2f(n-2)
public class B11727 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 1 || n == 2) {
			int[] d = new int[3];
			d[1] = 1;
			d[2] = 3;
			long res = d[n]%10007;
			System.out.print(res);
		}else {
		long[] dp = new long[n+1];
		dp[1] = 1;
		dp[2] = 3;
		for(int i=3; i<=n; i++) {
//			long a = toNum(dp[i-1]);
//			long b = toNum(dp[i-2])*2; 
//			long c = a+b;
//			dp[i] = Long.toString(c);
			dp[i] = dp[i-1] + 2*dp[i-2] ;
			dp[i] = dp[i]%10007;
		}
//		long N = toNum(dp[n]);
//		N = N%10007;
		
		
		
		System.out.println(dp[n]);
		}
	}
}
