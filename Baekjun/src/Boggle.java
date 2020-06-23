import java.util.*;
public class Boggle {

	static char[][] grid = new char[5][5];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCount = sc.nextInt();
				
		for(int i=0; i < testCount ; i++) {

			//격자 만들기
			for(int j =0; j<5 ;j++) {
				String text = sc.next();
				for(int k =0; k<5; k++) {
					grid[j][k] = text.charAt(k);
					
					}
				}
			}
		
		for(int j =0 ; j<5;j++) {
			for(int k=0;k<5;k++) {
				System.out.print(grid[j][k] + " ");
			}
			System.out.println();
		}
		
		int wordCount = Integer.parseInt(sc.next());
		for(int j=0;j<wordCount; j++) {
			String word = sc.next();
			boolean ret = false;
			for(int y = 0; y<5; y++ ){
				for(int x = 0; x<5 ; x++) {
					ret = search(y,x,word,0);
					if (ret == true ) {
						System.out.println();
						System.out.println(word);
						
						break;
					}
				}
			}
		}

	}
	
	static int[] dx = {-1,0,1,1,1,0,-1,-1};
	static int[] dy = {-1,-1,-1,0,1,1,1,0};
	public static boolean search(int x,int y ,String word, int idx) {
		//글자가 일치한다면 해당 단어를 첫문자부터 줄여가며 비교해갈 것임
		//2.첫번째 글자가 일치하지 않으면 종료
		//1.인덱스 범위를 넘어가면 종료
		//3. count가 주어진 단어의 문자 개수가 같으면 종료
		
		//1
		if(x<0 || x>4 || y<0 || y>4) {
			return false;
		}
		
		//2
		if(grid[x][y] != word.charAt(idx)) {
			return false;
		}
		//3 
		if (word.length() == 0) return true;
		System.out.print(grid[x][y]);
		System.out.println();
		//인접한 8개의 문자를 검사
		for(int dir =0; dir<8; dir++) {
			int nextX = x + dx[dir];
			int nextY = y + dy[dir];
			if(search(nextX , nextY, word , idx+1)) {
				return true;
			}
		}
		return false;
		
	}

}
