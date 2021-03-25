import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.io.*;


public class Main {
    static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
    public static int calc(int[] a, int[] b) {
        int n = a.length;
        int ans = a[0];
        for(int i= 1; i<n; i++) {
            if(b[i-1] == 0 ) {
                ans += a[i];
            }else if(b[i-1] == 1 ) {
                ans -= a[i];
            }else if(b[i-1] == 2 ) {
                ans *= a[i];
            }else{
                ans /= a[i];
            }
        }
        return ans;
    }
public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    int[] b = new int[n-1];
    String[] inputs = br.readLine().split(" ");
    for(int i=0 ; i<n; i++) {
        a[i] = Integer.parseInt(inputs[i]);
    }

    inputs = br.readLine().split(" ");
    int idx = 0 ;
    for(int i=0 ; i<4; i++) {
        int k = Integer.parseInt(inputs[i]);
        for(int j=0 ; j<k ; j++) {
            b[idx++] = i;            
        }
    }

    ArrayList<Integer> res = new ArrayList<>();
    do{
        res.add(calc(a, b));
    }while(next_permutation(b));
    Collections.sort(res);
    int m = res.size();
    System.out.println(res.get(m-1));
    System.out.println(res.get(0));
}
}

