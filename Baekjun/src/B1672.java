import java.io.*;
import java.util.Stack;
public class B1672 {
//	public static int Reverse(String)
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Character> s = new Stack();
		for(int i=0;i<n;i++) {
			String[] nums = br.readLine().split(" ");
//			System.out.println(nums[0]);
//			System.out.println(nums[1]);
			String num1 = "";
			String num2 = "";
			int res = 0;
			for(int j=0;j<2;j++) {
				for(int k=0;k<nums[j].length(); k++) {
//					System.out.print(nums[j].charAt(k));
					s.push(nums[j].charAt(k));
				}
				while(!s.isEmpty()) {//뒤집기
					num1 += Character.toString(s.pop());
				}
//				System.out.println("rev : "+num1);
				res += Integer.parseInt(num1);
				num1 = "";
			}
			num2 = Integer.toString(res);
			for(int k=0;k<num2.length(); k++) {
				s.push(num2.charAt(k));
			}
			String ans = ""; 
			while(!s.isEmpty()) {//뒤집기
				ans += s.pop();
			}
			System.out.println(Integer.parseInt(ans));
		}
	}
}
