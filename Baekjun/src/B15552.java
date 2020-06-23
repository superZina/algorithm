import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B15552 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력받
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//출력
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String a = br.readLine();
			StringTokenizer st = new StringTokenizer(a," ");
			int aa = Integer.parseInt(st.nextToken());
			int bb = Integer.parseInt(st.nextToken());
			int result = aa+bb;
			bw.write(Integer.toString(result)+"\n");

		}
		bw.flush();
		bw.close();
		}
}
