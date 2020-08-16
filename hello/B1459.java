import java.io.*;

public class B1459 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n = br.readLine().split(" ");
        long x = Long.parseLong(n[0]);
        long y = Long.parseLong(n[1]);
        long w = Long.parseLong(n[2]);
        long c = Long.parseLong(n[3]);
        long time1 = (x+y)*w ; // 가로세로만 이동 
        long time2 =0;
        if((x+y)%2 == 0){ //대각선으로만 이동
            time2 = Math.max(x, y)*c;
        }else{
            time2 = Math.max(x, y)*c + w;
        }
        //대각선으로 최대한 가다가 평행 이동 
        long time3 = Math.min(x, y)*c + ( Math.max(x, y) - Math.min(x, y) )*w;

        long res = Math.min(time1, Math.min(time2, time3));
        System.out.println(res);
    }
}