import java.util.Scanner;

public class B11057 {
	public static void main(String[] args) {
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}	;
	
		int result = 0;
		int maxInit = 0;
		int maxlast = 0;
		int Max = -333333;

		int min = 3333333;
				for(int k =0; k<gems.length; k++) {
					System.out.println("k : "+ k);
					for(int m = k+1; m<gems.length;m++) {
						int[] kind = new int[gems.length];
						for(int i=k; i<m; i++){
						    for(int j= i; j<=m; j++){
						    	if(i==j) {
						    		continue;
						    	}else {
						        if(gems[i]==gems[j]){
						        kind[j] = 1;
					    		}
						    	}
					    	}
						}
						int kinds = 0;
						for(int g=0;g<kind.length;g++) {
							System.out.print(kind[g]);
						}
						System.out.println();
						for(int l=k; l<kind.length;l++) {
							kinds += kind[l];
						}
						result = m-k+1 - kinds;
						System.out.println("Max : "+result);
						if(result > Max) {		
							int resultMin = -33333;
							for(int l=k; l<kind.length;l++) {
								resultMin += kind[l];
							}
							if(resultMin < min) {
								Max = result;
								maxInit = k;
								maxlast = m;
							}
							}
						}
					}
				System.out.print(Max+"\n");
				System.out.print("init : "+maxInit+" las : "+maxlast);
	}
}
