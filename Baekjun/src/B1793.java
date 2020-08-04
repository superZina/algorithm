import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
public class B1793 {
	public static void main(String args[]) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s = bf.readLine())!= null) {
			if (s=="") break;
				int n = Integer.parseInt(s);
				
			if(n==0) {
				System.out.println(1);
			}else {
				BigInteger[] dp = new BigInteger[n+1];
				dp[0] = BigInteger.ZERO;
				dp[1] = BigInteger.ONE;
				if(n > 1) {
					dp[2] = BigInteger.valueOf(3);
				}
				for(int i=3; i<=n; i++) {
					BigInteger tmp = dp[i-2].multiply(BigInteger.valueOf(2));
					dp[i] = dp[i-1].add(tmp) ;
				}
				System.out.println(dp[n]);
				}
		}
		
	}
}
