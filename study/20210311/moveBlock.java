import java.io.IOException;
import java.util.*;

public class moveBlock {
    static int[][] arr;
    static int[][] count;
    static boolean[][] visit;
    static int[] dx = { 0, -1, 0, +1 };
    static int[] dy = { -1, 0, +1, 0 };
    static int n;

    public static class Point {
        int x; int y; int nx; int ny;
        public Point(int x, int y, int nx, int ny) {
            this.x = x;this.y = y;this.nx = nx;this.ny = ny;
        }
    }

    // 방문체크 안함
    static public boolean check(int x1, int y1, int x2, int y2) {
        return x1 >= 0 && x1 < n && y1 >= 0 && y1 < n && x2 >= 0 && x2 < n && y2 >= 0 && y2 < n && arr[x1][y1] != 1
                && arr[x2][y2] != 1;
    }

    // 회전여부 체크
    static public boolean checkHorUp(Point p) {
        int x = p.x; int y = p.y; int nx = p.nx; int ny = p.ny;
        return check(x - 1, y, nx - 1, ny);
    }

    static public boolean checkHorDown(Point p) {
        int x = p.x;int y = p.y;int nx = p.nx;int ny = p.ny;
        return check(x + 1, y, nx + 1, ny);
    }

    static public boolean checkVerRight(Point p) {
        int x = p.x;
        int y = p.y;
        int nx = p.nx;
        int ny = p.ny;
        return check(x, y + 1, nx, ny + 1);
    }

    static public boolean checkVerLeft(Point p) {
        int x = p.x;
        int y = p.y;
        int nx = p.nx;
        int ny = p.ny;
        return check(x, y - 1, nx, ny - 1);
    }

    public static int solution(int[][] board) {
        arr = board;
        int answer = 0;        
        Queue<Point> que = new LinkedList<Point>();
        que.add(new Point(0, 0, 0, 1));
        // visit[0][0] = true;
        // visit[0][1] = true;
        // count[0][0] = -1 ; count[0][1] = -1;
        while (!que.isEmpty()) {
            System.out.println();
            for(int i=0 ; i<n; i++) {
                for(int j=0 ; j<n ; j++) {
                    System.out.print(count[i][j]+" ");
                }
                System.out.println();
            }
            Point tmp = que.poll();             
            visit[tmp.x][tmp.y] = true; visit[tmp.nx][tmp.ny] = true;
            System.out.println();
            for(int i=0 ; i<n; i++) {
                for(int j=0 ; j<n ; j++) {
                    System.out.print(visit[i][j]+" ");
                }
                System.out.println();
            }

            int cnt = count[tmp.x][tmp.y];
            // 칸 이동하거나
            for (int i = 0; i < 4; i++) {
                int nx1 = tmp.x + dx[i];
                int nx2 = tmp.nx + dx[i];
                int ny1 = tmp.y + dy[i];
                int ny2 = tmp.ny + dy[i];
                if (check(nx1, ny1, nx2, ny2) && (!visit[nx1][ny1] || !visit[nx2][ny2])) {
                    // visit[nx1][ny1] = true; visit[nx2][ny2] = true;                    
                    count[nx1][ny1] = cnt + 1; count[nx2][ny2] = cnt + 1;
                    que.add(new Point(nx1, ny1, nx2, ny2));
                }
            }
            int x = tmp.x; int y = tmp.y;            
            int nx = tmp.nx; int ny = tmp.ny;            
            // 가로
            if (Math.abs(tmp.y - tmp.ny) == 1) {
                // 위로 회전하거나
                if (checkHorUp(tmp)) { // 회전하려는 곳에 벽이 없음
                    // 왼쪽 위
                    if (!visit[x][y] || !visit[x - 1][y]) {
                        // visit[x][y] = true; visit[x - 1][y] = true;                        
                        count[x][y] = cnt + 1; count[x - 1][y] = cnt + 1;
                        que.add(new Point(x - 1, y, x, y));
                    }
                    // 오른쪽 위
                    if (!visit[nx][ny] || !visit[nx - 1][ny]) {
                        // visit[nx][ny] = true; visit[nx - 1][ny] = true;                        
                        count[nx][ny] = cnt + 1; count[nx - 1][ny] = cnt + 1;
                        que.add(new Point(nx - 1, ny, nx, ny));
                    }

                }
                // 아래로 회전하거나
                if (checkHorDown(tmp)) {
                    // 왼쪽 아래
                    if (!visit[x][y] || !visit[x + 1][y]) {
                        // visit[x][y] = true; visit[x + 1][y] = true;                        
                        count[x][y] = cnt + 1;count[x + 1][y] = cnt + 1;                        
                        que.add(new Point(x, y, x + 1, y));
                    }

                    // 오른쪽 아래
                    if (!visit[nx][ny] || !visit[nx + 1][ny]) {
                        // visit[nx][ny] = true; visit[nx + 1][ny] = true;                        
                        count[nx][ny] = cnt + 1; count[nx + 1][ny] = cnt + 1;
                        que.add(new Point(nx, ny, nx + 1, ny));
                    }
                }

            } else {
                // 세로
                if(checkVerLeft(tmp)) {
                    // 왼쪽으로 회전하거나
                    //왼쪽 위
                    if(!visit[x][y] || !visit[x][y-1]) {
                        // visit[x][y] = true; visit[x][y-1] = true;                        
                        count[x][y] = cnt + 1 ; count[x][y-1] = cnt;
                        que.add(new Point(x, y-1, x, y));
                    }
                    //왼쪽 아래
                    if(!visit[nx][ny] || !visit[nx][ny-1]) {
                        // visit[nx][ny] = true; visit[nx][ny-1] = true;                        
                        count[nx][ny] = cnt + 1 ; count[nx][ny-1] = cnt;
                        que.add(new Point(nx, ny-1, nx, ny));
                    }
                }
                
                // 오른쪽으로 회전하거나
                if(checkVerRight(tmp)) {
                    if(!visit[x][y] || !visit[x][y+1]) {
                        // visit[x][y] = true; visit[x][y+1] = true;
                        count[x][y] = cnt + 1 ; count[x][y+1] = cnt + 1;
                        que.add(new Point(x, y, x, y+1));
                    }
                    if(!visit[nx][ny] || !visit[nx][ny+1]) {
                        // visit[nx][ny] = true; visit[nx][ny+1] = true;
                        count[nx][ny] = cnt + 1 ; count[nx][ny+1] = cnt + 1;
                        que.add(new Point(nx, ny, nx, ny+1));
                    }
                }
            }
        }
        answer = count[n-1][n-1];
        return answer;
    }

    public static void main(String[] args) {
        int[][] array = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
        //{{0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 0, 0, 0}};

        n = array.length;
        visit = new boolean[n][n];
        count = new int[n][n];
        int ans = solution(array);
        System.out.println(ans);
        for(int i=0 ; i<n; i++) {
            for(int j=0 ; j<n ; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i=0 ; i<n; i++) {
            for(int j=0 ; j<n ; j++) {
                System.out.print(count[i][j]+" ");
            }
            System.out.println();
        }
    }
}
