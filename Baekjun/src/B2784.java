import java.io.*;
import java.util.*;
public class B2784 {
	
	static String[] words;
	public static String isIn(int Idx,char c) { //몇번째 문자인지와 해당 문자를 넘겨줘서 문자열 배열중에 해당되는 단어가 있는지 판별한다. 
		String word="";
		for(int i=0;i<6;i++) {
			if(c ==words[i].charAt(Idx)) {
				word = words[i];
				break;
			}
		}
		return word;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 words = new String[6];
		for(int i=0; i<6;i++) {
			words[i] = br.readLine();
		}
		boolean isSorted = false;
		char[][] puzzle = new char[3][3];
		Arrays.sort(words);
		for(int i=0; i<6;i++) {
			puzzle[0] = words[i].toCharArray();
			String w = isIn(0,puzzle[0][2]);
			for(int j=0;j<6;j++) {
				if(w=="") continue;
				else break;
			}
//			System.out.println("w : "+ w);
			puzzle[1][2] = w.charAt(1);
			puzzle[2][2] = w.charAt(2);
			String w1 = isIn(2,puzzle[1][2]);
			if(w1=="")continue;
			else {
//				System.out.println("w1 : "+ w1);
				puzzle[1][0] = w1.charAt(0);puzzle[1][1] = w1.charAt(1);
				String w2 = isIn(2,puzzle[2][2]);
				puzzle[2][0] = w2.charAt(0);puzzle[2][1] = w2.charAt(1);
				break;
			}
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(puzzle[i][j]);
			}
			System.out.println();
		}
	}
}
