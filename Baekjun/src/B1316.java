
import java.util.Scanner;

public class B1316 {
	public static boolean Checkgroup(String word) {
		boolean[] Alp = new boolean[26];
		for(int i=0;i<word.length();i++) {
			if(Alp[word.charAt(i)-'a'] == false) { //이전에 존재하지 않던 문자일
				Alp[word.charAt(i)-'a'] = true;
			}else if(i!=0 && Alp[word.charAt(i)-'a']==true){ //이전에 존재하던 문자일 때
				if( word.charAt(i) != word.charAt(i-1)) {//연속된 거라면
					return false;
				}
			}
			
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int num = sc.nextInt();
		for(int i=0;i<num;i++) {
			String word = sc.next();
			boolean result = Checkgroup(word);
			if(result) count++;
		}
		System.out.print(count);
}
}
