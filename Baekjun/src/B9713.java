import java.util.Scanner;

public class B9713 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i=0;i<num;i++) {
			int input = sc.nextInt();
			int result =0;
			for(int j=1;j<=input;j++) {
				if(j%2!=0) result+= j;
				else continue;
			}
			System.out.println(result);
		}
	}
}
