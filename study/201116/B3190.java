
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
public class B3190 {
    public static class Point{
        int x;
        int y;
        public Point(int x , int y ) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        int[] dx = {-1,0,+1,0};
        int[] dy = {0,+1,0,-1};

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] board = new int[N+1][N+1];
        int appleNum = sc.nextInt();
        //사과 배치
        for(int i=0; i<appleNum; i++) {
            int x = sc.nextInt();
            int y =sc.nextInt();
            // apple = 1
            board[x][y] = 1;
            // System.out.println("apple position x :" + x);
            // System.out.println("apple position y :" + y);
        }
        Deque<Point> bemPosition = new LinkedList<>();
        // firest bem's position
        bemPosition.add(new Point(1,1));
        // firest bem's direction
        int bemDirect = 1;
        int n = sc.nextInt();
        int[] times = new int[n];
        String[] directions = new String[n];

        for(int i=0; i<n; i++) {
            // 뱀이 움직인 시간
            times[i] = sc.nextInt();
            directions[i] = sc.next();
        }
        int time = 1;
        int count = 0;
        outerLoop:
            while(true) {
                Point present =  (Point) bemPosition.peekLast();
                int x = present.x;
                int y = present.y;
                
                

                int nX = present.x + dx[bemDirect];
                int nY = present.y + dy[bemDirect];
                // System.out.println("next X : " + nX); 
                // System.out.println("next Y : " + nY); 
                //벽이랑 부딪히면
                if(nX >= board.length || nY >= board.length || nX <1 || nY <1 ){
                    // System.out.println("bem crushed with wall"); 
                    System.out.println(time);
                    break ;
                }
                
                if(board[nX][nY] == 1) {
                //사과가 있다면
                    bemPosition.add(new Point(nX, nY));
                    // System.out.println("bem size : " + bemPosition.size()); 
                    board[nX][nY] = 0;
                }else{
                //사과가 없다면 
                    //먼저 머리를 늘리고
                    bemPosition.add(new Point(nX, nY));
                    //뱀이 몸이랑 부딪히는지 판별
                    Point bemHead = (Point) bemPosition.peekLast();
                    bemPosition.removeLast();
                    for(int k =0 ; k < bemPosition.size(); k ++ ) {
                        Point p = (Point) bemPosition.peekFirst();
                        // System.out.println("bem X : " + p.x); 
                        // System.out.println("bem Y : " + p.y); 
                        // System.out.println("bem Head X : " + bemHead.x); 
                        // System.out.println("bem Head Y : " + bemHead.y); 
                        if(p.x == bemHead.x && p.y == bemHead.y && bemPosition.size() != 1) { //몸과 부딪힌다면
                            // System.out.println("bem crushed with bem's body");
                            System.out.println(time);
                            break outerLoop;
                        }else {
                            bemPosition.remove();
                            bemPosition.add(p);
                        }
                    }
                bemPosition.add(bemHead);
                //사과가 없으니 꼬리를 자름
                bemPosition.remove(); 
                }
                
                // System.out.println("count: "+ count);
                if(count != n&& time == times[count]) {
                    // System.out.println("times : "+time);
                    // System.out.println("times["+count+"]: "+ times[count]);
                    // System.out.println(directions[count]);
                switch(bemDirect) {
                    case 0:
                        if (directions[count].equals("D") ) {
                            bemDirect = 1;
                            count++;
                        }else {
                            bemDirect = 3;
                            count++;
                        }
                    break;
                    case 1:
                    if (directions[count].equals("D") ) {
                        bemDirect = 2;
                        count++;
                    }else {
                        bemDirect = 0;
                        count++;
                    }
                    break;
                    case 2:
                    if (directions[count].equals("D")) {
                        bemDirect = 3;
                        count++;
                    }else {
                        bemDirect = 1;
                        count++;
                    }
                    break;
                    case 3:
                    if (directions[count].equals("D")) {
                        bemDirect = 0;
                        count++;
                    }else {
                        bemDirect = 2;
                        count++;
                    }
                    break;
                    default:
                    break;
                }
                // System.out.println("direction : " + bemDirect);
            }
            time++;

        }
    }
}
