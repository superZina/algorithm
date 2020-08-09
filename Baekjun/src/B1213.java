import java.io.*;
import java.util.*;
public class B1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] name = br.readLine().split("");
		Arrays.sort(name);
		
		String[] pelin = new String[name.length];
		int count = 0;
		int Idx = 0;
		boolean isAble = true;
		String last = "";
		for(int i=0;i<name.length;i+=2) {
			if(i<name.length-1 && !name[i].equals(name[i+1])) {
//				System.out.println("name["+i+"] : "+name[i]+" name["+(i+1)+"] : "+name[i+1]);
				last = name[i];
				
				count++;
				if(count>1) {
//					System.out.println("I'm Sorry Hansoo");
					isAble = false;
					break;
				}else {
					if(i+1 == name.length-1) {
//						System.out.println("I'm Sorry Hansoo");
						isAble = false;
						break;
					}else {
						i--;
						continue;
					
					}
				}
			}else{
				pelin[Idx] = name[i];
				pelin[pelin.length-1-Idx] = name[i];
				Idx++;
			}
		}
		
//		System.out.println();
//		System.out.println("last : "+last);
		for(int i=0;i<name.length ; i++) {
			if(pelin[i]==null) {
				pelin[i] = last;
			}
		}
		if(isAble) {
			for(int i=0;i<name.length ; i++) {
				System.out.print(pelin[i]);
			}
		}else {
			System.out.println("I'm Sorry Hansoo");
		}
	}
}
