import java.io.*;

public class B1806 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int S = Integer.parseInt(inputs[1]);
        int[] arr = new int[N];
        inputs = br.readLine().split(" ");
        for(int i=0 ; i<N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }
        
        int left = 0; int right = 0;
        int sum = arr[0];
        int ans = N+1; 
        while(right < N) {
            // System.out.println("left : "+left + " , right : "+right +" sum : "+sum+" , ans : "+(right-left+1));
            if(sum < S) {
                right += 1;
                if(right >= N) break;
                sum += arr[right];
            }else if(sum >= S) {
                ans = Math.min(ans, right - left + 1);                
                if(left == right) {
                    right += 1;
                    if(right >= N) break;
                    sum += arr[right];
                }
                sum -= arr[left];                
                left += 1;
                
            }
        }
        if(ans == N+1) {
            System.out.println(0);
        }else{
        System.out.println(ans);
        }
    }
}
