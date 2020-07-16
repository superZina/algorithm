import java.util.*;
public class B1021 {
	public static void main(String[] args) {
		Deque<Integer> que = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			que.addLast(i+1);;
		}
		int count = Integer.parseInt(sc.next());
		for(int i=0; i<count;i++) {
			int dnum = sc.nextInt();
			int tmp = 0;
			while(true) {
				tmp = que.peekFirst();
				if(tmp == dnum) {
					break;
				}else {
					que.addLast(tmp);
					count++;
				}
			}
		}
		System.out.print(count);
	}
}
