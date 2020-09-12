import java.io.*;
import java.math.BigInteger;

public class B2090 {
    public static BigInteger gcd(BigInteger x, BigInteger y ) {
        BigInteger gcd = BigInteger.ONE;
        
        BigInteger max = x.max(y);
         BigInteger min = x.min(y);
        //  System.out.println("max : "+max+" min : "+min);
        while(gcd.compareTo(BigInteger.ZERO) == 1){
            gcd = max.mod(min);
            // System.out.println("gcd : "+gcd);
            if(gcd.equals(BigInteger.ZERO)) break;
            max = min;
            min = gcd;
        }
        return min;
    }
    public static void main(String[] args) throws IOException   {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        BigInteger GCD = BigInteger.valueOf(Long.parseLong(nums[0]));
        BigInteger LCM = BigInteger.ONE; 


        for(int i=0;i<n;i++) {
            LCM = LCM.multiply(BigInteger.valueOf(Long.parseLong(nums[i])));
            // System.out.println("GCD : "+GCD + " , "+"nums : "+Long.parseLong(nums[i]));
            GCD = gcd(BigInteger.valueOf(Long.parseLong(nums[i])),GCD);
        }
        LCM = LCM.divide(GCD); //분모 : 최소공배수
        //분자 : 최소공배수에서 각 수를 나눈것들의 합
        BigInteger head = BigInteger.ZERO;
        for(int i=0;i<n; i++) {
            // System.out.println(LCM/Long.parseLong(nums[i]));    
            head = head.add(LCM.divide(BigInteger.valueOf(Long.parseLong(nums[i]))));
        }
        //답은 LCM / head
        BigInteger ansGcd = gcd(LCM, head);
        // System.out.println("GCD : "+ GCD);
        // System.out.println("LCM : "+ LCM);
        // System.out.println("head : "+ head);
        System.out.println(LCM.divide(ansGcd)+"/"+head.divide(ansGcd));
    } 
}
