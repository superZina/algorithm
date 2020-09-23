import java.io.*;

public class B6588 {
    public static boolean isPrime(int n){
        boolean isPrime = true;
        if(n == 1){
            isPrime = false;
        }else if(n == 2){
            isPrime = true;
        }else{
            for(int i=2;i<=Math.sqrt(n);i++){
                if(n%i == 0){
                    isPrime = false;
                }
            }
        }
        return isPrime;
    }

    public static boolean[] prime(int n){
        boolean[] prime = new boolean[n+1];
        prime[1] = false;
        for(int i=2;i<n+1;i++){
            prime[i] = true;
        }
        for(int i=2; i*i<n+1;i++){
            for(int j=i*2 ; j<=n; j += i) {
                // if( j % i == 0) {
                    prime[j] = false;
                
            }
        }
        return prime; 
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        while(n != 0) {
            int b = 0;
            for(int i=1; i<n; i++){
                if(isPrime(i)){
                    b = n - i;
                    if(isPrime(b) && b != 1) {
                        System.out.println(n+" = "+i+" + "+b );
                        break;
                    }
                }
                
            }
            // if(!isAble) {
            //     System.out.println("Goldbach's conjecture is wrong.");
            // }
            n = Integer.parseInt(br.readLine());
        }
    }
}