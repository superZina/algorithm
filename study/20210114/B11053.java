import java.util.*;

public class B11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                } else {
                    dp[i] = 1;
                }
            }

        }
        int prev = dp[0];
        int prevIdx = 0;
        // for(int j=0; j<n; j++) {

        // System.out.print(dp[j]+" ");

        // }
        for (int j = 1; j < n; j++) {
            if (dp[j] > prev && arr[j] > arr[prevIdx]) {
                System.out.print(arr[j] + " ");
                prev = dp[j];
                prevIdx = j;
            }
        }
        System.out.println();
    }
}
