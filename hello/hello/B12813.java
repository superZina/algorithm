import java.io.*;


public class B12813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        StringBuilder and = new StringBuilder();
        StringBuilder XOR = new StringBuilder();
        StringBuilder or = new StringBuilder();
        StringBuilder notA = new StringBuilder();
        StringBuilder notB = new StringBuilder();
        int[] a = new int[100001];
        int[] b = new int[100001];
        //A&B
        for(int i=0; i<A.length(); i++) {
            a[i] = A.charAt(i) - '0';
            b[i] = B.charAt(i) - '0';
            and.append( a[i]&b[i]);
            or.append( a[i]|b[i]);
            XOR.append( a[i]^b[i]);
            int nota;
            if( a[i] == 0 ){
                nota = 1;
            }else {
                nota = 0;
            }
            notA.append(nota);
            int notb;
            if( b[i] == 0 ){
                notb = 1;
            }else {
                notb = 0;
            }
            notB.append(notb);
        }
        
        System.out.println(and);
        System.out.println(or);
        System.out.println(XOR);
        System.out.println(notA);
        System.out.println(notB);
    }
}
