

import java.util.Arrays;
import java.util.Scanner;
public class B1449 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int points = sc.nextInt(); 
        int len = sc.nextInt();
        
        int[] point = new int[points];
        for(int i=0; i<points; i++) {
            point[i] = sc.nextInt();
        }
        Arrays.sort(point);
        boolean[] iscovered = new boolean[10001];
        for(int i=0; i<iscovered.length; i++ ) {
            iscovered[i] = false;
        }
        
        
        int count = 0;
        for(int i = 0; i<points; i++) {
            // System.out.println(point[i]); 
            if(!iscovered[point[i]]) {//덮여있지 않다면
                for(int j = point[i] ; j< point[i] + len; ++j ) { //해당 지점부터 테이프길이까지 붙인다

                    iscovered[j] = true;
                    // System.out.println(j+ " is covered");
                }
                count++;
            }
        }
        System.out.println(count);
    }
}
