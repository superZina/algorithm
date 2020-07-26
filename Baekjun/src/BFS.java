import java.util.*;
public class BFS {
	static class Graph{
		int V; //노드의 개수 
		LinkedList<Integer> adj[]; //인접리스트 
		
		Graph(int v) {
			this.V = v;
			adj = new LinkedList[v];
			for(int i=0;i<v;i++) { //인접리스트 초기화 
				adj[i] = new LinkedList();
			}
		}
		void addEdge(int v, int w) {
			adj[v].add(w);
		}
		void BFS(int s) {
			boolean[] visited = new boolean[V];
			LinkedList<Integer> queue = new LinkedList<Integer>();
			
			visited[s] = true; //방문했음을 표시 
			queue.add(s); //큐에 추가 
			
			while(queue.size() != 0) {
				s = queue.poll();
				System.out.print(s + " ");
				
				Iterator<Integer> i = adj[s].listIterator(); //s노드의 인접한 노드들을 전부 가져옴 
				
				while(i.hasNext()) {
					int n = i.next();
					
					//방문하지 않은 노드라면 
					if(!visited[n]) {
						visited[n] = true;
						queue.add(n); //큐에 더해준다. 
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 4);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		
		g.BFS(0);
		
	}

}
