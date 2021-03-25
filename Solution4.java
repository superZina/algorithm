import java.io.ObjectInputFilter.Status;
import java.util.*;
class Solution {
    //flag와 flag_argument_type 저장을 위한 map
    static Map<String, String> flag_rule = new HashMap<String, String>();
    //별칭 저장을 위한 map
    static Map<String, String> alias_map = new HashMap<String, String>();
    
    //flag인지 아닌지 확인하는 함수
    public static boolean checkFlag(String str) {
        if (flag_rule.get(str) == null)
            return false;
        else
            return true;
    }

    //숫자인지 아닌지 확인하는 함수
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    //solution
    public static boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = {};        
        answer = new boolean[commands.length];
        for(int i=0 ; i<answer.length ; i++ ) {
            answer[i] = true;
        }

        // flag마다 룰을 저장해둔 hashmap 생성
        for (int i = 0; i < flag_rules.length; i++) {
            String[] tmp = flag_rules[i].split(" ");
            //ALIAS가 존재할 때
            if(tmp[1].equals("ALIAS")) {
                flag_rule.put(tmp[0] ,flag_rule.get(tmp[2]));
                alias_map.put(flag_rule.get(tmp[2]), tmp[0]);                
                alias_map.put(tmp[0], flag_rule.get(tmp[2]));
            }else{
            // flag 가 key
                flag_rule.put(tmp[0], tmp[1]);
            }
        }

        // command마다 rule이 맞는지 확인
        for (int i = 0; i < commands.length; i++) {
            //각 alias를 사용했는지의 여부
            Map<String, Boolean> alias_used = new HashMap<String, Boolean>();

            String[] tmp = commands[i].split(" ");
            // 1. 프로그램이름이 다르면 안됨
            String program_name = tmp[0];
            if (!program.equals(program_name)) {
                answer[i] = false;
                continue;
            }

            //flag인지 아닌지를 판별하기 위한 boolean 변수
            boolean hasFlag = false;
            String rule = "";
            int argumentCnt = 0;
            for (int j = 1; j < tmp.length; j++) {
                if (!hasFlag) {
                    // 2. flag인지 아닌지 확인. false면 flag가 반드시 있어야 함
                    if (checkFlag(tmp[j])) {
                        hasFlag = true;
                    } else {
                        // 대응하는 flag가 없음
                        answer[i] = false;
                        break;
                    }
                } else {
                    // flag가 아님. argument여야 함. argument 검사
                    argumentCnt++;
                    if(!(flag_rule.get(tmp[j - 1]) == null)) {
                        rule = flag_rule.get(tmp[j - 1]);
                        //별명 있는지 체크
                        if(alias_map.get(rule) != null) {
                            String alias = alias_map.get(rule);
                            //해당 별명을 사용했는지 체크
                            if(alias_used.get(alias)!= null) {
                                if(alias_used.get(alias)) {
                                    answer[i] = false;
                                    break;
                                }
                            }
                            //현재 flag와, flag의 별명을 사용했음을 표시
                            alias_used.put(alias, true);
                        }                        
                    }                  
                    if(rule.equals("NULL")){
                        // argument가 없어야함
                        if (checkFlag(tmp[j])) {
                            j--;
                            hasFlag = false;
                            argumentCnt = 0;
                            continue;
                        } else {
                            answer[i] = false;
                            break;
                        }
                    }else if(rule.equals("NUMBER") || rule.equals("NUMBERS")){
                        // argument가 없으면
                        if (checkFlag(tmp[j])) {
                            answer[i] = false;
                            break;
                        } else {
                            // 숫자가 아니면
                            if (!isNumeric(tmp[j])) {
                                answer[i] = false;
                                break;
                            }
                        }
                    }else if(rule.equals("STRING") || rule.equals("STRINGS")) {
                        // argument가 없으면
                        if (checkFlag(tmp[j])) {
                            answer[i] = false;
                            break;
                        } else {
                            //숫자면 안됨
                            if(isNumeric(tmp[j])) {
                                answer[i] = false;
                                break;
                            }
                        }                    
                    }
                    
                    //다음 단어가 flag인지 아닌지 체크
                    if(j!= tmp.length-1){
                        //flag
                        if(checkFlag(tmp[j+1])) {
                            hasFlag = false;
                            if(rule.equals("STRING") || rule.equals("NUMBER")) {
                                if(argumentCnt > 1) {
                                    answer[i] = false;
                                }
                            }
                            argumentCnt = 0;
                        }else{
                            //not flag
                            continue;
                        }                        
                    }else{
                        if(rule.equals("STRING") || rule.equals("NUMBER")) {
                            if(argumentCnt > 1) {
                                answer[i] = false;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}