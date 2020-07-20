import java.util.*;
public class B9550 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		for(int i=0 ; i<n; i++) {
			int child = 0;
			int Kind = sc.nextInt();
			int num = sc.nextInt();
			for(int j =0;j<Kind; j++) {
				int candy = sc.nextInt();
				child += candy/num;
			}
			System.out.println(child);
		}
	}
}
