import java.util.*;

public class B2263 {
	static int[] inorder;
	static int[] post; 

	public static void GO(int left , int data , int right) { //root : 그 전 트리의 루트 노드 
		System.out.println(data + " "); //현재 subarray의 root
		System.out.println("left : " +left);
		System.out.println("right : " +right);
		if(left <=0 || right <=0) {
			return;
		}else {
		for(int i=0; i<inorder.length; i++) {
			if(inorder[i] == data ) { // 루트 위치를 찾음
				int leftRoot =0; 
				int rightRoot = 0; 
				for(int j=post.length-1;j>=0; j--) {
					for(int k=0;k<i;k++) {
						if(post[j] == inorder[k]) {
							System.out.println("left Root : "+ post[j]);
							leftRoot = j ; 
							break;
						}
					}
				}
				System.out.println("leftRoot : " + leftRoot);
				GO(leftRoot,inorder[leftRoot],left-leftRoot);
				for(int j=post.length-1;j>=0; j--) {
					for(int k=i+1;k<post.length;k++) {
						if(post[j] == inorder[k]) {
							rightRoot = j ; 
							break;
						}
					}
				}
				GO(rightRoot - left,inorder[rightRoot],inorder.length-rightRoot);
			}
		}
		}
		
	}
	public static void main(String[] args) {
//		t = new Tree(); 
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
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
		GO(rootIdx,post[post.length-1],post.length-rootIdx);
		
	}
}
