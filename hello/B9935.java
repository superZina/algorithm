import java.io.*;
import java.util.Deque;
import java.util.LinkedList;



public class B9935 {
    // static int count = 0;
    public static String boom(Deque s, String tnt) {
        int count = 0;
        String newText = "";
        // System.out.println("size : "+s.size());
        if(s.size() < tnt.length()) {
            
            while(!s.isEmpty()) {
                newText+=s.removeFirst();
            }
            return newText;
        }
        Deque<Character> ss = new LinkedList();
    
        while(!s.isEmpty()){

            char tmp = (char) s.removeFirst();
            // System.out.println("tmp : "+tmp);
            if(tmp == tnt.charAt(0)){ //처음 문자가 같을 떄 
                ss.addLast(tmp);
                String ttmp = "";
                ttmp+=tmp;

                for(int j=0 ; j<tnt.length()-1; j++) { //비교 문자 길이만큼 스텍 팝 해서 문자열 만듬 
                    char tmp2 = (char) s.removeFirst();
                    
                    ttmp+=tmp2;
                    ss.addLast(tmp2);
                    // System.out.print("tmp2 : "+tmp2);
                }

                // System.out.println();
                // System.out.println("ttmp : " +ttmp);

                if (ttmp.equals(tnt)) { //해당 문자열이 비교 문자열과 같을경우 
                    count++;
                    for(int j=0; j<tnt.length(); j++) {
                       ss.removeLast();
                    }
                }else {
                    for(int j=0; j<tnt.length()-1; j++) {
                        s.addFirst(ss.removeLast());
                         //저장했던 스택에있는 문자들 다시 삭제
                    }
                    
                }
                    //같지 않으면 그냥 냅둠
            }else { //첫 문자와 같지 않으면그냥 더함
                ss.addLast(tmp);
            }

        }

        if(count == 0) {
            while(!ss.isEmpty()) {
                newText+=ss.removeFirst();
            }
            return newText;
        }
        
        // System.out.println(++count);
        
        return boom(ss, tnt);
        // return newText;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        // StringBuilder sb = new StringBuilder(text);
        String tnt = br.readLine();
        Deque<Character> s = new LinkedList();
        for(int i=0 ;i<text.length(); i++){
            s.addLast(text.charAt(i));
        }

        if(text.length() < tnt.length() ) {
            System.out.println("FRULA");
        }else {

        String result = boom(s, tnt);
        // String result2 = boom()
        
        if( result.length() == 0) {
            System.out.println("FRULA");
        }else{
            System.out.println(result);
        }
    }


    }
    
    
}