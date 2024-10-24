import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1654 {
    static int K, N;
    static long[] lan;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        K = Integer.parseInt(split[0]); // 가지고 있는 랜선의 개수
        N = Integer.parseInt(split[1]); // 필요한 랜선의 개수
        lan = new long[K];

        for(int i=0; i<K; i++) {
            lan[i] = Long.parseLong(br.readLine());
        }

        long low = 1;
        long high = (long) Math.pow(2, 31);
        while(low + 1 < high) {
            long mid = (low + high) / 2;

            if(check(mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        System.out.println(low);
    }

    static boolean check(long length) {
        long count = 0;
        for(int i=0; i<K; i++) {
            count += lan[i] / length;
        }

        if(count >= N) { // N보다 크다? 더 길게 잘라보자
            return true;
        }
        return false;
    }
}
