import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int[] arr;
    static char[] operators;
    static PriorityQueue<Integer> que = new PriorityQueue<>();
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    

    public static void go(int idx, int sum, int plus, int minus, int multiply, int sub) {
        if (idx == N) {
            if(sum < min) {
                min = sum;
            }
            if( sum > max) {
                max = sum;
            }
            return;
        }
        if (plus > 0) {
            go(idx + 1, sum + arr[idx], plus - 1, minus, multiply, sub);
        }
        if (minus > 0) {
            go(idx + 1, sum - arr[idx], plus, minus-1, multiply, sub);
        }
        if (multiply > 0) {
            go(idx + 1, sum * arr[idx], plus , minus, multiply-1, sub);
        }
        if (sub > 0) {
            go(idx + 1, sum / arr[idx], plus, minus, multiply, sub-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        arr = new int[N];
        operators = new char[N - 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }
        inputs = br.readLine().split(" ");
        go(1, arr[0], Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]),
                Integer.parseInt(inputs[3]));
        System.out.println(max);
        System.out.println(min);

    }
}

