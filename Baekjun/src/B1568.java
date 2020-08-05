import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class B1568 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		int num = 1;
		while(n!=0) {
			n -= num;
			count++;
			num++;
			if(num> n) {
				num = 1;
			}
		}
		System.out.print(count);
	}
}
