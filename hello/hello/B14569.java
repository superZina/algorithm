import java.io.IOException;


import java.io.*;
public class B14569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String base = "";
        for(int i=0; i<51; i++) {
            base += '1';
        }
        int n = Integer.parseInt(br.readLine());
        StringBuilder[] lessons = new StringBuilder[n];
        int[][] les = new int[n][];
        // System.out.println();
        for(int i=0;i<n; i++) {
            lessons[i] = new StringBuilder(base);
            String[] t = br.readLine().split(" ");
            les[i] = new int[Integer.parseInt(t[0])];
            for(int j=0; j<Integer.parseInt(t[0]); j++) {
                les[i][j] = Integer.parseInt(t[j+1]);
                // System.out.print(les[i][j] + " ");
            }
            // System.out.println();
        }

        int N = Integer.parseInt(br.readLine()); 
        StringBuilder[] students = new StringBuilder[N];
        for(int i=0 ; i<N; i++) {
            students[i] = new StringBuilder(base);
            String[] t = br.readLine().split(" ");
            for(int j=1; j<t.length; j++) {
                int idx = Integer.parseInt(t[j]);
                students[i].setCharAt(idx, '0');
            }
        }
        
        for(int i=0; i<N; i++) {
            // System.out.println(students[i]);
            int count = 0;
            for(int j = 0; j<n; j++) {
                boolean isAble = true;
                
                for(int k=0; k<les[j].length ; k++) {
                    // System.out.println("j: "+n+" k: "+les[j].length);
                    // System.out.print(les[j][k] + " ");
                    if(students[i].charAt(les[j][k]) == '0' ) { //그 시간대가 비어있음
                        if( k == les[j].length -1 && isAble == true) count++;
                        continue;
                    }else{
                        isAble = false;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
