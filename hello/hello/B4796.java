import java.io.*;

public class B4796 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int idx = 1;
        while((s= br.readLine())!= null) {
            String[] n = s.split(" ");
            int L = Integer.parseInt(n[0]);
            int P = Integer.parseInt(n[1]);
            int V = Integer.parseInt(n[2]);
            if(L==0&&P==0&&V==0) break;
            int ans = 0;
            int count = (V/P)*L;
            int rest = V%P;
            if (rest>=L) {
                count += L;
            }else {
                count += rest;
            }
            System.out.println("Case "+idx+": "+count);
            idx++;
        }
    }
}
