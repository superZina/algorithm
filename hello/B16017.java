import java.util.*;

public class B16017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int first = sc.nextInt();
        int sec = sc.nextInt();
        int third = sc.nextInt();
        int four = sc.nextInt();
        boolean isTele = false;
        if((first == 8 || first == 9 ) && ( four == 8 || four == 9) && (third == sec)) {
            isTele = true;
        }
        if(!isTele) {
            System.out.println("answer");
        }else{
            System.out.println("ignore");
        }
        
    }
}
