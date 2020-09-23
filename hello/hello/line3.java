public class line3 {
    public static int[] bfs(int n, int nx, int count) {
        int[] ans = new int[2];
        //n을 nx기준으로 분리하고 더한다
        String N = Integer.toString(n);
        if(N.length() <= 1) {
            count--;
            ans[0] = count;
            ans[1] = n;
            // System.out.println("count :"+count);
            return ans;
        }
        String front = N.substring(0,nx);
        String back = N.substring(nx, N.length());
        if(back.charAt(0) == '0'&& back.length()!= 1) {
            return bfs(n, nx+1, count);
        }
        //더한 값이 일정 자리수 이상인지 확인한다. 이상이면 break
        // System.out.println("front : "+front+" back : "+ back + " count : "+count);
        int newNum = Integer.parseInt(front) + Integer.parseInt(back);
        String newNumString = Integer.toString(newNum);
        //아니면 계속 진행
        
        for(int i=0; i<newNumString.length(); i++) {
            return bfs(newNum, i+1, ++count);
            }

        return ans;
    }
    public static int[] solution(int n) {
        String startN = Integer.toString(n);
        int[] answer = new int[2];
        if(startN.length() == 1) {
            answer[0] = 0;
            answer[1] = n;
            return answer;
        }
        int[][] res = new int[startN.length()][2];
        for(int i=1;i<startN.length(); i++){
            res[i] = bfs(n, i, 1);
        }
        
        int min = 10000000;
        int minIdx = 0;
        for(int i=1; i<startN.length(); i++) {
            if(res[i][0] <= min) {
                minIdx = i;
                min = res[i][0];
            }
            answer = res[minIdx]; 
        } 
        
        return answer;
    }
    public static void main(String[] args) {
        // int[][] res = new int[5][2];
        // for(int i=1; i<5; i++) {
        //     res[i] = bfs(73425, i, 1);
        // } 
        // int min = 10000000;
        // int minIdx = 0;
        // for(int i=1; i<5; i++) {
        //     if(res[i][0] <= min) {
        //         minIdx = i;
        //         min = res[i][0];
        //         System.out.println("min : "+min );
        //     }
        //    System.out.println(res[i][0]+ " "+ res[i][1]);
        // } 
        // System.out.println();
        // System.out.println(res[minIdx][0]+ " "+ res[minIdx][1]);
        int[] ans = solution(10009);
        for(int i=0;i<2; i++) {
            System.out.print(ans[i]+ " ");
        }

    }
}
