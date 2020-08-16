import java.io.*;
public class B1929 {
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
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split(" ");
        int a = Integer.parseInt(word[0]);
        int b = Integer.parseInt(word[1]);


        boolean[] prime = prime(b);
        for(int i=a;i<prime.length ; i++){
            if(prime[i] == true){
                System.out.println(i);
            }
        }
    }
}