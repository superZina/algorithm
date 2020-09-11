import java.io.*;
import java.util.*;


public class B13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] n = br.readLine().split(" ");
        int max = Integer.parseInt(n[0]); int students = Integer.parseInt(n[1]);
        Map<String ,Integer > map = new HashMap<String , Integer>();
        // Map<String ,Integer > map = new HashMap<String , Integer>();
        String[] student = new String[500001];
        String[] tmpstudent = new String[500001];
        int count = 1;
        for(int i=0 ; i<students; i++) {
            String tmp = br.readLine();
            tmpstudent[i] = tmp;
            map.put(tmp, count);
            count++;
        }
        for(int i=0; i<students; i++) {
            int index = map.get(tmpstudent[i]);
            student[index] = tmpstudent[i];
        }
        int c = 1;
        for(int i=1;i<=students; i++) {
            if (student[i] != null){
                if(c>max){
                    break;
                }
                System.out.println(student[i]);
                c++;
            }else {
                continue;
            }
        }
        // System.out.println(map.size());
    
        
    }
    
}