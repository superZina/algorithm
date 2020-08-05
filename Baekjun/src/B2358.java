import java.io.*;
public class B2358 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] x  = new int[n];
		int[] y = new int[n];
		int[] inclineX = new int[n-1];
		int[] inclineY = new int[n];
		for(int i=0;i<n;i++) {
			x[i] = br.read();
			y[i] = br.read();
		}
		int count = 0;
		for(int i=0;i<n;i++) {
			for(int j=0; j<n; j++) {
//				if(i!=j) {
					if( x[i]==x[j] || y[i] == y[j]) {
						count++;
//					}
				}
			}
		}
		System.out.print(count);
	}
}
