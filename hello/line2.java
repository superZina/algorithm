import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class line2 {
    public int[] solution(int[] ball, int[] order) {
        int[] answer = new int[ball.length];
        Deque<Integer> balls = new ArrayDeque<>();
        for(int i=0;i<ball.length;i++) {
            balls.addLast(ball[i]);
        }
        ArrayList<Integer> wait = new ArrayList<>(); //아직 나가지 못한 공들 저장할 배열
        int orderIdx = 0;
        for(int i=0;i<ball.length; i++){
            //order순서로 수행하기전에 wait에 있는 것들을 제거할 수 있는지 검사
            while(true) {
                int fsize = wait.size();
                for(int j=0; j<wait.size(); j++){
                    int wb = wait.get(j);
                    if(balls.peekFirst() == wb) { //맨 앞부분에 있을 때 
                        answer[orderIdx] =  balls.removeFirst();
                        wait.remove(j);
                        orderIdx++;
                    }else if(balls.peekLast() == wb) {//맨 뒷부분에 있을 때
                        answer[orderIdx] = balls.removeLast();
                        wait.remove(j);
                        orderIdx++;
                    }        
                }
                int lsize = wait.size();
                if(fsize == lsize) break; // 변한게 없다면 탈출
            }
            int b = order[i];
            if(balls.peekFirst() == b) { //맨 앞부분에 있을 때 
                answer[orderIdx] =  balls.removeFirst();
                orderIdx++;
            }else if(balls.peekLast() == b) {//맨 뒷부분에 있을 때
                answer[orderIdx] = balls.removeLast();
                orderIdx++;
            }else{ //wait에 추가
                wait.add(b);
            }
        }
        
        return answer;
    }

}
