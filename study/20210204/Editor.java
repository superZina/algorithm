import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Editor {
	public static void main(String args[]) throws IOException {
		Stack Left = new Stack();
		Stack Right = new Stack();
		int num; String st , input;
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		st = sc.readLine();
		for(int i=0 ;i<st.length() ; i++) {
			Left.add(st.charAt(i));
		}
		StringTokenizer nt;
		num = Integer.parseInt(sc.readLine());
		for(int i=0; i< num; i++) {
			input = sc.readLine();
			nt = new StringTokenizer(input);
			switch(nt.nextToken()) {
			case "L": 
				if(Left.isEmpty()) break;
				Right.add(Left.pop());
				break;//O(1)
			case "D":
				if(Right.isEmpty()) break;
				Left.add(Right.pop());
				break;
			case "B":
				if(Left.isEmpty()) break;
				else Left.pop();
				break; 
			case "P":
				String M = nt.nextToken();
				Left.add(M);
				break;	
			}
		}
		for(int i=0; i<Left.size(); i++) {
			System.out.print(Left.get(i));
		}
		for(int i=Right.size()-1 ; i>= 0; i--) {
			System.out.print(Right.get(i));
		}
	}
}
