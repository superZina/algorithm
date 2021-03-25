import java.util.ArrayList;

class solution {
    public static class Score{
        int sum; 
        String name;
        public Score(int sum , String name) {
            this.sum =sum;
            this.name = name;
        }
      
    }
    public static class myComparator implements Comparator<Score> {
        @Override
        public int compare(Score o1, Score o2) {
            if(o1.sum == o2.sum){
                return o1.name.compareTo(o2.name);
            }else{
                return o2.sum - o1.sum;
            }
        }
    }

    public String solution(String[] table, String[] languages, int[] preference) {
       
        ArrayList<Score> scores = new ArrayList<>();
        for(int i=0 ; i<table.length; i++) {
            String[] langs = table[i].split(" ");
            int sum = 0;
            for(int k=1 ; k<=5 ; k++) {
                for(int j=0 ; j<languages.length; j++) {
                    //해당 언어와 같다면
                    if(languages[j].equals(langs[k])) {
                        sum += preference[j]*(6-k);
                    }
                }
        }
            scores.add(new Score(sum, langs[0]));
        }
        Comparator myComparator = new myComparator();
        Collections.sort(scores, myComparator);
        String answer = scores.get(0).name;
        return answer;
    }
 
}