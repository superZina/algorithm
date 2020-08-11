import java.util.*;
import java.io.*;
public class B6124 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] grass = new int[row][col];
		for(int i=0;i<row; i++) {
			for(int j=0;j<col;j++) {
				grass[i][j] = sc.nextInt();
			}
		}
		
//		for(int i=0;i<row; i++) {
//			for(int j=0;j<col;j++) {
//				System.out.print(grass[i][j]);
//			}
//			System.out.println();
//		}
		int max = -1;
		int maxR = 0;
		int maxC = 0;
		for(int i=0; i<row-2; i++) {
			for(int j=0; j<col-2; j++) {
				int sum = grass[i][j]+grass[i][j+1]+grass[i][j+2]+
						grass[i+1][j]+grass[i+1][j+1]+grass[i+1][j+2]+
						grass[i+2][j]+grass[i+2][j+1]+grass[i+2][j+2];
				if(sum>max) {
					max = sum;
					maxR = i;
					maxC = j;
				}
			}
		}
		System.out.println(max);
		System.out.println((maxR+1)+" "+(maxC+1));
	}
}
