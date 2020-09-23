import java.io.*;
import java.util.Stack;



public class B16171 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String keyword = br.readLine();
        Stack<Character> s = new Stack<>();
        for(int i=keyword.length()-1;i>=0; i-- ){
            s.push(keyword.charAt(i));
        }
        int idx = 0;
        char tmp ;
        int j = 0;
        String decode = "";
       for(int i=0; i<text.length(); i++) {

            if(text.charAt(i)>=48 && text.charAt(i) <= 57) { //숫자일 떄 
                continue;
            }else{ //소문자 혹은 대문자일 때
                
                decode += text.charAt(i);
            }
        }
        // System.out.println(decode);
        // System.out.println(keyword);
        int Idx =  decode.lastIndexOf(keyword);
        int Idx2 = decode.indexOf(keyword);
        // System.out.println("Idx : "+Idx);
        // System.out.println("Idx2 : "+Idx2);
        if(Idx == -1 && Idx2 == -1 ){
            System.out.println(0);
        }else{
            System.out.println(1);
        }
    }
    

}