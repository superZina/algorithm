public class line {
    public int solution(int[][] boxes) {
        int answer = -1;
        boolean[] isPair = new boolean[10000001];
        int[] count = new int[10000001];
        for(int i=0; i<boxes.length; i++){
            for(int j=0;j<2; j++) {
                int idx = boxes[i][j];
                count[idx]++;
                if(count[idx]>1){
                isPair[idx] = true;
                }
            }
        }
        int pair = 0;
        for(int i=0; i<isPair.length;i++) {
            if(isPair[i]){
                pair++;
            }
        }

        if(pair >= boxes.length) {
            answer = 0 ;
        }else {
            answer = boxes.length - pair;
        }
        
        return answer;
    }
}
