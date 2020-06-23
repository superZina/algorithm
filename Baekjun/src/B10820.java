import java.util.Scanner;

public class B10820 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	while(sc.hasNext()) {
	String Text = sc.nextLine();
	int[] t = new int[Text.length()];
	
	for(int i=0; i<t.length;i++) {
		t[i] = Text.charAt(i);
	} //문자열 자르기

	int[] result = {0,0,0,0};
	
	for(int i =0; i<t.length ;i++) {
		if(t[i] >= 65 && t[i] <=90) { //대문자일때 (ASCII : 65~90)
			result[1] += 1;
		}else if(t[i] >= 97 && t[i] <=122) { //소문자일(ASCII : 97~122)
			result[0] += 1;
		}else if(t[i] == 32) { //공백일때(ASCII : 32)
			result[3] += 1;
		}else { //숫자일때
			result[2] += 1;
		}
	}
	
	for(int i=0;i<result.length; i++) {
		System.out.print(result[i]+" ");
		}
	System.out.println();
	}
	}
}
