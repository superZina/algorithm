import java.util.*;
public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextInt();
		long y = sc.nextInt();
		int straight = sc.nextInt();
        int root = sc.nextInt();
        long min = Math.min(x, y);
        long time = 0;
        if(x==0 || y == 0) {
            time = (x+y)*straight;
        }else{
         //대각선으로만 이동할 수 있을 때 
            long walk = (x+y)*straight; //평행선으로만 걸을 떄 
            long walk2 =  Math.min(x, y)*root +(Math.max(x, y)-Math.min(x, y))*straight; //대각선 최대로 걸을 떄 
            long walk3 = (Math.max(x, y)-((x+y)%2))*root + (x+y)%2*straight; //대각선으로만 걸을 떄
            time = Math.min(walk, Math.min(walk2, walk3));
        }
     System.out.println(time);
    //  System.out.println("walk : "+walk+" walk2 : "+walk2+" walk3 : "+walk3);
        
    }
}