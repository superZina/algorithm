import java.math.BigInteger;
import java.util.*;
public class B1793 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String prob = sc.nextLine();
//			BigInteger n = sc.nextBigInteger();
			StringTokenizer st = new StringTokenizer(prob);
			BigInteger n;
			if(!prob.isEmpty()) {
				//string을 bigInteger로
				n = BigInteger.valueOf(Long.parseLong(st.nextToken()));
			}else {
				break;
			}
			if(n == BigInteger.ONE || n == BigInteger.valueOf(2)) {
				int[] d = new int[3];
				d[0] = 0;
				d[1] = 1;
				d[2] = 3;
				long res = d[n.intValue()]%10007;
				System.out.println(res);
			}else {
				int N = n.intValue();
			BigInteger[] dp = new BigInteger[N+1];
			dp[0] = BigInteger.ZERO;
			dp[1] = BigInteger.ONE;
			dp[2] = BigInteger.valueOf(3);
			for(int i=3; i<=N; i++) {
				BigInteger tmp = dp[i-2].multiply(BigInteger.valueOf(2));
				dp[i] = dp[i-1].add(tmp) ;
//				dp[i] = dp[i]%0;
			}
			
			
			
			System.out.println(dp[n.intValue()]);
			}
//			System.out.print(st.nextToken());
		}
		
	}
}
