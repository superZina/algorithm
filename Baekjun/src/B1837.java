import java.math.BigInteger;
import java.util.*;
public class B1837 {
	public static boolean isPrime(int num) {
		if(num == 2) {
			return true;
		}else {
		for(int i =3; i<=Math.sqrt(num); i++) {
			if(num%i == 0) {
				return false;
			}
		}
		}
		return true;
	}
	public static boolean isDivided(int k , BigInteger P) {
		
		if(P.intValue()%k==0) {
			return true;
		}else
			return false; 
	}
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		String p = sc.next();
		int K = sc.nextInt();
		BigInteger P = new BigInteger(p);
		
		boolean isGood = true;
		for(int i =2 ; i<K; i++) {
				if(isPrime(i)) { //k 미만의 소수일 때 
					if(isDivided(i,P) && i !=K) { //k미만의 소수가 P를 나눌 수 있다면 
						isGood = false;
						System.out.println("BAD "+i);
						break;
					}else {
						isGood = true;
					}
				}
			}
		if( isGood) {
			System.out.print("GOOD");
		}
		}
		}
