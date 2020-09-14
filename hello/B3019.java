import java.util.*;public class B3019 {
    public static boolean isAble(int[][] board){
        boolean isable = true;
        for(int i=0; i<board.length; i++) {
            for(int j=0 ;j<101;j++) {
                if(j != 0 && board[i][j] == 1 && board[i][j-1] == 0){ //현재칸에 블록이 있는데 이전칸에 블록이 없다면 불가능
                    isable = false;
                }
            }
        } 
        return isable;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int block = sc.nextInt();
        int[][] board = new int[C][101];
        for(int i=0; i<C; i++){
            int n = sc.nextInt();
            for(int j=0; j<n;j++){
                board[i][j] = 1;
            }
        }
        switch(block) {
            case 1:
                //눕혀서
            break;
            case 2:
            break;
            case 3:
            break;
            case 4:
            break;
            case 5:
            break;
            case 6:
            break;
            case 7:
            break;
        }
    }
    
}
