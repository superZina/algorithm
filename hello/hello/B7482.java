import java.text.DecimalFormat;
import java.util.*;

public class B7482 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            double a = sc.nextDouble();
            double ans = a/6;
            
            DecimalFormat form = new DecimalFormat("#.000000000000000");
            // form.setMaximumFractionDigits(10);
        
            System.out.println(form.format(ans));
        }
    }
}