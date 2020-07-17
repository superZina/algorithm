import java.util.*;
public class B1021 {
	public static void main(String[] args) {
		LinkedList<Integer> que = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			que.add(i+1);;
		}
		int count = sc.nextInt();
		int res = 0;
		for(int i=0; i<count;i++) {
			int dnum = sc.nextInt();
//			System.out.println(dnum);
			int tmp =0;
			while(true) {
				int index =0;
				for(int j=0;j<que.size();j++) {
					int tmp2 = que.get(j);
					if(tmp2 == dnum) {
						index = j;
					}
				}
				//덱 개수가 짝수일 떄 
				if(((que.size()%2 ==0) && (index >= que.size()/2))|| 
						((que.size()%2 !=0 )&&(index >(que.size()/2)))) {
					//뒤에서 뽑아낸다 
					tmp = que.removeLast();
					if(dnum != tmp) {
						que.addFirst(tmp);
						res++;
//						for(int k=0; k<que.size(); k++) {
//							int tmp3 = que.removeFirst();
//							System.out.print(tmp3+ " ");
//							que.addLast(tmp3);
//						}
//						System.out.println("현재 수 : "+(i+1) + ", tmp : "+ tmp);
//						System.out.println("dnum : "+dnum);
//						System.out.println();
					}else if(dnum == tmp){
//						for(int k=0; k<que.size(); k++) {
//							int tmp3 = que.removeFirst();
//							System.out.print(tmp3+ " ");
//							que.addLast(tmp3);
//						}
//						System.out.println("현재 수 : "+(i+1) + ", tmp : "+ tmp);
//						System.out.println("dnum : "+dnum);
//						System.out.println();
						res++;
						break;
					}
				}else {
					tmp = que.removeFirst();
					if(dnum != tmp) {
						que.add(tmp);
						res++;
//						for(int k=0; k<que.size(); k++) {
//							int tmp3 = que.removeFirst();
//							System.out.print(tmp3+ " ");
//							que.addLast(tmp3);
//						}
//						System.out.println("현재 수 : "+(i+1) + ", tmp : "+ tmp);
//						System.out.println("dnum : "+dnum);
//						System.out.println();
					}else if(dnum == tmp){
//						for(int k=0; k<que.size(); k++) {
//							int tmp3 = que.removeFirst();
//							System.out.print(tmp3+ " ");
//							que.addLast(tmp3);
//						}
//						System.out.println("현재 수 : "+(i+1) + ", tmp : "+ tmp);
//						System.out.println("dnum : "+dnum);
//						System.out.println();
						break;
					}
				}
				
				
				
//				System.out.println("res : "+res);
			}
		}
		System.out.print(res);
	}
}
