import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1520 {


    public static int Go(int x, int y) {
        if (x == 0&& y == 0) {
            count++;
            return 1;            
        }
        if(dp[x][y] != -1) {
            return dp[x][y];
        }
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
                if (arr[nx][ny] > arr[x][y]) {
                    visit[nx][ny] = true;
                    ans += Go(nx, ny);
                    visit[nx][ny] = false;
                }
            }
        }
        return dp[x][y] = ans;

    }

    static int[] dx = { -1, 0, +1, 0 };
    static int[] dy = { 0, +1, 0, -1 };
    static int count;
    static int N;
    static int M;
    static int[][] arr;
    static int[][] dp;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        arr = new int[N][M];
        dp = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] nums = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(nums[j]);
                dp[i][j] =  -1;
            }
        }        
        
        
        System.out.println(Go(N-1, M-1));
        for(int i=0 ; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
