import java.util.*;
public class B2959 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		int[] square = new int[4];
		for(int i=0; i<4; i++) {
			square[i] = sc.nextInt();
		}
		Arrays.sort(square);
//		for(int i=0; i<4; i++) {
//			System.out.print(square[i]+ " ");
//		}
//		int first = square[3];
		int sec = square[0];
		int thd = Math.max(square[1], square[2]);
//		int fou = Math.min(square[1], square[2]);
		int sq = thd*sec;
		System.out.print(sq);
	}

}
