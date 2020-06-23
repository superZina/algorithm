import java.util.Scanner;

public class B9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i=0;i<num;i++) {
			int input = sc.nextInt();
			int[] R = new int[input+1];
			R[0] = 1;
			for(int j=1;j<=input;j++) {
				if(j-1 >=0) R[j] += R[j-1]; 
				if(j-2 >=0) R[j] += R[j-2]; 
				if(j-3 >=0) R[j] += R[j-3]; 
			}
			System.out.println(R[input]);
		}
	}
}
