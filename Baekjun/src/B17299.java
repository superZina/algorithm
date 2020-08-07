import java.io.*;
import java.util.Stack;
public class B17299 {
	public static void main(String[] args) throws  NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] text = br.readLine().split(" ");
		int[] arr = new int[1000001];
		int[] F = new int[1000001];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(text[i]);
			F[arr[i]]++;
		}
		int[] NFG = new int[1000001];
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		for(int i=1;i<n;i++) {
			if(s.isEmpty()) {
				s.push(i);
			}
			while(!s.isEmpty()&&F[arr[s.peek()]]<F[arr[i]]) {
//				System.out.print("dfdf");
				NFG[s.peek()] = arr[i];
				s.pop();
			}
			s.push(i);
		}
		while(!s.isEmpty()) {
			NFG[s.peek()] = -1;
			s.pop();
		}
		for(int i=0;i<n;i++) {
			System.out.print(NFG[i]+" ");
		}
	}
}
