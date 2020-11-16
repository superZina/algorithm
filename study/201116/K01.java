import java.util.*;
public class K01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int min = 9999;
        String ans = "";
        for(int i=1; i<text.length(); i++) { //I개 단위로 자름
                String encoded = "";
                ArrayList<Integer> cnts = new ArrayList<Integer>();

                int cnt = 1;
                // System.out.println("i : "+i);
                for(int j=0; j<text.length() ; j= j+i) {
                    if(j == 0) continue;
                        if(j+i >text.length()) {//남은부분이 분할된 문자 수보다 적다면
                            String subText = text.substring(j, text.length());
                            String beforeSub = text.substring(j-i, j);
                            encoded += beforeSub;
                            encoded += subText;
                            // System.out.println(encoded);
                            break;
                        }else{
                    String subText = text.substring(j, j+i);
                    String beforeSub = text.substring(j-i, j);
                    // System.out.println("presnt : "+ subText + " , before : "+beforeSub);
                    if(subText.equals(beforeSub)) { //이전과 같다면
                        cnt++;
                        if(j+i == text.length()) {
                            if(cnt == 1) {
                                encoded += beforeSub;
                            }else{
                                encoded += cnt + beforeSub;
                                cnts.add(cnt);
                            }    
                        }
                    }else{// 다르다면
                        if(cnt == 1) {
                            encoded += beforeSub;
                            if(j+i == text.length()) {
                                encoded += subText;
                            }
                        }else{
                            encoded += cnt + beforeSub;
                        }
                        if(cnt != 1) {
                            cnts.add(cnt);
                        }
                        cnt = 1;
                    }
                }
                }
                for(int k=1; k<cnts.size(); k++) {
                    if(cnts.get(k) != cnts.get(k-1)) continue;
                }
                if(encoded.length() < min) {
                    ans = encoded;
                    min = encoded.length();
                }
                // System.out.println(ans);
        }
        System.out.println(min);
        // System.out.println(ans.length());
    }
}
