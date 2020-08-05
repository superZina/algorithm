import java.util.*;
public class B1974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		Stack<Integer> s = new Stack();
		Stack<Integer> s1 = new Stack();
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
//			System.out.print(arr[i]+ " ");
			s1.push(n-i);
		}
		for(int i=arr.length-1; i>=0; i--) {
			//arr[i]와 같은 수가 나올 때 까지 밀어넣는다.
			//같은수 직전까지 밀어넣고, pop한담에 같은수를 넣는다. pop한 수들은 다른 스택에 밀어넣음.
			int count=0;
//			System.out.print(arr[i]+ " ");
//			System.out.println(s1.peek());
			while(s1.peek() == arr[i]) { 
				s.push(s1.pop());
				System.out.println("+");
				count++;
			}
			int tmp = s1.pop();
			for(int j=0; j<count; j++) {
				s.push(s1.pop());
				System.out.println("-");
			}
		}
		for(int i=0;i<s.size();i++) {
			System.out.print(s.pop()+ " ");
		}
	}
}
