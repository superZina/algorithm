import java.io.*;
import java.util.Scanner;
public class Main {
    static int n;
    static boolean[] check_col;
    static boolean[] right_diag;
    static boolean[] left_diag;
    static int ans = 0 ;
    public static int cal(int row) {
        //종료조건 row == n
        if(row == n) {            
            return 1; 
        }else{
            //row의 각 col마다 검사
            int cnt = 0; 
            for(int i=0 ; i<n; i++) {
                if(check(row,i)) {
                    check_col[i] = true;
                    right_diag[i+row] = true;
                    left_diag[i-row+n] = true;
                    cnt += cal(row+1);
                    check_col[i] = false;
                    right_diag[i+row] = false;
                    left_diag[i-row+n] = false;
                }
            }
            return cnt;
        }
        
    }
    private static boolean check(int row, int i) {
        if(!check_col[i]&&!right_diag[i+row]&&!left_diag[i-row+n]) return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        check_col = new boolean[n];
        right_diag = new boolean[2*n];
        left_diag = new boolean[2*n];
        ans = cal(0);
        System.out.println(ans);
    }
}
