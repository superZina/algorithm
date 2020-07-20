import java.util.*;
public class B6588 {
	public static boolean isPrime(long num) {
		for(long i =2; i<=Math.sqrt(num); i++) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void prime(long num) {
		long Maxi = 0;long Maxj = 0; int Max = -999999; 
		for(long i=2; i<num; i++) {
			if( i%2 != 0 && isPrime(i)) {
			 //소수일 때 
				long j = num - i;
				if(j%2 != 0 && isPrime(j) && j!= 1) {
					
					System.out.println(num+" = "+i+" + "+j);
					break;
				}
			}
		}
		
	}
	public static void main(String[ ]args) {
		Scanner sc = new Scanner(System.in);
		long n = 1;
		while(n != 0) {
			n = sc.nextInt();
			prime(n);
		}
		
	}
}
