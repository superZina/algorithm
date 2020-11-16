import java.util.*;
public class B18406 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        long N = sc.nextLong();
        String text = Long.toString(N);
        long left = 0;
        long right = 0;
        for(int i=0; i<text.length() ; i++) {
            if(i < text.length()/2) {
                left += text.charAt(i) - '0'; 
            }else {
                right += text.charAt(i) - '0'; 
            }
        }
        if( left == right ) {
            System.out.println("LUCKY");
        }else{
            System.out.println("READY");
        }
    }
}
