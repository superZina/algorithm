import java.util.*;
public class B5376 {
	public static long GCD(long A, long B) {
		long gcd = 1;
		long Max =0; long min =0;
		if(A > B) {
			Max = A; min = B;
		}else if(B>A) {
			Max = B;min = A;
		}else {
			Max = A ; min = B;
		}
		while(gcd > 0) {
			gcd = Max%min;
			if(gcd == 0) break;
			Max = min;
			min = gcd;
		}
		return min;
	}
	public static void getGCD(long a, long b) {
		if(b ==0) return;
		else getGCD(b,a%b);
	}
	
	public static void main(String[] args) {
		/*
		 solution:
		1) 순환소수가 아닐 때:
			"0." 떼고 남은 수랑 10^(소수자릿수)랑 약분해주면됨
		2) 순환소수일 때 :
			분모: 순환되는 자릿수만큼 9를 쓰고, 뒤에 순환 안되는 자릿수만큼 0을 채워준다
			분자: ("0."뗀 전체 수) - (순환안되는 수)
			약분은 gcd구해서 각각 나눠준다
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			String str = sc.next();
			String num = str.split("\\.")[1];
			if(num.contains("(")) {
				String[] nums = num.split("\\(|\\)");
				if(nums[0].equals("")) { //순환 안되는 수가 없을 때
					long len = nums[1].length();
					long a = Long.parseLong(nums[1]);
					long b = (long) (Math.pow(10,len) -1);
					long gcd = GCD(a,b);
					System.out.println(a/gcd+"/"+b/gcd);
				}else { //소수점 이하 숫자가 모두 순환되는 수 일 때 
					long len = nums[1].length();
					long notBLen = nums[0].length();
					String A = nums[0]+nums[1];
					long a = Long.parseLong(A);
					a -= Long.parseLong(nums[0]);
					long b = (long) ((Math.pow(10, len)-1)*(Math.pow(10, notBLen)));
					long gcd = GCD(a,b);
					System.out.println(a/gcd+"/"+b/gcd);
				}
			}else {
				//순환소수가 아닐 때 
				long len = num.length();
				long a = Integer.parseInt(num);
				long b = (long) Math.pow(10, len);
				long gcd = GCD(a,b);
				System.out.println(a/gcd+"/"+b/gcd);
			}
	}
	}
}
