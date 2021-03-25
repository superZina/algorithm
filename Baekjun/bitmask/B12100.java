import java.io.BufferedReader;
import java.io.*;


public class B12100 {
    static int LIMIT = 5;
    static int n;
    static public class block {
        int num;
        boolean combined;
        public block(int num, boolean combined) {
            this.num = num;
            this.combined = combined;
        }
    }

    static int[] gen(int k) {
        int[] dir = new int[LIMIT];
        for (int i = 0; i < LIMIT; i++) {
            dir[i] = (k & 3);
            k >>= 2; // 2개씩 옮겨감
        }
        return dir;
    }

    // 입력인자 : arr, 방향 (dir)
    static int check(int[][] arr, int[] dir) {
        int max = 0;
        block[][] Blocks = new block[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Blocks[i][j] = new block(arr[i][j], false);
            }
        }
        for (int k : dir) {
            // combined를 false로 바꿔줘야함
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Blocks[i][j].combined = false;
                }
            }
            if (k == 0) { // 위쪽으로
                while (true) {
                    boolean moved = false;
                    for (int i = 0; i < n-1; i++) {
                        for (int j = 0; j < n; j++) {
                            if (Blocks[i + 1][j].num == 0)
                                continue;
                            if (Blocks[i][j].num == 0) {
                                Blocks[i][j].num = Blocks[i + 1][j].num;
                                Blocks[i][j].combined = Blocks[i + 1][j].combined;
                                Blocks[i + 1][j].num = 0;
                                moved = true;
                            } else if (Blocks[i][j].num == Blocks[i + 1][j].num) {
                                if(!Blocks[i][j].combined && !Blocks[i+1][j].combined) {// 합치지 않았다면 합치기
                                    Blocks[i][j].num *= 2;
                                    Blocks[i][j].combined = true;
                                    Blocks[i+1][j].num = 0;
                                    moved = true;
                                }
                            }
                        }
                    }
                    if(!moved) break;
                }
            } else if (k == 1) { // 아래쪽으로
                while (true) {
                    boolean moved = false;
                    for (int i = n-1; i >= 1; i--) {
                        for (int j = 0; j < n; j++) {
                            if (Blocks[i - 1][j].num == 0)
                                continue;
                            if (Blocks[i][j].num == 0) {
                                Blocks[i][j].num = Blocks[i - 1][j].num;
                                Blocks[i][j].combined = Blocks[i - 1][j].combined;
                                Blocks[i - 1][j].num = 0;
                                moved = true;
                            } else if (Blocks[i][j].num == Blocks[i - 1][j].num) {
                                if(!Blocks[i][j].combined && !Blocks[i-1][j].combined) {// 합치지 않았다면 합치기
                                    Blocks[i][j].num *= 2;
                                    Blocks[i][j].combined = true;
                                    Blocks[i-1][j].num = 0;
                                    moved = true;
                                }
                            }
                        }
                    }
                    if(!moved) break;
                }
            } else if (k == 2) {// 왼쪽으로
                while (true) {
                    boolean moved = false;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n-1; j++) {
                            if (Blocks[i][j+1].num == 0)
                                continue;
                            if (Blocks[i][j].num == 0) {
                                Blocks[i][j].num = Blocks[i][j+1].num;
                                Blocks[i][j].combined = Blocks[i][j+1].combined;
                                Blocks[i][j+1].num = 0;
                                moved = true;
                            } else if (Blocks[i][j].num == Blocks[i][j+1].num) {
                                if(!Blocks[i][j].combined && !Blocks[i][j+1].combined) {// 합치지 않았다면 합치기
                                    Blocks[i][j].num *= 2;
                                    Blocks[i][j].combined = true;
                                    Blocks[i][j+1].num = 0;
                                    moved = true;
                                }
                            }
                        }
                    }
                    if(!moved) break;
                }
            } else {
                while (true) {
                    boolean moved = false;
                    for (int i = 0; i < n; i++) {
                        for (int j = n-1; j >= 1; j--) {
                            if (Blocks[i][j-1].num == 0)
                                continue;
                            if (Blocks[i][j].num == 0) {
                                Blocks[i][j].num = Blocks[i][j-1].num;
                                Blocks[i][j].combined = Blocks[i][j-1].combined;
                                Blocks[i][j-1].num = 0;
                                moved = true;
                            } else if (Blocks[i][j].num == Blocks[i][j-1].num) {
                                if(!Blocks[i][j].combined && !Blocks[i][j-1].combined) {// 합치지 않았다면 합치기
                                    Blocks[i][j].num *= 2;
                                    Blocks[i][j].combined = true;
                                    Blocks[i][j-1].num = 0;
                                    moved = true;
                                }
                            }
                        }
                    }
                    if(!moved) break;
                }
            }            
        }
        for(int i=0 ; i<n; i++) {
            for(int j=0 ; j<n; j++) {
                max = Math.max(max, Blocks[i][j].num);
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i=0 ; i<n; i++) {
            String[] inputs = br.readLine().split(" ");
            for(int j=0 ; j<n; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        int max = 0;
        for(int i=0 ; i<(1<<LIMIT*2); i++) {
            int[] dir = gen(i);
            max = Math.max(check(arr, dir), max);
        }
        System.out.println(max);
    }
}
