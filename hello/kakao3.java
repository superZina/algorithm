import java.util.ArrayList;
import java.util.HashSet;

import java.util.Iterator;

public class kakao3 {  
    public static class Applicant{
    String lang; //언어
    String op; //직군
    String career; //경력
    String food; //소울 푸드
    int score; //점수
    public Applicant(String lang, String op, String career, String food, int score){
        this.lang = lang;
        this.op = op;
        this.career = career;
        this.food = food;
        this.score = score;
    }
}

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Applicant applicant[] = new Applicant[info.length];
        ArrayList cpp = new ArrayList();
        ArrayList java = new ArrayList();
        ArrayList python = new ArrayList();
        ArrayList back = new ArrayList();
        ArrayList front = new ArrayList();
        ArrayList junior = new ArrayList();
        ArrayList senior = new ArrayList();
        ArrayList chicken = new ArrayList();
        ArrayList pizza = new ArrayList();
        String[] score = new String[50001]; 
        for (int i=0; i<info.length; i++) {
            String[] spec = info[i].split(" ");
            applicant[i] = new Applicant("", "", "", "", 0);
            //사용언어
            if(spec[0].equals( "java")) {
                applicant[i].lang = "java";
            }else if(spec[0].equals("cpp")){
                applicant[i].lang = "cpp";
            }else if(spec[0].equals("python")){
                applicant[i].lang = "python";
            }
            //직군
            if(spec[1].equals( "backend")){
                applicant[i].op = "backend";
            }else if(spec[1].equals("frontend") ) {
                applicant[i].op = "frontend";
            }
            //경력
            if(spec[2].equals( "junior")) {
                applicant[i].career = "junior";
            }else if(spec[2].equals("senior") ) {
                applicant[i].career = "senior";
            }
            //소울푸드
            if(spec[3].equals("pizza") ) {
                applicant[i].food = "pizza";
            }else if(spec[3].equals("chicken")){
                applicant[i].food = "chicken";
            }
            applicant[i].score = Integer.parseInt(spec[4]);
            // System.out.println(i + " : "+applicant[i].lang+" "+applicant[i].op+" "+applicant[i].career+ " "+applicant[i].food+" "+applicant[i].score);
        }
        
        for(int i=0; i<query.length ; i++ ){
            int count = 0;
            String[] list = query[i].split(" and "); //list 0~2  까지는 항목 동일
            String[] tmp = list[3].split(" ");
            String food = tmp[0]; //소울푸드
            String sco = tmp[1]; //점수
            String lang = list[0];
            String part = list[1]; 
            String port = list[2];
            // System.out.println(i + " : "+lang+" "+part+" "+port+ " "+food+" "+sco);
            //언어
            boolean isOk = false;
            for(int j=0;j<info.length; j++) {
                
                if((applicant[j].lang.equals(lang) ||lang.equals("-")) &&(applicant[j].op.equals(part) ||part.equals("-"))&&(applicant[j].career.equals(port) ||port.equals("-"))&&(applicant[j].food.equals(food) ||food.equals("-"))&&(applicant[j].score >= Integer.parseInt(sco))){
                    // System.out.println(i + " : "+applicant[j].lang+" "+applicant[j].op+" "+applicant[j].career+ " "+applicant[j].food+" "+applicant[j].score);
                    answer[i]++;
                }
                
            }     
            
        }
        
        return answer;
    }
    public static void main(String[] args) {
        int[] test = new int[100000];
        String[] info = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        String[] query = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        test = solution(query, info);
        for(int i=0 ; i<test.length; i++) {
            System.out.print(test[i]+ " ");
        }
    }
}
