import java.io.*;


public class B13063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while((s = br.readLine() ) != null) {
            String[] nums = s.split(" ");
            int total = Integer.parseInt(nums[0]);
            int my = Integer.parseInt(nums[1]);
            int enemy = Integer.parseInt(nums[2]);
            int indp = total - my - enemy;
            // System.out.println("total : " + total + " my : "+ my + " enemy : "+ enemy +" indp : "+ indp);
            int min = 0;
            if( my == 0 && enemy == 0 && total == 0){
                break;
            }if (my >enemy+indp) {
                System.out.println(min);
            }else if((my + indp) <= enemy ){
                System.out.println(-1);
            }else {
                for(int i=0 ; i< indp ; i++) {
                    int a = my + (i+1);
                    int b = enemy + (indp - i -1) ;
                    // System.out.println("i : "+ i+ " my : "+ a+" enemy : "+ b) ;
                    if( a > b ) {
                        System.out.println(i+1);
                        break;
                    }
                }
            }
            
        }
    }
}
