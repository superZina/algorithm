import java.util.Scanner;
public class B10824 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] num = new long[100];
		for(int i=0; i<2; i++){
			String s = sc.next() + sc.next();
			num[i] = Long.parseLong(s);
		}
		long result = num[0] + num[1];
		System.out.println(result);

	}
}
