import java.io.*;

public class Solution {
    public static String solution(String new_id) {
        String answer = "";
        char[] Upper = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        // 1단계: 모든 대문자를 소문자로 치환
        for (int i = 0; i < Upper.length; i++) {
            char newChar = (char) (Upper[i] + 32);
            new_id = new_id.replace(Upper[i], newChar);
        }
        System.out.println(new_id);
        // 2단계 : 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        int idx = 0;

        String pattern = "[^-_.0-9a-z]";
        new_id = new_id.replaceAll(pattern, "");
        StringBuilder sb = new StringBuilder(new_id);
        StringBuilder tmp = new StringBuilder();

        // 3단계 : new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        while (idx < sb.length()) {
            if (idx < sb.length() - 1 && sb.charAt(idx) == '.' && sb.charAt(idx + 1) == '.') {
                tmp.append(sb.substring(0, idx));
                tmp.append(sb.substring(idx + 1, sb.length()));
                sb.setLength(0);
                sb.append(tmp);
                tmp.setLength(0);
                idx--;
            }
            idx++;
        }
        System.out.println(sb);
        tmp.setLength(0);
        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (sb.charAt(0) == '.') {
            tmp.append(sb.substring(1, sb.length()));
            sb.setLength(0);
            sb.append(tmp);
        } else if (sb.charAt(sb.length() - 1) == '.') {
            tmp.append(sb.substring(0, sb.length() - 1));
            sb.setLength(0);
            sb.append(tmp);
        }
        tmp.setLength(0);
        System.out.println(sb);
        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (sb.length() == 0) {
            sb.append('a');
        }
        System.out.println(sb);
        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (sb.length() >= 16) {
            tmp.append(sb.substring(0, 16));
            sb.setLength(0);
            sb.append(tmp);
            tmp.setLength(0);
            if (sb.charAt(sb.length() - 1) == '.') {
                tmp.append(sb.substring(0, sb.length() - 1));
                sb.setLength(0);
                sb.append(tmp);
                tmp.setLength(0);
            }
        }
        System.out.println(sb);
        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if (sb.length() <= 2) {
            char last;
            while (sb.length() <= 2) {
                last = sb.charAt(sb.length() - 1);
                tmp.append(sb);
                tmp.append(last);
                sb.setLength(0);
                sb.append(tmp);
                tmp.setLength(0);
            }
        }
        System.out.println(sb);
        answer = sb.toString();
        return answer;

    }

    public static void main(String[] args) {
        String ans = solution("...!@BaT#*..y.abcdefghijklm");
        System.out.println(ans);
    }
}
