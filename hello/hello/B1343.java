import java.io.*;
import java.util.StringTokenizer;

public class B1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        int count = 0;
        String ans = "";
        boolean isAble = true;
        for(int i=0;i<text.length();i++){
            
            if(text.charAt(i) == 'X'){
                count++;
                if(i == text.length()-1){
                    if(count %2 != 0){
                        isAble = false;
                        // System.out.println(-1); 
                        break;
                    }
                    if(count<4) {
                        ans += "BB";
                    }else if( count %4 == 0){ //4의 배수일 떄  4n
                        int n = count/4;
                        for(int j=0;j<n;j++){
                            // System.out.print("AAAA");
                            ans += "AAAA";
                        }
                    } else if(count%4 == 2){ //4보다 큰 짝수일 떄 4n+2
                        int n = count/4;
                        for(int j=0;j<n;j++){
                            // System.out.print("AAAA");
                            ans += "AAAA";
                        }
                        ans += "BB";
                        // System.out.print("BB");
                    }
                    // System.out.println();
                }
            }else if(text.charAt(i) == '.'){
                int tmp = count;
                
                if(tmp %2 != 0){
                    isAble = false;
                    // System.out.println(-1); 
                    break;
                }else{
                    //4보다 작은 짝수일 떄( 2일 떄 ) 2n 
                    if(tmp<4 && tmp != 0) {
                        ans += "BB";
                        // System.out.print("BB");
                    }else if( tmp %4 == 0 && tmp != 0){ //4의 배수일 떄  4n
                        int n = tmp/4;
                        for(int j=0;j<n;j++){
                            ans += "AAAA";
                            // System.out.print("AAAA");
                        }
                    } else if(tmp%4 == 2){ //4보다 큰 짝수일 떄 4n+2
                        int n = tmp/4;
                        for(int j=0;j<n;j++){
                            // System.out.print("AAAA");
                            ans += "AAAA";
                        }
                        // System.out.print("BB");
                        ans += "BB";
                    }
                }
                ans += text.charAt(i);
                count = 0;
                // System.out.print(text.charAt(i));
                
            }
            // System.out.println(count);
        }
        if(isAble == false){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }
    
}