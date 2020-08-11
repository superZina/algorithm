import java.io.*;
import java.util.*;
public class B1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String[] name = text.split("");
		
		
		
		//홀수인 알파벳이 2개이상이면 팰린드롬만들지 못함.
		int[] alph = new int[30];
		int count = 0;
		for(int i=0; i< text.length(); i++) {
			alph[text.charAt(i)-'A']++;
		}
		
		for(int i=0; i< text.length(); i++) {
			if(alph[i]%2==1) {
				count++;
			}
		}
		if(count>1) {
			System.out.println("I'm Sorry Hansoo");
		}
		Arrays.sort(name);
		char[] pelin = new char[name.length];
		
		int midIdx = 0;
		
		int pelinIdx = 0;
		for(int i=0; i<alph.length; i++) {
			//알파벳 개수가 짝수일 때
			//짝수이고 2개이상일 때
			if(alph[i]%2==0) {
				int alcount = alph[i]/2;
				for(int j=0; j<alcount; j++) {
					pelin[pelinIdx] = (char) (i+'A');
					pelin[pelin.length-1-pelinIdx] = (char) (i+'A');
					pelinIdx++;
				}
			}else {
				int alcount = alph[i]/2;
				for(int j=0; j<alcount; j++) {
					pelin[pelinIdx] = (char) (i+'A');
					pelin[pelin.length-1-pelinIdx] = (char) (i+'A');
					pelinIdx++;
				}
				midIdx = i;
			}
			// 홀수일 때
		}
		
		for(int i=0;i<name.length ; i++) {
			if(pelin[i] == '\u0000' ) {
				pelin[i] = (char) (midIdx+'A');
			}
		}
		if(count<=1) {
			for(int i=0;i<name.length ; i++) {
				System.out.print(Character.toString(pelin[i]));
			}
			System.out.println();
		}
	}
}
