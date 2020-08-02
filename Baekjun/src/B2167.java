import java.util.*;
public class B2167 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N+1][M+1];
		for(int i=1;i<= N; i++) {
			for(int j=1; j<=M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int n = sc.nextInt();
		for(int k=0;k<n; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int res = 0;
			for(int a = i; a<=x; a++) {
				for(int b = j; b<=y; b++) {
//					System.out.println("a : "+ a+ " b : " + b );
					res += arr[a][b];
				}
			}
			System.out.println(res);
		}
	}

}
