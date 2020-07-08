import java.util.*;

public class constest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String minsik = sc.next();
		int mL =0; int mO =0; int mV =0; int mE=0;
		for(int i=0 ; i<minsik.length() ; i++) {
				switch(minsik.charAt(i)) {
				case 'L':
					mL++;
					break;
				case 'O':
					mO++;
					break;
				case 'V':
					mV++;
					break;
				case 'E':
					mE++;
					break;
				}
		}	
		int n = sc.nextInt();
		int max = -9999;
		int maxIdx = 0;
		int[] percent = new int[n];
		String[] name = new String[n];
		int L =0;
		int O =0; int V =0; int E = 0;
		for(int i =0 ;i<n; i++) {
			name[i] = sc.next();
			for(int j=0 ;j<name[i].length() ; j++) {
				switch(name[i].charAt(j)) {
				case 'L':
					L++;
					break;
				case 'O':
					O++;
					break;
				case 'V':
					V++;
					break;
				case 'E':
					E++;
					break;
				}
			}
			System.out.println( L+ " " + O + " " + V +" "+ E);
//			int[] add = new int[6];
//			add[0] = mL+mO+L+O;
//			add[1] = mL+mV+L+V;
//			add[2] = mL+mE+L+E;
//			add[3] = mO+mV+O+V;
//			add[4] = mO+mE+O+E;
//			add[5] = mV+mE+V+E;
//			int sum = 1;
//			for(int k =0; k<6; k++) {
//				if(add[k] == 0) continue;
//				else sum *= add[k]; 
//			}
//			
			percent[i] = ((L+O)*(L+V)*(L+E)*(O+V)*(O+E)*(V+E))%100;
//			percent[i] = sum%100;
			System.out.println(percent[i]);
			if(percent[i] > max) {
				max = percent[i];
				maxIdx = i;
			}
			L = 0 ; O =0; V =0; E =0;
		}
		System.out.print(name[maxIdx]);
		System.out.print( mL+ " " + mO + " " + mV +" "+ mE);
	}
}
