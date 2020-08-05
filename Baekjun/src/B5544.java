import java.util.*;
public class B5544 {
	public static void main(String args[] ) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		int[] teams = new int[n+1];
		int NUM = n*(n-1)/2;
		for(int i=0; i<NUM; i++) {
			int Ateam = sc.nextInt();
			int Bteam = sc.nextInt();
			int Ascore= sc.nextInt();
			int Bscore = sc.nextInt();
			//Ascore > Bscore 
			if(Ascore > Bscore) {
				teams[Ateam] += 3;
			}else if(Ascore < Bscore) {
				teams[Bteam] += 3;
			}else if(Ascore == Bscore) {
				teams[Bteam] += 1;
				teams[Ateam] += 1;
			}
		}
		
		int[] score = new int[teams.length];
		for(int i =1 ; i<teams.length; i++) {
			int max = -9999;
			int maxIdx = 0;
			for(int j=1;j<teams.length;j++) {
				if(score[j] ==0 && teams[j] > max) {
					max = teams[j];
					maxIdx = j;	
//					score[j] = i;
				}
			}
			score[maxIdx] = i;
			for(int k = maxIdx+1; k<teams.length;k++) {
				if(teams[k] == teams[maxIdx]) {
					score[k] = score[maxIdx];
					i++;
				}
			}
//			System.out.println("score["+maxIdx+"] : "+i);
		}
		for(int i=1; i<teams.length; i++) {
			System.out.println(score[i]);
		}
	}
}
