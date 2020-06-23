import java.util.Scanner;

public class B10844 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count =0;
		int range = 1;
		for(int i=0;i<N;i++) {
			range *= 10;
		}
		if(range == 10) System.out.println(9);
		else {
			String[] nums = new String[N];
			for(int i=range/10;i<range;i++) {
				String ss = Integer.toString(i);
				nums = ss.split("");
				for(int j=0;j<nums.length;j++) {
					if(j == nums.length -1) count++;
					else if(Integer.parseInt(nums[j+1])-Integer.parseInt(nums[j])==1 && j!=nums.length-1) {
						continue;
					}
				}
			}	
		}
		System.out.println(count);
	}
}
