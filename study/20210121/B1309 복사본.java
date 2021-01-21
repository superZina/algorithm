import java.util.*;
public class B1309 {
    static int n;
    static long[] dp;
    static int mod = 9901;
    public static long dp(int n) {        
        if( n <= 0 ) return 0 ;
        if(dp[n]!= 0) return dp[n];
        dp[n] = 2*dp(n-1) ;
        dp[n] %= mod;
        dp[n] += dp(n-2);
        dp[n] %= mod;
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new long[100001];
        dp[1] = 3; dp[2] = 7;
        dp(n);
        System.out.println(dp[n]);
    }
}

