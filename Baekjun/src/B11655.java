import java.util.Scanner;

public class B11655 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		char[] ROT = new char[text.length()];
		for(int i=0;i<text.length(); i++) {
			int input = text.charAt(i);
			if(input >= 65 && input <= 90) {//대문자
				if(input + 13 > 90) {
					int m = input + 13 - 91; //z넘어갈때 
					ROT[i] = (char) (65+ m) ;
				}else {
					ROT[i] = (char) (input + 13);
				}
			}else if(input >= 97 && input <= 122) { //소문자
				if(input + 13 > 122) {
					int m =input + 13 - 123; //z넘어갈때 
					ROT[i] = (char) (97 + m) ;
				}else {
					ROT[i] = (char) (input + 13);
				}
			}else {
				ROT[i] = (char) input;
			}
		}
		
		for(int i=0; i<ROT.length; i++) {
			System.out.print(ROT[i]);
		}
	}
}
