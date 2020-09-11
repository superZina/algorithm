import java.io.*;



public class B15351 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i =0; i<n ; i++) {
            String text = br.readLine();
            int score = 0 ;
            for(int j=0;j<text.length() ; j++){
                if(text.charAt(j) == ' ') continue;
                // System.out.print((int)text.charAt(j)-64 + " ");
                score += text.charAt(j) - 64;
            }
            if(score == 100){
                System.out.println("PERFECT LIFE");
            }  else {
                System.out.println(score);
            }
        }
    }
}
