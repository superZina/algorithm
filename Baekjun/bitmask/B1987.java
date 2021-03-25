import java.io.*;

public class B1987 {
    
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static char[][] arr;
    static boolean[] visit = new boolean[30];
    static boolean[][] visitBoard;
    static int max = 0;
    static int n; static int m;
    public static class Point{
        int x; int y; 
        public Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    public static void bfs(Point p , int cnt) {
        // System.out.println("x : "+p.x+" , y : "+p.y);
        //종료조건 : 이미 방문했으면 종료
        char c = arr[p.x][p.y];
        // if(visit[c-'A']) return;
        // else{
            max = Math.max(max, cnt);
            // System.out.println("x : "+p.x+" , y : "+p.y);
            for(int i=0 ; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visitBoard[nx][ny] || visit[arr[nx][ny] - 'A']) continue;
                else {
                    visitBoard[nx][ny] = true;
                    visit[arr[nx][ny] -'A'] = true;
                    bfs(new Point(nx, ny), cnt + 1);
                    visitBoard[nx][ny] = false;
                    visit[arr[nx][ny] - 'A'] = false;
                }
            }
        // }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        arr = new char[n][m];
        visitBoard = new boolean[n][m];
        for(int i=0 ; i<n ; i++) {
            String tmp = br.readLine();
            arr[i] = tmp.toCharArray();
        }
        visit[arr[0][0] - 'A'] = true;
        visitBoard[0][0] = true;
        bfs(new Point(0, 0), 1);
        System.out.println(max);
    }
}
