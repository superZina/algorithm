import java.util.*;
public class pro1 {
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
        Map<String[],String[]> comp = new HashMap<String[],String[]>();
        comp.put(participant,completion);
        for(int i=0 ; i<participant.length ; i++) {
        	if(!comp.containsValue(participant[i])) {
        		answer = participant[i];
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"marina", "josipa", "nikola","filipa"};
		String[] a = {"mislav", "stanko", "mislav", "ana"};
		String[] b = {"stanko", "mislav", "ana"}; 
		String res = solution(participant , completion);
		String res2 = solution(a,b);
		System.out.println(res);
		System.out.print(res2);
	}
}
