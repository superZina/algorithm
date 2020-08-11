import java.io.*;
import java.util.*;
public class B3486 {
	public static String Mapping(String word) {
		String decode = "";
		switch(word) {
		case "AA":
			decode = "A";
			break;
		case "GG":
			decode = "G";
			break;
		case "CC":
			decode = "C";
			break;
		case "TT":
			decode = "T";
			break;
			
		case "AG":
			decode = "C";
			break;
		case "AC":
			decode = "A";
			break;
		case "AT":
			decode = "G";
			break;
		case "GA":
			decode = "C";
			break;
		case "GC":
			decode = "T";
			break;
		case "GT":
			decode = "A";
			break;
		case "CA":
			decode = "A";
			break;
		case "CG":
			decode = "T";
			break;
		case "CT":
			decode = "G";
			break;
		case "TA":
			decode = "G";
			break;
		case "TG":
			decode = "A";
			break;
		case "TC":
			decode = "G";
			break;	
		}
		return decode;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String text = br.readLine();
		String two = "";
		String decoded = "";
		String[] s = text.split("");
		int len = text.length()-1;
		while(len!=1) {
			
			two = s[len-1]+ s[len];
			System.out.println("two : "+two);
//			two = Character.toString(text.charAt(text.length()-2))+ Character.toString(text.charAt(text.length()-1));
			
			decoded = Mapping(two);
			len--;
			s[len] = decoded;
		}
		System.out.print(s[0]);
	}
}
