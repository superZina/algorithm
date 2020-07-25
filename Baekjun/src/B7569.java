import java.util.*;
public class B7569 {
	static int count =0;
	static boolean[][][] visited;
	public static void days(int[][][] box,int y, int x, int z) {
		System.out.println("x : "+x+", y : "+y+", z : "+z);
		if(z<0||x<0||y<0||y >= box.length || x >= box[0].length || z >= box[0][0].length) return;
		else if(visited[y][x][z] ||box[y][x][z] ==-1) return;
		else {
			box[y][x][z] = 1;
			visited[y][x][z] = true;
			
//			System.out.println("count++");
			//앞, 뒤, 양옆 토마토 익음
			//양 옆 
			days(box,y,x-1,z);
			days(box,y,x+1,z);
			days(box,y-1,x,z);
			days(box,y+1,x,z);
			//앞, 
			days(box,y,x,z+1);
			days(box,y,x,z-1);
			
		}
		
		count++;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int H = sc.nextInt();
		int[][][] box = new int[N][M][H];
		visited = new boolean[N][M][H];
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					box[j][k][i] = sc.nextInt();
					visited[j][k][i] = false;
				}
			}
		}
//		System.out.print(box.length); // N 크기
//		System.out.print(box[0].length); //M크기
//		System.out.print(box[0][0].length);
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
//					System.out.print(box[j][k][i]+ " ");
					if(box[j][k][i] ==1) {
						days(box,j,k,i);
					}
				}
			}
		}
		System.out.print(count);
		
	}
}
