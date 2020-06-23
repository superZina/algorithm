import java.util.Scanner;

public class B2026 {
	
	public static void friend(int[][] a, boolean[] b , int start, int[] k , int count) {
	// a: 그래프, b: 방문 여부 , start: 출발노드 , k: 방문했던 노드 저장 배열 , count : 몇번째인지
		int n = a.length;
		b[start] = true;
		k[count] = start; 
		if(count >= 2) { // 지나온 노드와 서로 인접하지 않을경우(친구가 아닐경우) 종료
			for(int i=1;i<=count ; i++) {
				if(a[start][i] != 1) return;
			}
		}
		if(count > k.length) { //k번째일떄, 종료
			for(int i=1; i<count; i++) {
				System.out.println(k[i]);
			}
			return;
		}
		
		for(int i = 1; i< n ; i++) {
			if(a[start][i] == 1 && !b[i]) {
				friend(a,b,i,k,count+1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int friendNum = sc.nextInt();
		int[] k = new int[friendNum+1];
		int len = sc.nextInt();
		int[][] graph = new int[len+1][len+1];
		boolean[] visit = new boolean[len+1];
		int edge = sc.nextInt();
		for(int i=0; i< edge; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
			graph[b][a] = 1;
		} 
		friend(graph,visit,1,k,1);
	}
}
