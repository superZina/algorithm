import java.util.*;

import com.sun.net.httpserver.Authenticator.Result;
public class B7569 {
	
	static class Point{
		int z;
		int x;
		int y;
		public Point(int z, int x, int y) {
			this.z = z;
			this.x = x;
			this.y = y;
		}
	}
	static int count =0;
	static int[][][] box;
	static boolean[][][] visited;
	static int[] dy = {0,0,-1,+1,0,0};
	static int[] dx = {-1,+1,0,0,0,0};
	static int[] dz = {0,0,0,0,+1,-1};
	static Queue<Point> queue = new LinkedList<>();
	public static int days() {
		while(!queue.isEmpty()) { //bfs이기 떄문에 큐가 빌 때 까지 반복 
			Point s = queue.poll();
			int z = s.z;
			int x = s.x;
			int y = s.y;
//			System.out.println("z : "+z+" x: "+x+" y: "+y);
			for(int i=0; i<6; i++) {
				int nz = z + dz[i];
				int nx = x + dx[i]; 
				int ny = y + dy[i];
//				System.out.println("nz : "+nz+" nx: "+nx+" ny: "+ny);
				//다음 자리가 범위를 넘어가면, 이미 익었다면, 빈자리라면 패스 
				if(nz < 0 || nz>= box.length || nx<0|| nx>=box[0].length|| ny<0||ny>= box[0][0].length) continue;
				else if(box[nz][nx][ny]!= 0) continue; 
				else {
					queue.add(new Point(nz,nx,ny));
					box[nz][nx][ny] = box[z][x][y] + 1; //이전 토마토값에 +1 
				}
			}//순회 완료 
		}
		int days = Integer.MIN_VALUE;
		for(int i=0;i<box.length;i++) {
			for(int j=0; j<box[0].length; j++) {
				for(int k=0;k<box[0][0].length; k++) {
					if(box[i][j][k] == 0) return -1; //0이 있다는 것은 하나도 익지 않은 토마토가 있다는 것. 
					days = Math.max(days, box[i][j][k]); 
				}
			}
		}
		if(days == -1) return 0;
		else return days -1 ;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int H = sc.nextInt();
		box = new int[H][N][M];
		visited = new boolean[H][N][M];
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					box[i][j][k] = sc.nextInt();
					if(box[i][j][k] ==1) {
//					System.out.println("z : "+i+" x: "+j+" y: "+k);
						queue.add(new Point(i,j,k));
					}
				}
			}
		}
//		System.out.print(box.length); //z 크기
//		System.out.print(box[0].length); //y크기
//		System.out.print(box[0][0].length); //x 크기
		
		System.out.println(days());
//		for(int i=0;i<H;i++) {
//			for(int j=0;j<N;j++) {
//				for(int k=0;k<M;k++) {
//					System.out.print(box[i][j][k]+ " ");
//				}
//				System.out.println();
//			}
//		}
	}
}
