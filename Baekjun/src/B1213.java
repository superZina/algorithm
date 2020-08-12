import java.io.*;
import java.util.*;
public class B1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
//		String[] name = text.split("");
		
		
		
		//홀수인 알파벳이 2개이상이면 팰린드롬만들지 못함.
		int[] alph = new int[1000];
		int count = 0;
		for(int i=0; i< text.length(); i++) {
			alph[text.charAt(i)-'A']++;
		}
		int midIdx = -1;
		for(int i=0; i< text.length(); i++) {
			if(alph[i]>0) {
				if(alph[i]%2==1) {
				 	 count++;
				 	 alph[i]--;
				 	 midIdx = i;
				}
			}
		}
		
		String pel;
		Stack< Character> s;
		StringBuffer bf = new StringBuffer();
		if(count>1) {
			System.out.println("I'm Sorry Hansoo");
		}else {
			pel = "";
			s = new Stack();
			for(int i=0;i<alph.length;i++) {
				if(alph[i]>0) {
					for(int j=0;j<alph[i]/2;j++) {
						pel += (char) (i+'A');
					}
				}
			}
			String temp = pel;
			bf.append(temp);
			if(midIdx!= -1) {
				pel += (char)(midIdx + 'A');
			}
			pel += bf.reverse();
			System.out.println(pel);
		}
		
		
		
		
		
//		for(int i=0; i<alph.length; i++) {
//			//알파벳 개수가 짝수일 때
//			//짝수이고 2개이상일 때
//			if(alph[i]%2==0) {
//				int alcount = alph[i]/2;
//				for(int j=0; j<alcount; j++) {
//					pel += (char) (i+'A');
//					s.push((char) (i+'A'));
//				}
//			}else {
//				int alcount = alph[i]/2;
//				for(int j=0; j<alcount; j++) {
//					pel += (char) (i+'A');
//					s.push((char) (i+'A'));
//				}
//				midIdx = i;
//			}
//			// 홀수일 때
//		}
		
		
	}
}
