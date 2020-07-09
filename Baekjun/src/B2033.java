import java.util.*;
public class B2033 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long num = sc.nextInt();
		int start = 10;
		while(num > start) {
			if(num%start >= 5*(start/10) ) {
				num += (start - num%start);
				start *= 10;
			}else {
				num -= num%start;
				start *= 10;
			}
			
		}
		System.out.println(num);
	}
}
