import java.util.*;

import java.io.*;
;public class B2609 {

    public static int GCD(int a,int b){
        if(a%b ==0 ) return b; 
        return GCD(b, a%b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String[] word = text.split(" ");
        int a = Integer.parseInt(word[0]);
        int b = Integer.parseInt(word[1]);
        int gcd = GCD(a, b);
        int lcm = a*b/gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }
}