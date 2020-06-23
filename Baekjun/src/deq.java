import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class deq {
	public static void main(String args[]) {
		Deque<Integer> d = new ArrayDeque<Integer>(); //덱 선언
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine()); //명령어 수 입력 받음
		for(int i=0; i<n; i++) {
			String com = sc.next();
			switch(com) {
			case "push_front":
				int fInput = sc.nextInt();
				d.addFirst(fInput);
				break;
			case "push_back":
				int lInput = sc.nextInt();
				d.addLast(lInput);
				break;
			case "pop_front":
				if(d.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(d.removeFirst());
				}
				break;
			case "pop_back":
				if(d.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(d.removeLast());
				}
				break;
			case "size":
				System.out.println(d.size());
				break;
			case "empty":
				if(d.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				break;
			case "front":
				if(d.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(d.peekFirst());
				}
				break;
			case "back":
				if(d.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(d.peekLast());
				}
				break;
			}
		}
	}
}
