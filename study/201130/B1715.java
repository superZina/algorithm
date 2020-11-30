import java.util.*;

public class B1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.add(sc.nextInt());
        }
        int tmp = 0;
        if (queue.size() == 1) {
            System.out.println(0);
        } else {
            while (!queue.isEmpty()) {
                if(queue.size() == 1) {
                    break;
                }else{
                int sum = queue.poll() + queue.poll();
                tmp += sum;
                queue.add(sum);
                }
                // System.out.println("tmp : "+tmp);
            }
            System.out.println(tmp);
        }
        
    }
}
