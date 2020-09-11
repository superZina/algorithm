import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class B19583 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] times = br.readLine().split(" ");
        String S = times[0];
        String[] Stimes = S.split(":");
        int Snum = Integer.parseInt(Stimes[0] + Stimes[1]);
        String E = times[1];
        String[] Etimes = E.split(":");
        int Enum = Integer.parseInt(Etimes[0] + Etimes[1]);
        String Q = times[2];
        String[] Qtimes = Q.split(":"); 
        int Qnum = Integer.parseInt(Qtimes[0] + Qtimes[1]);
        // System.out.println(Snum);
        // System.out.println(Enum);
        // System.out.println(Qnum);
        String s;
        int count = 0;
        Map<String, Boolean> ok = new HashMap<>();
        while (!"".equals((s = br.readLine()))) {
            // if( s.equals("")) break;
            // System.out.println("s :"+s);
            //00:00 dsdfaesffdsf
            String[] infos = s.split(" ");
            String name = infos[1];
            String[] studentTime = infos[0].split(":");
            // System.out.println(infos[0] + infos[1]);
            int snum = Integer.parseInt(studentTime[0]+studentTime[1]);
            if(snum <= Snum) {
                ok.put(name, false);
            }
            if(snum >= Enum && snum <= Qnum) {
                if(ok.get(name) != null) {//존재하지 않는다면
                    // System.out.println("name : "+name+ " is : "+ ok.get(name));
                    if(!ok.get(name)){
                    count++;
                        ok.put(name, true);
                    }
                }
            }
        }


        System.out.println(count);
        
    }
    
}
