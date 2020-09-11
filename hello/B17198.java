import java.io.*;
import java.util.LinkedList;



public class B17198 {
    static int[] dx = {-1 , 0 , 1, 0};
    static int[] dy = {0 , +1 , 0, -1};
    static boolean[][] visit;
    static char[][] farm;
    static int[][] len = new int[10][10];    
    
    public static class Point{
        int x;
        int y;
        Point() {

        }
        Point(int x , int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int count = 0;
    public static void bfs(Point P) {
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(P);
        visit[P.x][P.y] = true;
        while(!queue.isEmpty()) {
            Point s = queue.poll();
            // System.out.println(s.x + " , " + s.y);
            int x = s.x;
            int y = s.y;
            for(int i=0 ; i<4; i++) {
                int nx = x+ dx[i];
                int ny = y+ dy[i];
                 if( nx >= 0 && nx <10 && ny >=0 && ny <10 && farm[nx][ny] != 'R'){
                    
                    if(farm[nx][ny] == 'L') { System.out.println(len[x][y]); return; }
                    if(!visit[nx][ny]) {
                         queue.add(new Point(nx,ny));
                        visit[nx][ny] = true;
                        len[nx][ny] = len[x][y] + 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        farm = new char[10][10];
        visit = new boolean[10][10];
        

        Point B = new Point();
        Point L;
        for(int i=0; i<10; i++) {
            String text = br.readLine();
            for(int j = 0; j<10 ; j++) {
                farm[i][j] = text.charAt(j);
                if (text.charAt(j) == 'B') {
                    B.x = i;
                    B.y = j;   
                }
            }
        }

        bfs(B);
        // System.out.println(count);

    }
}
