import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805 {
    static int N, M;
    static int[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        trees = new int[N];

        split = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            trees[i] = Integer.parseInt(split[i]);
        }

        int low = 0;
        int high = 1000000000;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            long sum = 0;
            for(int len : trees) {
                if(len > mid) {
                    sum += len - mid;
                }
            }
            if(sum >= M) { // 자른 나무의 합이 더 크다? -> 너무 낮게 자른거다. 자르는 높이를 더 높이 잘라보자
                low = mid;
            } else if(sum < M) {
                high = mid;
            }
        }

        System.out.println(low);
    }
}
