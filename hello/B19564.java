
import java.io.*;


public class B19564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer text = new StringBuffer( br.readLine());
        StringBuffer error =  new StringBuffer("abcdefghijklmnopqrstuvwxyz");
        int count = 0;
        String tmp1 = "";
            tmp1 += text.charAt(0);
        int idx = error.indexOf(tmp1);;
        for(int i=0; i<text.length(); i++) {
            String tmp = "";
            tmp += text.charAt(i);
            int newIdx = error.indexOf(tmp);
            if (newIdx <= idx) {
                count++;
                idx = newIdx;
            }else{
                idx = newIdx;
            }
            System.out.println(count);    
        }
        
    }
}