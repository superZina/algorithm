import java.util.Scanner;

public class B1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] Dyn = new int[1000000];
		Dyn[0] = 0;
		int num = sc.nextInt();
		for(int i=1 ; i<num ; i++) {
			if((i+1)%2 != 0 && (i+1)%3 != 0) { //2,3의 배수가 아닐때
				Dyn[i] = 1 + Dyn[i-1];
			}else if((i+1)%2 ==0 && (i+1)%3 != 0) {
				Dyn[i] = Math.min(Dyn[i/2],Dyn[i-1])+1;
			}else if((i+1)%3 ==0 && (i+1)%2 != 0) {
				Dyn[i] = Math.min(Dyn[i/3],Dyn[i-1])+1;			
			}else if((i+1)%3 ==0 && (i+1)%2 == 0){
				int min = Math.min(Dyn[i/2],Dyn[i/3])+1;
				Dyn[i] =  Math.min(min,Dyn[i-1]+1);
			}
		}
		System.out.print(Dyn[num-1]);
	}
}