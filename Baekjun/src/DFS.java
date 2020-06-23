
import java.util.*;
public class DFS {
	public static void dfs(int[][] a, boolean[] c , int v) { // a: 그래프, c : 방문 여부, v: 시작 노드
		//if(c[v]) return;
		int n = a.length;
		c[v] = true; //방문한 곳은 true 로 바꿔줌
		System.out.print(v+ " ");
		
		for(int i=1; i<n; i++) { //i = 1 부터 시작하기 때문에 깊이우선탐색임
			if(a[v][i] == 1 && !c[i]) { //1) 각 노드들이 인접해 있고, 2)방문한 적이 없다면
				dfs(a,c,i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();//노드의 개수
		int[][] graph = new int[len+1][len+1];
		boolean[] visit = new boolean[len + 1]; 
		int edgeNum = sc.nextInt(); //간선의 개수
		int start = sc.nextInt(); //시작 노드
		for(int i=0; i< edgeNum ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
			graph[b][a] = 1;
		} 
		// input 입력완료
		
		dfs(graph,visit, start);
	}
}
