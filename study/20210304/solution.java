import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]); 
        int m = Integer.parseInt(inputs[1]); 
        int[] arr = new int[n];
        int[] dp = new int[n+1];
        inputs = br.readLine().split(" ");        
        for(int i=1; i<=n ; i++) {            
            arr[i-1] = Integer.parseInt(inputs[i-1]);
            dp[i] = dp[i-1] + arr[i-1];
            
        }
        int cnt = 0;
        // for(int i=1; i<=n ; i++) {
        //     System.out.print(dp[i]+" ");
        // }
        // System.out.println();
    
        for(int i = n; i>=1 ; i--) {
            for(int j = 1 ; j<=i; j++) {
                if(dp[i] - dp[j-1] == m) {
                    cnt++;
                    // System.out.println(i+" , "+(j-1));
                }
            }
        }
        System.out.println(cnt);
    }
}