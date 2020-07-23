import java.util.*;
public class B17070 {
	static int count = 0;
	public static void GO(int[][] arr , int ix, int iy, int jx, int jy) {
		System.out.println("ix : "+ ix+" iy: "+iy);
		System.out.println("jx : "+ jx+" jy: "+jy);
		System.out.println();
		
		//1. 종료조건 : 파이프의 끝이 배열의 끝에 다다르면 종료한다.
		//2. 종료조건 : 파이프의 끝이 (N,N)에 다다르면 종료한다.  
		//3. 종료조건 : 파이프의 끝이 벽이랑 마주치면 종료한다.
		if(jx > arr.length-1 || jy > arr.length-1) {
			return;
		}else if(jx==jy &&jx == arr.length -1 && jy == arr.length-1) {
			count++;
			return;
		}else if(arr[jx][jy]== 1) {
			return;
		}else {
		
		//벽이 있으면 다른 방법으로 간다. 
		//파이프가 가로로 놓여있을 때 
		if(jy == iy +1 && jx==ix) {
			GO(arr, ix, iy+1, jx, jy+1); //가로 
			GO(arr,ix, iy+1, jx+1, jy+1); //대각선 
		}else if(jy == iy && jx ==ix +1) {//파이프가 세로로 놓여있을 때
			GO(arr, ix+1, iy , jx+1 , jy); //세로 
			GO(arr,ix, iy+1, jx+1, jy+1); //대각선
		}else if(jy == iy +1 && jx == ix +1 ) {
			GO(arr, ix, iy+1, jx, jy+1); //가로 
			GO(arr, ix+1, iy , jx+1 , jy); //세로 
			GO(arr,ix, iy+1, jx+1, jy+1); //대각선
		}
		}
//		GO(arr, ix, iy+1, jx, jy+1);
		//파이프가 대각선으로 놓여있을 때 
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0 ; j<n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		GO(arr, 0,0,0,1);
		System.out.print(count);
	}
}
