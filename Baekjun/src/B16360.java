import java.util.*;
public class B16360 {
	public static void main(String[] args) {
		Map<String,String> dict = new HashMap<String,String>();
		dict.put("a", "as");
		dict.put("i", "ios");
		dict.put("y", "ios");
		dict.put("l", "les");
		dict.put("n", "anes");
		dict.put("o", "os");
		dict.put("ne", "anes");
		dict.put("r", "res");
		dict.put("t", "tas");
		dict.put("u", "us");
		dict.put("v", "ves");
		dict.put("w", "was");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i =0 ;i<n; i++) {
			String word = sc.next();
			String input = "";
			char last = word.charAt(word.length()-1);
			String ne = "";
			if(last == 'e' && word.charAt(word.length()-2)=='n') {
				ne = "ne";
				input = ne;
				String val = dict.get(input);
				word = word.substring(0,word.length()-2);
				word = word+val;
			}else {
				input = Character.toString(last);
				switch(input) {
				case "a":
				case "i":
				case "y":
				case "l":
				case "n":
				case "o":
				case "r":
				case "t":
				case "u":
				case "v":
				case "w":
					String val = dict.get(input);
					word = word.substring(0,word.length()-1);
					word = word+val;
					break;
				default:
					word = word+"us";
					break; 
				}
				
				
				
			}
			
			System.out.println(word);
			
		}
	}
}
