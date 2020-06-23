
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String text = br.readLine().trim();
		int count=0;
		int length = text.length();
		for(int i=0;i<text.length();i++) {
			int input = text.charAt(i);
			count++;
			switch(input) {
			case 'c':
				if(i < length-1 && (text.charAt(i+1)=='='||text.charAt(i+1)=='-')) {i++;}
				break;
			case 'd':
				if(i < length-1 && text.charAt(i+1)=='-'){i++;}
				else if(text.charAt(i+1)=='z') {
					if(text.charAt(i+2)=='=')
					i+=2;
					} 
				break;
			case 'l':
			case 'n':
				if(i < length-1 && text.charAt(i+1)=='j') {i++;}
				break;
			case 's':
			case 'z':
				if(i < length-1 && text.charAt(i+1)=='=') {i++;}
				break;
			}
		}
		bw.write(count+"");
		bw.flush();
		
		br.close();bw.close();
}
}
