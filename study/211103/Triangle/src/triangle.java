
import java.util.*;

public class triangle {
	public static void main(String[] args) {
		
	}
	
    public int solution(int[][] triangle) {
    	tri = triangle;
    	height = tri.length;
    	dp = new int[tri.length][];
    	for(int i = 0; i < tri.length ; i++) {
    		dp[i] = new int[tri[i].length];
    		for(int j = 0 ; j < dp[i].length ; j ++) {
    			dp[i][j] = -1;
    		}
    	}
        int answer = dp(0,0);
               
        return answer;
    }
    
    static int[][] dp;
    static int[][] tri;
    static int height;
    
    public static int dp(int h , int x) {
    	//이미 경로가 있다면 해당 값 리턴  
    	if (dp[h][x] != -1) {
    		return dp[h][x];
    	}
    	
    	//마지막 위치라면 해당 위치의 값 리턴 
    	if (h == height - 1) {
    		return tri[h][x];
    	}
    	
    	dp[h][x] = Math.max(dp(h+1,x), dp(h+1,x+1)) + tri[h][x];
    	
    	return dp[h][x];
    }
	
}
