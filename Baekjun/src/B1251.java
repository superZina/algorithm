import java.util.*;
public class B1251 {
	static int len;
	static int[] w;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		ArrayList<String> revWords = new ArrayList<String>();
		
		String[] part = new String[3];
//		part[0] = word.substring(0,2);
//		part[1]= word.substring(2,word.length()-2);
//		part[2]= word.substring(word.length()-2,word.length());
//		for(int i=0;i<3; i++) {
//			System.out.println(part[i]);
//			String reversed = "";
//			for(int j=part[i].length()-1; j>=0; j--) {
//				
//				char rev = part[i].charAt(j);
//				reversed += Character.toString(rev) ;
//			}
//			part[i] = reversed;
//			System.out.println(part[i]);
//		}
//		word = part[0] + part[1] + part[2];
//		
		for(int i=1; i<word.length()-2;i++) {
			String revWord = "";
			for(int j=i+1; j<word.length(); j++) {
				part[0] = new StringBuffer( word.substring(0,i)).reverse().toString();
				part[1] = new StringBuffer(word.substring(i,j)).reverse().toString();
				part[2] = new StringBuffer(word.substring(j,word.length())).reverse().toString();
//				System.out.println(part[0]);
//				System.out.println(part[1]);
//				System.out.println(part[2]);
				revWord = part[0] + part[1] + part[2];
//				System.out.println(revWord);
				revWords.add(revWord);
			}
		}
		Collections.sort(revWords);
		System.out.print(revWords.get(0));
		
//		
	}
}
