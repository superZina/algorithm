import java.io.*;

public class B14225 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] inputs = br.readLine().split(" ");
        for(int i=0 ; i<n; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }
        boolean[] check = new boolean[2000010];
        for(int i=0 ; i<(1<<n) ; i++) {
            int sum = 0;
            for(int j=0 ; j<n; j++) {
                if((i & (1 << j)) != 0) {
                    sum += arr[j];
                }
                
            }
            check[sum] = true;
        }
        int min = Integer.MAX_VALUE;
        for(int i=1; i<check.length ; i++) {
            if(!check[i]) {
                min = i;
                break;                
            }           
        }
        System.out.println(min);

    }
}