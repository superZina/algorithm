import java.util.*;
public class B10263 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] block = new int[n][100];
		for(int i=0; i<n; i++) {
			int b = sc.nextInt();
			for(int j=0; j<b; j++) {
				block[i][j] = 1;
			}
		}
		int count = 0;
		while(true) {
			int wMax = 0;
			int hMax = 0;
			int wIdx = 0;
			int hIdx = 0;
			int[] width = new int[n];
			int[] height = new int[100];
			//1.가로에서 max찾기 (max인 부분 저장) 
			for(int i=0;i<block.length;i++) {
				int wVal = 0;
				for(int j=0;j<block[i].length; j++) {
					wVal += block[i][j];
				}
				width[i] = wVal;
				if(wVal > wMax) {
					wMax = wVal;
					wIdx = i;
				}
			}
			//2.세로에서 max찾기 (max인 부분 저장) 
			for(int j =0 ; j<block[0].length; j++) {
				int hVal = 0;
				for(int i=0;i<block.length; i++) {
					hVal += block[i][j];
				}
				height[j] = hVal;
				if(hVal > hMax) {
					hMax = hVal;
					hIdx = j;
				}
			}
			
			//가로 세로 합 구하기
			int w = 0;
			for(int i=0;i<width.length; i++) {
				w += width[i];
			}
			int h = 0;
			for(int j=0;j<height.length;j++) {
			h += height[j];
			}
			if(w == 0 && h == 0) {
				break;
			}
			
			if( wMax > hMax ) { //가로에서 최대가 나왔다면
					for(int j=0;j<block[wIdx].length; j++) {
						block[wIdx][j] = 0;
						//전부 0으로 바꿔주기
				}
				count++;
			}else {//세로에서 최대가 나온다면
					for(int i=0;i<block.length; i++) {
						block[i][hIdx] = 0;
				}
				count++;
			}
			
			
		}
		System.out.print(count);
	}
}
