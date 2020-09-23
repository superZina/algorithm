import java.io.*;

public class B1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        int one =0;int zero = 0;
        for(int i=0; i<text.length(); i++){
            if(text.charAt(i) == 0) zero++;
            else one++;
        }
        int max = Math.max(one, zero);
        while(true){
            if(zero > one ){
                
            }
        }
    }
}