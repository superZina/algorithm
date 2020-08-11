import java.util.*;
import java.io.*;
public class B1699 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		for(int i=1;i<=n; i++) {
//			double pow = Math.pow(i, 2);
//			
//		}
		double pow = 0;
		int count = 0;
		while(n>0){
			int m = 1;
			while(pow<n) {
				pow = Math.pow(m,2);
				m++;
			}
			pow = Math.pow(m-2, 2);
//			System.out.println(pow);
			n -= pow;
			count++;
		}
		System.out.print(count);
		int[] arr = new int[n+1]; 
		for(int i=1 ; i<=n;i++) {
			arr[i]++;
		}
	}
}
