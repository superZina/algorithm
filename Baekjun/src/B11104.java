import java.util.*;
public class B11104 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n; i++) {
			String bin = sc.next();
			long val =0;
			for(int j=0;j<bin.length();j++) {
				val += (bin.charAt(j)-'0')*Math.pow(2, bin.length()-j-1);
			}
			System.out.println(val);
		}
	}
}
