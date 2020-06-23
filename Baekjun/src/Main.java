

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	@SuppressWarnings("null")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> list = new LinkedList<>();
		ArrayList<Integer> Josep = new ArrayList<Integer>();
		int people = sc.nextInt();
		int num = sc.nextInt();
		
		for(int i=0 ;i<people; i++) { //사람 수 대로 리스트 생성(큐이기 때문에 거꾸로 넣는다)
			list.offer(i+1);
		}
		
		int tmp;
		
		while(!list.isEmpty()) {	
			for(int i=0; i<num-1 ;i++) { //num -1번동안 자리바꿈(num번째 삭제하기 위함)
				if(!list.isEmpty()) {
				tmp = list.remove();
				list.offer(tmp);
				}
			}
			Josep.add(list.poll()); //지우는 원소 Arraylist에 넣음
		}
	
		System.out.print("<");
		for(int i=0;i<Josep.size();i++) {
			System.out.print(Josep.get(i));
			if(i != Josep.size()-1) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
	}
}






