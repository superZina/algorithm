import java.util.*;
public class B2947 {
	public static void sort(int[] arr , int count) {
		if(count == 4) { //마지막일때 
			if(arr[0] == 1 && arr[1] == 2 && arr[2] == 3 && arr[3] == 4 && arr[4] == 5) {
				return;
			}else {
				sort(arr , 0);
			}
		}else { //마지막 비교가 아닐 때 
			if(arr[count]<arr[count+1]) { //뒤에것이 더 크면 바꾸지 않고 진행
				sort(arr,count+1);
			}else {
				int tmp = arr[count];
				arr[count] = arr[count+1];
				arr[count+1] = tmp;
				for(int i=0; i<5; i++) {
					System.out.print(arr[i]+ " ");
				}
				System.out.println();
				sort(arr,count+1); 
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] wood = new int[5];
		for(int i=0;i<5;i++) {
			wood[i] = sc.nextInt();
		}
		sort(wood,0);
		
	}
}
