import java.util.*;
public class B9507 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] test = new int[N];
		int[] test2 = new int[N];
		for(int i=0; i<N; i++) {
			test[i] = sc.nextInt();
			test2[i] = test[i];
		}
		Arrays.sort(test);
		int Max = test[N-1];
		long[] koong = new long[Max+1];
		for(int i=0; i<=Max ; i++) {
			if(i<2 ) {
				koong[i] = 1;
			}else if(i == 2) {
				koong[i] = 2;
			}else if(i == 3) {
				koong[i] = 4;
			}else {
				koong[i] = koong[i-1] + koong[i-2]+ koong[i-3]+ koong[i-4];
			}
		}
		for(int i=0; i<N; i++ ) {
			int j = test2[i];
			System.out.println(koong[j]);
		}
	}
}
