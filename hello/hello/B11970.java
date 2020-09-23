import java.io.*;


public class B11970 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num1 = br.readLine().split(" ");
        String[] num2 = br.readLine().split(" ");
        int a = Integer.parseInt(num1[0]);
        int b = Integer.parseInt(num1[1]);
        int c = Integer.parseInt(num2[0]);
        int d = Integer.parseInt(num2[1]);
        int result = 0;
        if(a<c && c<=b && b < d) {
            result = d - a;
            // System.out.println("case 1");
        }else if (c <a && a<=d && d <b){
            result = b - c ;
            // System.out.println("case 2");
        }else if(b<c) {
            result = (b -a) + (d-c);
            // System.out.println("case 3");
        }else if (d<a) {
            result = (d - c) + (b - a); 
            // System.out.println("case 4");
        }else if (c <=a && b <=d) {
            result = d - c; 
            // System.out.println("case 5");
        }else if( a<=c && d<=b) {
            result = b - a;
            // System.out.println("case 6");
        }
        System.out.println(result);
    }
}
