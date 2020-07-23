import java.math.BigInteger;
import java.util.*;
public class B1837 {
	public static boolean[] isPrime(int num) {
		boolean[] prime = new boolean[num];
		for(int i=2 ; i<num;i++) {
			prime[i] = true;
		}
		prime[1] = false;
		for(int i=2; i<num; i++) {
			for(int j=2 ; i*j < num; j++) {
				prime[i*j] = false;
			}
		}
		return prime;
	}
	public static boolean isDivided(int k , String P) {
		char[] c = P.toCharArray();
		int p = 0;
		for( int i=0 ; i<P.length(); i++) {
			p = (p*10 + (P.charAt(i) -'0'))%k; 
		}
		if(p==0) {
			return true;
		}else
			return false; 
	}
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		String P = sc.next();
		int K = sc.nextInt();
//		BigInteger P = new BigInteger(p);
		boolean[] prime = isPrime(K);
		
		boolean isGood = true;
		for(int i =2 ; i<K; i++) {
				if(prime[i] && isDivided(i,P)) { //k 미만의 소수일 때
					isGood = false;
					System.out.println("BAD "+i);
					break;
				}
			}
		if( isGood) {
			System.out.println("GOOD");
		}
		}
		}



