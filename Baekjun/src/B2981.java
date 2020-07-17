import java.util.*;
public class B2981 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] numbers = new int[n];
		int min = 1000;
		for(int i=0; i<n; i++) {
			int N = sc.nextInt();
			numbers[i] = N;
			if(N < min) {
				min = N;
			}
		}
		for(int i=2; i<=min; i++) {
			int n1 = numbers[0]%i;
			int n2 = numbers[1]%i;
			int n3 = numbers[2]%i;
			if(n1 == n2 && n2==n3) {
				System.out.print(i + " ");
			}
		}
	}
}
