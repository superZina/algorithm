import java.util.Scanner;

public class B12624 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(num%2==0) {
			System.out.println("I LOVE CBNU");
		}else {
			String line="";
			String[] tri = new String[num/2+1];
			for(int i=0;i<num;i++) {
				line += "*";
			}
			System.out.println(line);
			for(int i=0;i<tri.length;i++) {
				String space ="";
				String midSpace="";
				if(i==0) {
				for(int j=0; j<num/2;j++) {
				space += " ";	
				}
				tri[i] = space + "*";
				}else {
					for(int j=0;j<num/2-i;j++) {
						space += " ";
					}
					for(int j=0;j<2*(i-1)+1;j++) {
						midSpace += " ";
					}
					tri[i] = space + "*"+midSpace +"*";	
				}
				System.out.println(tri[i]);
			}
		}
	}
}
