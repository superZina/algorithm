import java.util.*;

public class B9465 {
    static int[][] dp;
    public static int sticker(int c, int status, int[][] arr) {
        // status 0 : 왼쪽에 1,2행 모두 스티커를 뗴지 않았을 때
        // status 1 : 왼쪽 위에 뗐을 떄
        // status 2 : 왼쪽 아래 떼어냈을 떄
        // 종료조건 : 마지막 열에 왔을 때
        // 종료조건2 : 이미 값이 있다면
        if(c == arr[0].length) return 0;
        if(dp[c][status] != -1) {
            return dp[c][status];
        }

        //아무것도 떼지 않음
        int res = sticker(c+1, 0, arr);
        // 왼쪽 위를 뗸다
        if(status != 1) res = Math.max(res, arr[0][c] + sticker(c+1, 1, arr));
        //왼쪽 아래를 뗀다
        if(status!=2) res = Math.max(res, arr[1][c] + sticker(c+1, 2, arr));
        // dp 배열 갱신
        dp[c][status] = res;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++) {
            int N = sc.nextInt();
            int[][] arr = new int[2][N];
            dp = new int[N][3];
            for(int j=0 ;j<2; j++ ) {
                for(int k=0 ;k<N; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
            for(int j=0 ;j<N;j++) {
                for(int k=0 ; k<3;k++) {
                    dp[j][k] = -1;
                }
            }
            
            System.out.println(sticker(0, 0, arr));
        }
        sc.close();

    }
}
