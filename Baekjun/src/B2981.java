import java.util.*;

public class B2981 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] numbers = new int[n]; 
		for(int i=0; i<n; i++) {
			int N = sc.nextInt();
			numbers[i] = N;
		}
		Arrays.sort(numbers);
		int gcd = numbers[n-1] - numbers[n-2];
		for(int i=2; i<=gcd; i++) {
			if(gcd % i == 0 ) {
				System.out.print(i+" ");
			}
		}
	}
}

