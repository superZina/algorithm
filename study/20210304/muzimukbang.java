
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class muzimukbang {
    public static class Point{
        int time; 
        int idx;
        public Point(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }
    }
    public static int solution(int[] food_times, long k) {
        
        List<Point> list2 = new LinkedList<Point>();
        int size = food_times.length;
        for (int i = 0; i < size; i++) {
            list2.add(new Point(food_times[i], i + 1));
        }

        Collections.sort(list2,new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.time < o2.time) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        int prev = 0;
        while (!list2.isEmpty()) {
            Point tmp = list2.get(0);            
            if (k - (tmp.time - prev) * list2.size() < 0)
                break;
            else {
                k -= (tmp.time - prev) * list2.size();                
                prev = tmp.time;
                list2.remove(0);
            }
        }
        int answer = 0;
        if (k==0|| list2.isEmpty())
            answer = -1;
        else {
            Collections.sort(list2, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if (o1.idx < o2.idx) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            });
            answer = list2.get((int) (k)).idx;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] testCase = {1,1,1,1};
        int ans = solution(testCase, 4);
        System.out.println(ans);
    }
}
