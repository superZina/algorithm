
import java.util.*;
public class B1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        boolean[] nums = new boolean[4000001];
        Arrays.fill(nums, true);
        ArrayList<Integer> demicals = new ArrayList<>();
        for(int i=2 ; i<nums.length ; i++) {
            if(!nums[i]) continue;
            for(int j=i+i ; j<nums.length ; j+=i) {
                nums[j] = false;
                // System.out.println(j);
            }

        }
        
        for(int i=2 ; i<nums.length ; i++) {
            if(nums[i]) {
                demicals.add(i);           
            }
        }
        int n = sc.nextInt();
        int left = 0; int right = 0;
        long sum = demicals.get(0);
        int N = demicals.size();   
        int ans = 0;     
        Collections.sort(demicals);
        while(right < N) {
            if (sum < n) {
                right += 1;
                if(right >= N) break;
                sum += demicals.get(right);
            }else if (sum > n ) {
                sum -= demicals.get(left);  
                left += 1;                                  
            }else if (sum == n ){
                ans += 1;
                right += 1;
                if(right >= N) break;
                
                sum += demicals.get(right);
            }
            if(left > right || right >= N) break;
        }
        System.out.println(ans);
    }
}
