import java.text.DecimalFormat;
import java.util.*;

public class B15610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        double x = Math.sqrt(a);
    
        double res = 4*x;
        DecimalFormat form = new DecimalFormat("#.#######");

        System.out.println(form.format(res));
    }
    
}
