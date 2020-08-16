import java.io.*;

public class B1987 {
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] n = br.readLine().split(" ");
        int count = 0;
        for(int i=0;i<N;i++){
            if(isPrime(Integer.parseInt(n[i]))) count++;
        }
        System.out.println(count);
    }
}