 import java.io.*;
 
 public class B2828 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]  num = br.readLine().split(" ");
        int screen = Integer.parseInt(num[0]);
        int basket = Integer.parseInt(num[1]);
        int n = Integer.parseInt(br.readLine());
        int startIdx = 1; int endIdx = startIdx + basket;
        int count = 0;
        for(int i=0; i<n; i++){
            
            int j = Integer.parseInt(br.readLine());
            //공 떨어지는 범위가 바구니 범위안에 있을 떄 
            if(startIdx <= j && endIdx >= j+1){
            }
            //공 떨어지는 위치가 바구니 범위 밖일 떄 
                //공의 위치가 바구니보다 더 왼쪽에 있을 떄
            if(startIdx >= j+1) {
                int tmp = endIdx;
                startIdx  = j ;
                endIdx = j+basket;
                count += Math.abs(endIdx - tmp);
            }
                //공의 위치가 바구니보다 더 오른쪽에 있을 때 
            if(endIdx <= j){
                int tmp = startIdx;
                endIdx = j+1;
                startIdx = j+1-basket;
                count += Math.abs(startIdx - tmp);
            }
            // System.out.println("startIdx : "+ startIdx + " endIdx : "+ endIdx);    
        }
        System.out.println(count);
    }
}