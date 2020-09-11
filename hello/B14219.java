import java.util.*;

public class B14219 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        int square = y*x;
        square %= 6;
        square %= 3;
        if(square == 0) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
