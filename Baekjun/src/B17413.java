import java.util.*;
import java.io.*;
public class B17413 {
	public static void main(String[] args) throws IOException {
		//태그를 만나면 >가 나올 때 까지 뒤집지 않는다.
		//공백 기준으로 단어를 뒤집는다. 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		Stack<Character> s = new Stack();
		for(int i=0;i<text.length();i++) {
//			String word = Character.toString(text.charAt(i));
			if(text.charAt(i) == '<') {//태그일 때 
				while(!s.isEmpty()) {
					System.out.print(s.pop());
				}
//				System.out.print("<");
				for(int j = i;j<text.length();j++) {
					//">"이면 출력 중단. for문 중단
					System.out.print(text.charAt(j));
					if(text.charAt(j)=='>') {
						i = j; break;
					}
				}
			}else {//태그가 아닐 때
				if(text.charAt(i)==' ') {
					while(!s.isEmpty()) {
						System.out.print(s.pop());
					}
//					System.out.print(s.isEmpty());
					System.out.print(text.charAt(i));
				}else {
					s.push(text.charAt(i));
//					System.out.print(" !push! ");
					if(i==text.length()-1) {
						while(!s.isEmpty()) {
							System.out.print(s.pop());
						}
					}
				}	
			}
		}
	}
}
