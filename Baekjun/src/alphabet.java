
import java.util.Scanner;

public class alphabet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		String word = sc.nextLine();
		int[] Word = new int[word.length()];
		
		for(int i=0;i<word.length() ; i++) {
			Word[i] = word.charAt(i);
		}
		
		int[] C = new int[26];
		int[] B = new int[26];
		
		for(int i=0;i<26;i++) {
			C[i] = -1;
		}
		
		for(int i=0;i<Word.length ; i++) {
			B[Word[i] - 'a'] += 1;
			if(B[Word[i] - 'a'] > 1) {continue;}
			else {C[Word[i] - 'a'] = i;}
		
		}
		
		for(int i=0 ; i<C.length ; i ++) {
		System.out.print(C[i]);
		System.out.print(" ");
		}
	}
}

