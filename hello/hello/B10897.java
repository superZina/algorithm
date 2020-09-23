import java.io.*;



public class B10897 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        long[] childs = new long[n+2];
        long[] number = new long[n+2];
        long count = 1;
        childs[0] = 0;childs[1] = 1;
        number[0] = 0; number[1] = 1;
        for(int i=2; i <=n ; i++) {
            number[2] = 2;
            childs[i] = (childs[i-1]*i)%1000000007;
            // System.out.println(childs[i]);
            count = (count +childs[i])%1000000007;
            number[i+1] = (count+1)%1000000007;
            // System.out.println("number : "+number[i]);
        }
        long prev = 0; 
        for(int i=1; i<nums.length+1 ; i++) {
            long th = Long.parseLong(nums[i-1]);
            //i번째 세대에서, ~번째 자식을 리턴함
            if (i == 1) {
                System.out.println(1);
                prev = 1;
            }else {
                long res ;
                res = (number[i] + ((prev-1) * i) + th-1)%1000000007;
                System.out.println(res);
                prev = (((prev-1) * i) + th) %1000000007;
            }
        }

    }
}
