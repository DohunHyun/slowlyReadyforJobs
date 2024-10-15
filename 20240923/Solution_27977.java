import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_27977 {
    static int L, N, K, answer;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        L = Integer.parseInt(split[0]); // 학교의 위치
        N = Integer.parseInt(split[1]); // 킥보드 충전소 개수
        K = Integer.parseInt(split[2]); // 충전소 방문 횟수
        map = new int[L+1];
        answer = 0;

        split = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            int locate = Integer.parseInt(split[i]);
            map[i] = locate; // 충전소 표시
        }

        int l = 0;
        int h = L;

        while(l+1 < h) {
            int m = (l+h)/2;
            if(check(l) == check(m)) {
                l = m;
            }
            if(check(h) == check(m)) {
                h = m;
            }
        }
        System.out.println(h);
    }

    static boolean check(int capacity) {
        int current = capacity; // 현재 용량
        int location = 0; // 현재위치
        int seen = 0; // ??
        int chargeCnt = 0; // 충전횟수

        while (current > 0 && location < L) {
            location++;
            current--;
            if(location == map[seen] && chargeCnt < K) { // 충전 가능한 상황
                int nextTarget = map[++seen] > 0 ? map[seen] : L;
                if(current < nextTarget - location) {
                    chargeCnt++;
                    current = capacity;
                }
            }
        }
        return !(current == 0 && location < L);
    }
}
