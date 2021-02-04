
import java.util.HashMap;
import java.util.Map;


public class BlyricsSearch {
    static int cnt = 0 ;
    static Trie[] preTries = new Trie[10001];
    static Trie[] suffTries = new Trie[10001];
    
    public static int[] solution(String[] words, String[] queries) {
        for(int i=1; i<=10000 ; i++) {
            preTries[i] = new Trie();
            suffTries[i] = new Trie(); 
        }
        int[] answer = new int[queries.length];
        
        StringBuilder sb;
        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();
            preTries[len].insert(words[i]); 

            // 뒤집어서
            sb = new StringBuilder(words[i]);
            String reversed = sb.reverse().toString();
            // suffixTrie.insert(reversed);
            suffTries[len].insert(reversed);
        }

        // 한 쿼리당 전체 단어들 검사
        // 1. 길이 안맞으면 ㄴㄴ
        // 2. 접두, 접미인지 확인
        // 3. 접두면 접두트라이에서 탐색 , 접미면 접미트라이에서 탐색
        for (int i = 0; i < queries.length; i++) {

            int len = queries[i].length();

            // 2. ????? 인지 검사
            if (queries[i].charAt(0) == '?' && queries[i].charAt(queries[i].length() - 1) == '?') {
                for (int j = 0; j < words.length; j++) {
                    if (queries[i].length() == words[j].length())
                        answer[i]++;
                }
                // break;
            } else if (queries[i].charAt(queries[i].length() - 1) == '?') {
                String[] split = queries[i].split("\\?");
                StringBuilder key = new StringBuilder(split[0]);
                // 접두일 때
                int count = preTries[len].contains(key.toString());
                if (count != 0) {
                    answer[i] += count;
                }
            } else if (queries[i].charAt(0) == '?') {
                String[] split = queries[i].split("\\?");            
                StringBuilder key = new StringBuilder(split[split.length-1]);
                int count = suffTries[len].contains(key.reverse().toString());
                if ( count != 0) {
                    answer[i]+= count;
                }
            }
            // System.out.println("cnt : "+answer[i]);
        }
        return answer;
    }

    public static class Trie {
        // 노드 클래스
        public static class TrieNode {
            // 자식노드 맵
            // 마지막인지 아닌지
            private Map<Character, TrieNode> childNodes = new HashMap<>();
            private boolean isLastChar;
            int cnt = 0;

            // GETTER , SETTER
            // 자식노드맵 GETTER
            Map<Character, TrieNode> getChildNodes() {
                return this.childNodes;
            }

            // 마지막 글자 여부
            boolean isLastChar() {
                return this.isLastChar;
            }

            // 마지막 글자인지 SETTER
            void setIsLastChar(boolean isLastChar) {
                this.isLastChar = isLastChar;
            }

            
        }

        // ---------------------------------------트리
        // 루트노드
        private TrieNode rootNode;
        int cnt;

        // 생성자
        Trie() {
            rootNode = new TrieNode();
            cnt = 0;
        }

        // insert
        void insert(String word) {
            TrieNode thisNode = this.rootNode;

            // 해당 문자가 노드로 존재하는지 확인하고, 없다면 새로 만들어줌
            for (int i = 0; i < word.length(); i++) {
                thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
                thisNode.cnt++;
            }
            // 마지막 노드를 마지막임을 표시
            thisNode.setIsLastChar(true);
        }

        // contains
        int contains(String word) {
            TrieNode thisNode = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                TrieNode node = thisNode.getChildNodes().get(character);

                if (node == null)
                    return 0;

                thisNode = node;
            }
            return thisNode.cnt;
        }
    }
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "f????", "fro???", "pro?"};
        int[] ans = solution(words,queries );
        for(int i=0; i<queries.length; i++) {

            System.out.print(ans[i] +" ");
        }
        // System.out.println(preTries[5].cnt);
    }
}
