import java.util.*;
public class B1874 {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack();
		int max = 0;
		boolean able = true;
		ArrayList<Character> op = new ArrayList();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			if(num>max) { //지금까지 넣은 수 보다 크다면 
				for(int j=max+1;j<=num ;j++) {
					s.push(j); //그 수까지 넣는다. 
					op.add('+');
//					System.out.println("+");
				}
				max = num; //최댓값 바꿔줌
				s.pop(); //num 빼준다.
//				System.out.println("-");
				op.add('-');
			}else {
				if(num< s.peek()) { able = false;break;}
				else s.pop();
//				System.out.println("-");
				op.add('-');
			}
		}
		if(!able) {
			System.out.print("NO");
		}else {
			for(int i=0; i<op.size(); i++) {
				System.out.println(op.get(i));
			}
		}
	}
}
