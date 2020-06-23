import java.util.*;
public class Combination {
	static boolean[] visit;
	static int[] Arr;
	public static void print() {
		for(int i=0;i<5; i++) {
			if(visit[i]) {
				System.out.print(Arr[i]+ " ");
			}
		}
		System.out.println();
	}
	public static void Com(int start,int count,int r) { //start:시작점,count:몇번째인지,r: 뽑으려는 수의 개수
		

		if(count == r) { //r개를 모두 다 뽑았을 
			print();
			return;
		}
		for (int i=start;i<5 ;i++) {
			if (visit[i] == true) continue;
			visit[i] = true;
			Com(i,count+1 , r);
			visit[i] = false; // false를 해줘야 다른 숫자 시작점에서 뽑을 수 있음
		}
	}
	public static void main(String[] arg) {
		visit = new boolean[5];
		Arr = new int[5];
		for(int i=0 ; i<Arr.length ; i++) {
			Arr[i] = i+1;
		}
		Com(0,0,3);
	}
}
