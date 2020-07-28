import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class B14502 {
	static LinkedList<Point> safe = new LinkedList<>(); 
	static int[][] lab;
	static class Point{
		int x;
		int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y; 
		}
	}
	static int[] dx = {-1, +1 , 0 ,0 };
	static int[] dy = {0,0,-1,+1};
	
	static public int go(Queue<Point> que ,int[][] tmpLab) {
		int[][] Lab = tmpLab;
		for(int i=0; i<lab.length; i++) {
			for(int j=0; j<lab[0].length ; j++) {
				Lab[i][j] = tmpLab[i][j];
			}
		}
		Queue<Point> queue = que;
		while(!queue.isEmpty()) {
			Point s = que.poll();
			int x= s.x;
			int y = s.y;
			for(int i=0;i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				//범위를 넘어가면 패스 
				//다음 자리가 1이면 패스 
				if(nx<0 || nx>= lab.length||ny <0 || ny>=lab[0].length) continue;
				else {
					if(Lab[nx][ny] != 0) continue;
					queue.add(new Point(nx,ny));
					Lab[nx][ny] = 2;
				}
			}
		}
		
		
		int result =0 ;
		for(int i=0; i<lab.length ; i++) {
			for(int j=0; j<lab[0].length ; j++) {
				if(tmpLab[i][j] == 0) {
					result++;
				}
			}
		}
		return result; 
	}
	static public int bfs( Point A, Point B , Point C) {
		int[][] tmpLab = new int[lab.length][lab[0].length];
		for(int i=0; i<lab.length; i++) {
			for(int j=0; j<lab[0].length ; j++) {
				tmpLab[i][j] = lab[i][j];
			}
		}
		//벽을 세워준다. 
		tmpLab[A.x][A.y] = 1;
		tmpLab[B.x][B.y] = 1;
		tmpLab[C.x][C.y] = 1;
//		for(int i=0; i<lab.length; i++) {
//			for(int j=0; j<lab[0].length ; j++) {
//				System.out.print(tmpLab[i][j]+ " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		int res = 0;
//		System.out.println("A , x : "+A.x +" y : "+A.y);
//		System.out.println("B , x : "+B.x +" y : "+B.y);
//		System.out.println("C , x : "+C.x +" y : "+C.y);
		
//		System.out.println();
		Queue<Point> que = new LinkedList<>();
		for(int i=0; i<lab.length; i++) {
			for(int j=0; j<lab[0].length ; j++) {
				if(tmpLab[i][j] == 2) {
					que.add(new Point(i,j));
					res = go(que,tmpLab);
//					System.out.println(res);
				}
			}
		}
		return res;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		lab = new int[N][M]; 
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int tmp = sc.nextInt();
				if(tmp == 0 ) {
					safe.add(new Point(i,j)); //0인부분 저장 
				}
				lab[i][j] = tmp;
			}
		}
		int res = 0;
		int tmp = 0;
		for(int i=0;i<safe.size()-2;i++) {
			for(int j=i+1; j<safe.size()-1; j++) {
				for(int k = j+1; k<safe.size() ; k++) {
					tmp = bfs(safe.get(i),safe.get(j),safe.get(k));
					res = Math.max(res, tmp);
				}
			}
		}
		System.out.print(res);
	}
}
