import java.io.*;
import java.util.*;
public class B2358 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] x  = new int[n];
		int[] y = new int[n];
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split(" ");
			x[i] = Integer.parseInt(s[0]);
			y[i] = Integer.parseInt(s[1]);
		}
		Arrays.sort(x);
		Arrays.sort(y);
		int[] xcount = new int[n];
		int[] ycount = new int[n];
		int count = 1;
		int res = 0;
		for(int i=1;i<n;i++) {
			
			if(x[i]==x[i-1]) {
				
//				System.out.println("x["+i+"] : "+x[i]+" , x ["+(i-1)+"] : "+x[i-1]+" ,count : "+count);
				if(count <2 ) {//같은개 2개 이상이면 더이상 추가하지 않는다
					count++;
				}
				if(i==n-1&&count==2) {
					res += 1;
				}
			}else {
				if(count==2) {
				res += 1;
				}
				count=1;
//				System.out.println("x["+i+"] : "+x[i]+" , x ["+(i-1)+"] : "+x[i-1]+" ,count : "+count);
			}
		}
		count = 1;
		for(int i=1;i<n;i++) {
			
			if(y[i]==y[i-1]) {
				
//				System.out.println("y["+i+"] : "+y[i]+" , x ["+(i-1)+"] : "+y[i-1]+" ,count : "+count);
				if(count <2 ) {//같은개 2개 이상이면 더이상 추가하지 않는다
					count++;
				}
				if(i==n-1&&count==2) {
					res += 1;
				}
				
			}else {
				if(count==2) {
				res += 1;
				}
				count=1;
//				System.out.println("y["+i+"] : "+y[i]+" , x ["+(i-1)+"] : "+y[i-1]+" ,count : "+count);
			}
		}
		System.out.print(res);
	}
}
