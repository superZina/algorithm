import java.io.*;
import java.util.*;
import java.util.LinkedList;


public class B1194 {
    static int n;
    static int m;
    static boolean[][][] visit;
    static int[][][] count;
    static char[][] arr;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    // 키를 각각 boolean배열에 저장하면 메모리 초과가 나니 비트마스킹으로 해야겠다
    // 배열로 하면안되나? 한번 해보자 나중에
    public static int getKey(int curKeys, char key) {
        curKeys = curKeys | (1 << key - 'a');
        return curKeys;
    }

    public static boolean hasKey(char door, int curKeys) {
        if (((1 << door - 'A') & curKeys) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static class Point {
        int x;
        int y;
        int key;

        public Point(int x, int y, int key) {
            this.x = x;
            this.y = y;
            this.key = key;
        }
    }

    static int ans = -1;

    public static void bfs(Point start) {
        Queue<Point> que = new LinkedList<>();
        que.add(start);
        visit[start.key][start.x][start.y] = true;
        while (!que.isEmpty()) {
            Point tmp = que.poll();
            int x = tmp.x;
            int y = tmp.y;
            int key = tmp.key;
            // 종료조건 : 1일 때
            if (arr[x][y] == '1') {
                ans = count[key][x][y];
                
                que.clear();
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[key][nx][ny] && !(arr[nx][ny] == '#')) {                    
                    // 문일때
                    if (arr[nx][ny] >= 65 && arr[nx][ny] <= 90) {
                        if (hasKey(arr[nx][ny], key)) {
                            visit[key][nx][ny] = true;
                            count[key][nx][ny] = count[key][x][y] + 1;
                            que.add(new Point(nx, ny, key));
                        } else
                            continue;
                    } else
                    // 열쇠일 때
                    if (arr[nx][ny] >= 97 && arr[nx][ny] <= 122) {
                        int newKey = getKey(key, arr[nx][ny]);
                        visit[newKey][nx][ny] = true;
                        count[newKey][nx][ny] = count[key][x][y] + 1;
                        que.add(new Point(nx, ny, newKey));
                    } else
                    // 그 이외일 때
                    {
                        visit[key][nx][ny] = true;
                        count[key][nx][ny] = count[key][x][y] + 1;
                        que.add(new Point(nx, ny, key));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        arr = new char[n][m];
        visit = new boolean[70][n][m];
        count = new int[70][n][m];

        int startX = 0;
        int startY = 0;
        for(int i =0 ; i<n; i++) {
            String tmp = br.readLine();
            arr[i] = tmp.toCharArray();
            for(int j=0 ; j < m; j++) {
                if(arr[i][j] == '0') {
                    startX = i; startY = j;
                }
            }
        }
        bfs(new Point(startX, startY, 0));        
        System.out.println(ans);                
    }
}