import java.util.ArrayList;
import java.util.Scanner;

public class B11656 {
	static public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		String[] Alp = word.split("");
		ArrayList<String> suffix = new ArrayList<String>(); //접미사저장
		for(int i=0; i<Alp.length; i++) {
			String tmp = "";
			for(int j=i; j<Alp.length; j++) {
				tmp += Alp[j];
			}
			suffix.add(tmp);
		}
		suffix.sort(null);
		for(int i=0;i<suffix.size(); i++) {
			System.out.println(suffix.get(i));
		}
	}
}
