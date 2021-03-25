import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution3 {
    public static int[] solution(int[] enter, int[] leave) {
        ArrayList<Integer>[] meet = new ArrayList[enter.length+1];
        for(int i=0 ; i<meet.length; i++) {
            meet[i] = new ArrayList<Integer>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        int idx = 0;
        for(int i=0 ; i<leave.length ; i++) {
         
            int n = leave[i];
            // System.out.println("n : "+n);
            //list안에 없다면 enter에 있을때까지 넣는다
            if(list.contains(n)) {
                for(int k = 0; k<list.size(); k++) {
                    if(list.get(k) == n) {
                        list.remove(k);
                    }
                }
                continue;
            }
            if(!list.contains(n)) {
                while( idx < enter.length && enter[idx] != n ) {
                    list.add(enter[idx]);                    
                    idx++;                           
                }         
            }         
            list.add(n);
            idx++;
            for(int j =0 ; j<list.size() ; j++) {
                int tmp1 = list.get(j);
                for(int k=0 ; k<list.size() ; k++) {
                    int tmp2 = list.get(k);
                    if(tmp1==tmp2) continue;
                    if(!meet[tmp1].contains(tmp2)) {
                        meet[tmp1].add(tmp2);
                        // System.out.println(tmp1+" "+tmp2);
                    }
                }
            }
            // for(int j = 0 ; j<list.size() ; j++) {
            //     System.out.print(list.get(j)+" ");
            // }
            // System.out.println();
            for(int k = 0; k<list.size(); k++) {
                if(list.get(k) == n) {
                    list.remove(k);
                }
            }
        }

        int[] answer = new int[enter.length];        
        for(int i=0 ; i<answer.length ; i++) {
            answer[i] = meet[i+1].size();
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] enter = {1,4,2,3};
        int[] leave = {2,1,3,4};
        int[] ans = solution(enter, leave);
        for(int i=0 ; i<4; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
