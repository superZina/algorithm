import java.io.*;
import java.math.BigInteger;

public class B1334 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        char[] charArr = number.toCharArray(); 
        int len = charArr.length;
        int[] arr = new int[len];
        for(int i=0; i<len; i++) {
            arr[i] = charArr[i] - '0';
        }
        if(len%2 == 0 ) { //짝수일 때 ex) 1 9 9 4 / 1 3 4 3 4 4
            String newNum = ""; // idx : 0 1 2 3 / 0 1 2 3 4 5
            for(int i= len/2; i<len ; i++ ) {
                arr[i] = arr[len-1-i];  // 좌우대칭 만들어줌
            }
            for(int i=0 ; i<len; i++) {
                newNum += arr[i];
            }
            //뒤집은 숫자가 원래 숫자보다 작으면
            //숫자 하나를 더해서 다시 뒤집고 만들어야 한다.
            if(BigInteger.valueOf(Long.parseLong(newNum)).compareTo(BigInteger.valueOf(Long.parseLong(number))) == -1 ) {
                newNum = "";
                int lastN = arr[len/2 - 1] + 1;
                if (lastN == 10) {
                    int idx = len/2 -1 ;
                    arr[idx] = lastN;
                    // System.out.println(arr[idx]);
                    while(arr[idx] == 10) { // 앞자리 수가 10이 아닐때 까지 더함
                        if (idx == 0) break;
                        arr[idx] = 0;
                        arr[idx-1] = arr[idx -1] + 1;
                        idx--;
                    }
                }else {
                    arr[len/2 -1] = (char)lastN; 
                }
                //새로운 문자
                // System.out.println(lastN);
                for(int i= len/2; i<len ; i++ ) {
                    arr[i] = arr[len-1-i];  // 좌우대칭 만들어줌
                }
                for(int i=0 ; i<len; i++) {
                    newNum += arr[i];
                }
            }
            System.out.println(newNum);

        }else{ //길이가 홀수일 때 
            String newNum = ""; // idx : 0 1 2 3 4/ 0 1 2 3 4 5 6
            for(int i= len/2+1; i<len ; i++ ) {
                arr[i] = arr[len-1-i];  // 좌우대칭 만들어줌
            }
            for(int i=0 ; i<len; i++) {
                newNum += arr[i];
            }
            if(BigInteger.valueOf(Long.parseLong(newNum)).compareTo(BigInteger.valueOf(Long.parseLong(number))) == -1) {
                newNum = "";
                int lastN = arr[len/2] + 1;
                if (lastN == 10) {
                    int idx = len/2;
                    arr[idx] = lastN;
                    // System.out.println(arr[idx]);
                    while(arr[idx] == 10) { // 앞자리 수가 10이 아닐때 까지 더함
                        if (idx == 0) break;
                        arr[idx] = 0;
                        arr[idx-1] = arr[idx -1] + 1;
                        
                        // System.out.println(idx + " : " +arr[idx]);
                        idx--;
                    }
                }else {
                    arr[len/2] = (char)lastN; 
                }
                //새로운 문자
                // System.out.println(lastN);
                for(int i= len/2+1; i<len ; i++ ) {
                    arr[i] = arr[len-1-i];  // 좌우대칭 만들어줌
                }
                for(int i=0 ; i<len; i++) {
                    newNum += arr[i];
                }
            }
            System.out.println(newNum);
        }
    }
}
