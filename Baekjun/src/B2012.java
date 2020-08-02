import java.util.*;
public class B2012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] expect = new int[n+1];
		int[] actual = new int[n+1];
		boolean[] arr = new boolean[n+1];
		for(int i = 1; i<=n; i++) {
			expect[i] = sc.nextInt();
		}
		Arrays.sort(expect);
		int count = 1;
		for(int i=1;i<=n; i++) {
			if(i == 1) {
				arr[expect[i]] = true;
			}else {
				if(expect[i-1] == expect[i]) continue;
				else {
					arr[expect[i]] = true;
				}
			}
		}
		for(int i=1;i<=n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
