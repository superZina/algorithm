import java.util.*;
public class B1002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		for(int i=0;i<n;i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();
			double r3 = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2,2)); //두 점 사이의 거리
			int r4 = Math.abs(r2-r1); 
			if(r1+r2 > r3 && (x1 !=x2 || y1 != y2) && r3 >Math.max(r1, r2)) {//원이 외접하고 접점이 두개 
				System.out.println(2);
			}else if(r1+r2 == r3 && r3 >Math.max(r1, r2)) { //원이 외접하고 접점이 한개 
				System.out.println(1);
			}else if(r1+r2 < r3 && r3 >Math.max(r1, r2)) { //원이 외접하고 접점 0개
				System.out.println(0);
			}else if(r3 == r4 && r3 < Math.max(r1, r2) ) { //원이 내접하고 접점이 1개 
				System.out.println(1);
			}else if(r3 < r4) { //내접하지도 않을 때 
				System.out.println(0);
			}else if(x1==x2 && y1==y2 && r3 ==0 && r4 != 0) { //두 점의 위치가 같고 내접하지도 않을 때 
				System.out.println(0);
			}else if(r3<Math.max(r1, r2) && r4<r3){ //안에서 내접점이 2개일 
				System.out.println(2);
			}
			else {
				System.out.print(-1);
			}
		}
	}
}
