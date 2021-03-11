import java.io.IOException;

public class longestString{
    public static int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;
        boolean[] Alpha = new boolean[130];        
        int start = 0;
        int end = 0;
        int max = 0;
        Alpha[s.charAt(start)] = true;
        while(end+1< s.length()) {
            if(start > end) break;            
            if(Alpha[s.charAt(end+1)]) { //이미 있다면
                //현재 문자를 포함한 문자 전까지 
                while(s.charAt(start) != s.charAt(end+1)) {                    
                    Alpha[s.charAt(start)] = false;
                    start++;
                }
                Alpha[s.charAt(start)] = false;
                start++;
                end += 1;
                Alpha[s.charAt(end)] = true;
            }else{              
                end += 1;  
                Alpha[s.charAt(end)] = true;
            }
            // System.out.println("start : "+start+" , end : "+end);
            max = Math.max(max, end - start);
        }
        return max+1;        
    }
    public static void main(String[] args) throws IOException{
        System.out.println(lengthOfLongestSubstring(""));
    }
}