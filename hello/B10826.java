import java.util.*;
import java.math.BigInteger;
public class B10826 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger[] dp = new BigInteger[n+1];
        if(n == 0) {
            System.out.println(0);
        }else if(n == 1) {
            System.out.println(1);
        }else {
            dp[0]  = BigInteger.ZERO; dp[1] = BigInteger.ONE;
            for(int i=2 ; i<=n; i++) {
                dp[i] = dp[i-1].add(dp[i-2]);
            }
            System.out.println(dp[n]);
        }

    }
    
}