import java.util.*;
public class B8979 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] medal = new int[n][5];
		int obj = sc.nextInt();
		for(int i=0; i<n; i++) {
			for(int j=0; j<4 ; j++) {
				medal[i][j] = sc.nextInt();
			}
		}
		//정렬 
		Arrays.sort(medal , (o1,o2) -> {
			if(o1[1] == o2[1]) {
				if(o1[2] == o2[2]) {
					if(o1[2] == o2[2]) {
						return Integer.compare(o1[3], o2[3]);
					}
				}else {
					return Integer.compare(o1[2],o2[2]);
				}
			}else {
				return Integer.compare(o1[1],o2[1]);
			}
			return medal[1][1];
		});
		//순위매기기 
		int count = 1;
		for(int i=n-1; i>=0;i--) {
			if(i != n-1 && (medal[i][1] == medal[i+1][1]) && (medal[i][2] == medal[i+1][2] & (medal[i][3] == medal[i+1][3]))) {
				medal[i][4] = medal[i+1][4];
				count++;
			}else {
			medal[i][4] = count;
			count++;
			}
		}
		for(int i=0;i<n; i++) {
			for(int j=0;j<5; j++){
				System.out.print(medal[i][j] + " ");
			}
			System.out.println();
		}
		for(int i =0; i<n; i++) {
			if(medal[i][0] == obj) {
				System.out.print(medal[i][4]);
			}
		}
	}
}
