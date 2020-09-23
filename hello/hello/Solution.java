import java.io.*;



class Solution {
    public static String solution(String new_id) {
        String answer = "";
        int i=0;
       while(true) {
            if (i>=new_id.length() && new_id.length() != 0) {
                if(new_id.charAt(new_id.length()-1) == '.') {
                    new_id = new_id.substring(0, new_id.length()-1);
                }
                if(new_id.length() >= 16) {//6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
                    new_id = new_id.substring(0, 15);
                    if(new_id.charAt(14) == '.') {
                        new_id = new_id.substring(0, 14);
                    }
              }
                break;
            }
            if(new_id.length() == 0) { // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
                new_id += 'a';
                i=0;
             }
            //  System.out.println("i : "+ i + " ans : "+ new_id);
            char c = new_id.charAt(i);
            // System.out.println("i : "+ i + " c : "+c+" ans : "+ new_id);
             if( c >= 65 && c <= 90) {//1단계 : 대문자 -> 소문자
                // c = (char) (c + 32);
                new_id = new_id.replace(c, (char)( c + 32));
                // System.out.println(new_id);
                i++;
             }else if((i == 0 || i == new_id.length()-1 ) && c == '.') { //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
                if(i ==0 ){
                    new_id = new_id.substring(1, new_id.length());
                }else if(i == new_id.length()-1) {
                    new_id = new_id.substring(0, new_id.length()-1);
                    i--;
                }
             }else if( i != 0 && c == '.' && c == new_id.charAt(i-1)){ //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
                new_id = new_id.substring(0, i) + new_id.substring(i+1, new_id.length()-1);
                i++;
             }else if(new_id.length() <= 2) { // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
                // System.out.println(i + " " +new_id);
                if (!((c>=48 && c<=57)||(c >= 97 && c <= 122) || c == '-' || c == '_' || c == '.')) {
                    if(i == new_id.length() -1 ){
                        new_id = new_id.substring(0, i)   ; 
                     }else {
                        new_id = new_id.substring(0, i) + new_id.substring(i+1, new_id.length());
                     }
                     i=0;
                }else{
                char last = new_id.charAt(new_id.length() -1 ) ;
                while(new_id.length() != 3 ) {
                new_id += last;
                i++;
                }
            }
                
             }else if((c>=48 && c<=57)||(c >= 97 && c <= 122) || c == '-' || c == '_' || c == '.') {
                // System.out.println(new_id);
                i++;
             }else if (!((c>=48 && c<=57)||(c >= 97 && c <= 122) || c == '-' || c == '_' || c == '.')){
                 if(i == new_id.length() -1 ){
                    new_id = new_id.substring(0, i)   ; 
                 }else {
                 new_id = new_id.substring(0, i) + new_id.substring(i+1, new_id.length());
                 }
                 i=0;
                }else if(new_id.length() >= 16) {//6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
                   new_id = new_id.substring(0, 16);
                
             }else{
                 break;
             }
       }
            answer = new_id;
    return answer;
}
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String newId = br.readLine();
        newId = solution(newId) ;
        System.out.println(newId);
    }
}