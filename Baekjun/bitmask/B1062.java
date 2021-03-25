import java.io.*;

public class B1062 {
    static int[] words;
    static boolean[] alphabets = new boolean[30];    

    public static int count(int mask) {
        int count = 0;
        for(int i=0 ; i<words.length ; i++) {
            if((words[i] & (1<<26)-1-mask) == 0 ) {
                count += 1;
            } 
        }
        return count;
    }

    public static int teach(int index, int K, int mask) {
        // 불가능한경우 k<0
        if (K < 0)
            return 0;
        // 마지막 까지 왔을 경우(종료조건)
        if (index == 26)
            return count(mask);
        else {
            // 선택했을 때
            int ans = 0;
            int t1 = teach(index + 1, K - 1, mask | (1 << index));
            if (ans < t1)
                ans = t1;

            // 선택안했을 때
            if (index != 'a' - 'a' && index != 'n' - 'a' && index != 't' - 'a' && index != 'i' - 'a'
                    && index != 'c' - 'a') {
                t1 = teach(index + 1, K, mask);
                if (ans < t1)
                    ans = t1;
            }
            return ans;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        words = new int[N];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int tmp = 0;
            for(int j=0 ; j<word.length(); j++) {
                char c = word.charAt(j);
                tmp = tmp | (1<< c-'a');
            }
            words[i] = tmp;
        }
        int ans = teach(0, K,0);
        System.out.println(ans);
    }
}