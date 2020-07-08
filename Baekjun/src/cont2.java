import java.util.*;
public class cont2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		long[] mem = new long[num];
		for(int i=0; i<num ; i++) {
			mem[i] = sc.nextInt();
		}
		long cluster = sc.nextInt(); 
		long result = 0;
		for(int i=0; i<num; i++) {
			if(mem[i] != 0) { //0이면 클러스터가 필요없다 
			   if (mem[i] >= cluster) {
				long clusterNum = mem[i]/cluster;
				long clusterRest = mem[i]%cluster;
				if(clusterRest!= 0) {
					result += (clusterNum + 1)*cluster;
				}else {
					result += clusterNum*cluster;
				}
			}else if( mem[i] < cluster) {
				result += cluster;
			}
			}
		}
		System.out.print(result);
	}
	}
