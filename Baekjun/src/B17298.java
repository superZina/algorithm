import java.util.*;
import java.io.*;
public class B17298 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		int[] arr = new int[n];
		int[] NGE = new int[n];
		s.push(0);
		String[] temp = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(temp[i]);;
		}
		for(int i=1; i< n; i++) {
			if(s.isEmpty()) {
				s.push(i);
			}
			while(!s.isEmpty()&&arr[s.peek()]<arr[i]){
				NGE[s.peek()] = arr[i];
				s.pop();
				}
			s.push(i);
		}
		
			while(!s.isEmpty()) {
				NGE[s.peek()] = -1;
				s.pop();
			}
		for(int i=0 ; i<n; i++) {
			System.out.print(NGE[i]+" ");
		}
	}
}
