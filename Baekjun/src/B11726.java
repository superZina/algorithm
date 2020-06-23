import java.util.Scanner;

public class B11726 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] R = new int[1000];
		R[0] = 1; R[1] = 2;
		int num = sc.nextInt();
		for(int i=2 ; i<num; i++) {
			R[i] = R[i-1] + R[i-2];
			R[i] %= 10007;
		}
		System.out.print(R[num-1]);
	}
}
