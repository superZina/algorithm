
import  java.util.*;
import java.util.Arrays;
public class B2751 {
	public static void qSort(int[] arr) {
		qSort(arr, 0,arr.length - 1);
	}
	public static void qSort(int[] arr, int start, int end) {
		int part2 = partition(arr, start, end);
		if (start < part2 - 1) {
			qSort(arr, start , part2 - 1 );
		}
		if(part2 < end) {
			qSort(arr , part2 , end);
		}
	}
	public static int partition( int[] arr, int start , int end ) {
		int pivot = arr[(start+end) / 2];
		while(start <= end) {
			while(arr[start] < pivot) start++;
			while(arr[end] > pivot) end--;
			if(start <= end) {
				swap(arr, start, end) ;
				start++;
				end--;
			}
		}
		return start;
	}
	public static void swap (int[] arr, int start , int end ) {
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	}
	public static void printArr(int[] arr) {
		for(int data : arr) {
			System.out.println(data);
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] nums = new int[10000];
		for(int i=0; i<count ; i++) {
			nums[i] = sc.nextInt();
			//System.out.print( nums[i] + " ");
		}
		qSort(nums);
		printArr(nums);
		
	}
}
