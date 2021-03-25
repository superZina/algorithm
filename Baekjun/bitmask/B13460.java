import java.io.*;

public class B13460 {
    static int LIMIT = 10;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static char[][] arr;
    public static class Ball {
        //위치
        int x; int y;
        boolean hole; //구멍에 빠졌는지
        boolean move; //움직였는지
        public Ball (int x, int y, boolean hole , boolean  move) {
            this.x = x; this.y = y;
            this.hole = hole; this.move = move;
        }
    }

    //simulate : 구슬 하나가 움직이는 행위 - > Ball
    public static Ball simulate(char[][] arr, int x, int y, int k) {        
        boolean moved = false;
        //이미 구슬이 빠졌다면 현재위치가 '.'으로 되어있음 
        if(arr[x][y] == '.') return new Ball(x, y, false, false);
        while(true) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            // #이나 벽을 만날때 까지 이동
            if(nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length) {
                return new Ball(x, y, false, moved);
            }
            char c = arr[nx][ny];
            if( c == '#') {
                return new Ball(x, y, false, moved);
            }else if (c == 'R' || c == 'B') {
                return new Ball(x, y, false, moved);
            }else if(c == '.') {
                char tmp = arr[x][y];
                arr[nx][ny] = tmp;
                arr[x][y] = c;
                x = nx; y = ny;
                moved = true;
            }else if(c == 'O') {
                arr[x][y] = '.';
                moved = true;
                return new Ball(x, y, true, moved);
            }
        }
    }

    //check : 10번 기울임 , 10번 이내에 할 수 없다면 -1 리턴
    //빨강먼저 , 파랑순으로 이동, 둘다 이동한 적이 없을 때 while문 탈출
    public static int check(char[][] arr ,int[] dir) {
        //R , B , H 위치 찾기
        int rx = 0; int ry = 0;
        int bx = 0; int by = 0;
        int hx = 0; int hy = 0;
        for(int i=0 ; i<arr.length ; i++) {
            for(int j=0 ; j<arr[0].length ; j++) {
                if (arr[i][j] == 'R') {
                    rx = i ; ry = j;
                }else if(arr[i][j] == 'B') {
                    bx = i; by= j;
                }else if (arr[i][j] == 'O') {
                    hx= i; hy = j; 
                }
            }
        }
        int cnt = 0;
        for(int k : dir){
            cnt += 1;
            boolean RHole = false; boolean BHole = false;
            while(true) {                
                Ball red = simulate(arr, rx, ry, k);
                rx = red.x ; ry = red.y;
                Ball blue = simulate(arr, bx, by, k);
                bx = blue.x ; by = blue.y;   
                //두 구슬이 모두 움직이지 않았다면 그만이동
                if(red.move == false && blue.move == false) break; 
                if(red.hole) RHole = true;
                if(blue.hole) BHole = true;
                
            }
            if(BHole) return -1;
            if(RHole) return cnt;
        }  
        return -1;
    }

    //0 : <- , 1 : -> , 2 : 위 , 3 : 아래
    //2진법으로 비트 마스킹한 k를 가지고 4진법으로 바꿔 방향 배열을 만들어냄
    static int[] gen(int k) {
        int[] dir = new int[LIMIT];
        for(int i=0 ; i<LIMIT; i++ ) {
            dir[i] = (k&3);
            k >>= 2; //2개씩 옮겨감
        }
        return dir;
    }

    //경우의 수 줄이기
    static boolean Valid(int[] dir) {
        //같은방향으로 가거나, 이미 간 방향의 반대방향으로 가는것은 의미가 없으므로 건너뜀
        for(int i=0 ; i<dir.length-1 ; i++) {
            if(dir[i] == 0 && dir[i+1] == 1) return false;
            if(dir[i] == 1 && dir[i+1] == 0) return false;
            if(dir[i] == 2 && dir[i+1] == 3) return false;
            if(dir[i] == 3 && dir[i+1] == 2) return false;
            if(dir[i] == dir[i+1]) return false;            
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]); 
        int M = Integer.parseInt(inputs[1]); 
        arr = new char[N][M];
        String[] map = new String[N];
        for(int i=0 ; i<N; i++) {
            map[i] = br.readLine();
        }
        
        int ans = -1;
        //0~(1<<10*2)까지 경우의 수 전부 돌려봄
        for(int k=0 ; k<(1<<LIMIT*2) ; k++) {
            int[] dir = gen(k);
            if(!Valid(dir)) continue;
            for(int i=0 ; i<N; i++) {            
                arr[i] = map[i].toCharArray();            
            }
            int cur =  check(arr ,dir);
            if(cur == -1) continue;
            else if(ans > cur || ans == -1) ans = cur;                
        }
        System.out.println(ans);
    }
}
