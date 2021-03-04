import java.util.*;
public class muzi {
    public static class Point{
        int time; 
        int idx;
        public Point(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }
    }
    public static int solution(int[] food_times, long k) {
        int answer = 0;
        int size = food_times.length;
        int zeroCnt = 0;
        Deque<Point> deque = new LinkedList<Point>();
        for(int i=0; i<size ;i++) {
            deque.addLast(new Point(food_times[i],i+1));            
        }
        while(k!=0 && (zeroCnt != size)) {
            //종료조건 : 0 개수 = 배열 사이즈            
            Point tmp = deque.pollFirst();
            if(tmp.time == 0) {
                deque.addLast(tmp);
            }else{
                tmp.time = tmp.time - 1;
                if(tmp.time == 0) {
                    zeroCnt++;                    
                }
                deque.addLast(tmp);
                k--;
            }
        }

        if(zeroCnt == size) {
            answer = -1;
        }else{
            Point tmp = deque.pollFirst();
            while(tmp.time == 0) {
                // deque.addLast(tmp);
                tmp = deque.pollFirst();
            }
            answer = tmp.idx;
        }
        return answer;
        }
        public static void main(String[] args) {
            int[] testCase = {1,1,1,1,1,1};
            int ans = solution(testCase, 1);
            System.out.println(ans);
        }
}
