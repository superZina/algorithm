import java.util.*;
public class B2872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] book = new int[n+1];
		int[] tmp = new int[n+1];
		for(int i=1 ; i<n+1; i++) {
			book[i] = sc.nextInt();
			tmp[i] = book[i];
		}
		boolean isSorted = false;
		Arrays.sort(tmp);
		int count = 0;
		while(true) {
			if(isSorted) break;
			int top = book[1];
			int idx=0;
			for(int i=2;i<book.length;i++) {
				if(top == book[i]+1) {
//					book[1] = book[i];
					idx = i;
				}
			}
			book[1] = book[idx];
			for(int j =1;j<idx;j++) {
				book[j+1] = book[j];
			}
			for(int i =1; i<book.length ; i++) {
				if(book[i] == tmp[i]) continue;
				if(i == book.length-1 && book[i]==tmp[i]) {
					isSorted = true;
				}
			}
			count++; 
		}
		System.out.print(n-1);
	}
}
