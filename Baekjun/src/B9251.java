import java.util.*;
public class B9251 {
	public static int LCS(String word1, String word2) {
		int len = 0;
		int count =-1;
		for(int i=0; i<word1.length(); i++) {
			
			for(int j = count+1; j<=i; j++) {
				if(word1.charAt(i) == word2.charAt(j)) {
					count = j;
					len++;
//				System.out.println("word1 : "+word1.charAt(i));
//				System.out.println("word2 : "+word2.charAt(j));
				}else continue;
			}
		}
		return len;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word1 = sc.next();
		String word2 = sc.next();
		int len1 = LCS(word1, word2);
		int len2 = LCS(word2,word1);
		int lcs = Math.max(len1, len2);
		System.out.print(lcs);
	}
}
//길이가 다를 때 고려하기