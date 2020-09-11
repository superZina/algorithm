import java.io.*;


public class B2530 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] text = br.readLine().split(" ");
        int hour = Integer.parseInt(text[0]);
        int minute = Integer.parseInt(text[1]);
        int sec = Integer.parseInt(text[2]);
        int cookTime = Integer.parseInt(br.readLine());
        // System.out.println("hour : "+hour+" minuite : "+minute+" second : "+sec);
        String newTime = "";
        
        // if (sec + cookTime < 60 ){
        //     sec += cookTime;
        //     System.out.println(hour+" "+minute+" "+sec);
        // }else {
        //     minute += (sec + cookTime) / 60;
        //     sec = (sec + cookTime)% 60;
        //     if( minute >= 60) { //나눈 분이 한시간을 넘어갈 때 
        //         hour += minute/60;
        //         minute %= 60;
        //         // System.out.println("hour : "+hour+" minuite : "+minute+" second : "+sec);
        //         if(hour >= 24 ) {
        //             hour %= 24;
        //         }
        //     }
        // }
        sec += cookTime;
        minute += sec/60;
        hour += minute/60;


        sec %= 60;
        minute %= 60;
        hour %= 24;
        newTime = hour+" "+minute+" "+sec;
        System.out.println(newTime);
    }
    
}