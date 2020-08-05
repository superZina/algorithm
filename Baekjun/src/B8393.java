import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class B8393 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String text = br.readLine();
			Stack s = new Stack();
			StringTokenizer st = new StringTokenizer(text," ");
			while(st.hasMoreTokens()) {
				String word = st.nextToken();
				for(int j=0; j<word.length(); j++) {
					s.push(word.charAt(j));
				}
				for(int j=0; j<word.length(); j++) {
					System.out.print(s.pop());
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
