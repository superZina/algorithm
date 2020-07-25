import java.util.*;

public class B2263 {
	static int[] inorder;
	static int[] post; 
	static boolean[] visited;

	public static void GO(int left , int rootIdx , int right) { //root : 그 전 트리의 루트 노드
		if(!visited[rootIdx]) {
		System.out.print(inorder[rootIdx] + " "); //현재 subarray의 root
		}
		visited[rootIdx] = true;
//		System.out.println("left : " +left);
//		System.out.println("right : " +right);
		if(left <=0 || right <=0) {
			return;
		}else {
			//왼쪽 루트를 찾음
			int leftRootIdx =0;
			for(int i=post.length -1; i>=0 ; i--) {
				for(int j=0; j<left;j++) {
					if(post[i] == inorder[j]) {
						leftRootIdx = j; //왼쪽에서 루트 노드 찾음 
						break;
					}
				}
			}
			
			int rightRootIdx = 0;
			for(int i= post.length -1 ; i>=0; i-- ) {
				for(int j = rootIdx+1; j<=right ; j++) {
					if(post[i] == inorder[j]) {
						rightRootIdx = j; //오른쪽에서 루트 노드 찾음
//						System.out.println("rightIdx : "+rightRootIdx);
						break;
					}
				}
			}
			
			//왼쪽 
			if(left != 0) {
			GO(leftRootIdx,leftRootIdx,left-leftRootIdx);
			}
			//오른쪽
			if(right !=0) {
			GO(rightRootIdx - rootIdx,rightRootIdx,inorder.length - rightRootIdx);
			}
		}
		
	}
	public static void main(String[] args) {
//		t = new Tree(); 
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		visited = new boolean[n];
		for(int i=0 ; i<n;i++) {
			visited[i] = false;
		}
//		t.setSize(n);
//		System.out.print(t.nodes.length);
		inorder = new int[3];
		post = new int[3];
		for(int i=0; i<3; i++) {
			inorder[i] = sc.nextInt();
		}
		for(int i=0; i<3; i++) {
			post[i] = sc.nextInt();
		}
//		Node n1 = new Node();
//		t.createNode(null, post[post.length -1 ],null);
//		n1.data = post[post.length -1]; 
//		t.setRoot(n1);
//		
		int rootIdx = 0;
		for(int i=0; i<inorder.length; i++) {
			if( inorder[i] == post[post.length - 1]) {
				rootIdx = i;
			}
		}
//		GO(t, Arrays.copyOfRange(inorder, 0, rootIdx -1), rootIdx , Arrays.copyOfRange(inorder, rootIdx+1, inorder.length));
//		for(int i=0; i<t.nodes.length; i++) {
//			System.out.println(t.nodes[i].data);
//		}
		GO(rootIdx,rootIdx,inorder.length-rootIdx);
		
	}
}
