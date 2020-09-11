import java.io.*;

public class B19575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int x = Integer.parseInt(nums[1]);
        long result = 0;
        for(int i=0 ; i<=n; i++ ){
            String[] N = br.readLine().split(" ");
            int a = Integer.parseInt(N[0]);
            int b = Integer.parseInt(N[1]);
            if (b == 0) { //상수일 떄 
                result += a;
                result %= 1000000007;
            }else {
                result = ( result + a ) * x;
                result %= 1000000007;
            }
            
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Long.toString(result));
        
        bw.flush();
        bw.write("\n"); 
        bw.close();
    }
}
