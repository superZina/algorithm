import java.io.*;
import java.util.*;
public class B10799 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		Stack<Character> s =new Stack();
		int count=0;
		for(int i=0;i<line.length();i++) {
			if(line.charAt(i) == '(') {
				if(line.charAt(i+1)==')') {
					if(!s.isEmpty()) {//레이저일 경우 push하지 않고 막대개수 증가시킨다   
						count += s.size();
					}
				}else { //레이저가 아니면 막대기 추가 
					s.push(line.charAt(i));
				}
			}
			else if(line.charAt(i)==')') {
				if(line.charAt(i-1)=='(') continue;//레이저일 경
				else {
					s.pop();
					count++;
				}
			}
		}
		System.out.print(count);
	}
}
