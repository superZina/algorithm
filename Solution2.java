import java.util.ArrayList;

public class Solution2 {
    public int[] solution(String inp_str) {
        int[] alpha = new int[256];
        ArrayList<Integer> ans = new ArrayList<>();
        //1. 8 ≤ password 길이 ≤ 15
        int len = inp_str.length();
        if(!(len >= 8 && len <= 15)) {
            ans.add(1);
        }
        boolean[] word = new boolean[4];
        //2. password는 아래 4 종류의 문자 그룹을 제외한, 다른 어떤 문자도 포함해서는 안됩니다
        //~!@#$%^&*
        /*[1] 알파벳 대문자(A~Z) (65~90)
            [2] 알파벳 소문자(a~z) (97~122)
            [3] 숫자(0~9) (48~57)
            [4] 특수문자(~126 !33 @64 #35 $36 %37 ^94 &38 *42)  (~ : 126)
            */
        for(int i=0 ; i<inp_str.length() ; i++) {
            char c = inp_str.charAt(i);
            alpha[c]++;
            if(!((c>=48 && c <= 57) || (c>=65 && c <= 90) || (c >= 97 && c <= 122) || c == 33  || c== 126 || c == 64 || (c >=35 && c<=38) || c == 94 || c== 42 )) {
                if(!ans.contains(2)) {
                ans.add(2);
                }
            }
            if(c>=48 && c <= 57){
                word[0] = true;
            }
            if(c>=65 && c <= 90){
                word[1] = true;
            }
            if(c >= 97 && c <= 122) {
                word[2] = true;
            }
            if(c == 33  || c== 126 || c == 64 ||(c >=35 && c<=38) || c == 94 || c== 42) {
                word[3] = true;
            }
        }
        //3. password는 (2.)에서 명시된 4 종류의 문자 그룹 중에서 3 종류 이상을 포함해야 합니다
        int cnt = 0;
        for(int i =0 ; i<4; i++) {
            if(word[i]) cnt++;
        }
        if(cnt <3) ans.add(3);

        //4.password에 같은 문자가 4개 이상 연속될 수 없습니다.
        int equalCnt = 1;
        int equalMax = 0;
        for(int i=1 ; i<inp_str.length() ; i++) {
            if(inp_str.charAt(i-1) == inp_str.charAt(i)) {
                equalCnt++;
            }else{
                equalCnt = 1;
            }
            equalMax = Math.max(equalMax, equalCnt);
        }
        if(equalMax >= 4) ans.add(4);
        //5. password에 같은 문자가 5개 이상 포함될 수 없습니다.
        for(int i=0 ; i<256 ; i++) {
            if(alpha[i] >= 5) ans.add(5);
        }
        int[] answer = {};
        if(ans.size() == 0) {
            answer = new int[1];
        }else{
            answer = new int[ans.size()];
            for(int i=0 ; i<ans.size(); i++) {
                answer[i] = ans.get(i);
            }
        }
        
        return answer;
    }
}
