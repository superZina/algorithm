import java.util.Scanner;

public class Btest {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int first = sc.nextInt();
	int A = first;
 //a가 10 이하이면은 뒤에 0을 하나 더 붙여줌
	int count =0;
	while(true) {
		int fstNum = A/10;
		int secNum = A%10;//두번째 자리수
		int newNum = (fstNum + secNum)%10;
		A = secNum*10 + newNum;
		count++;
		if( A == first) break;	
	}
	System.out.print(count);
	}
}
