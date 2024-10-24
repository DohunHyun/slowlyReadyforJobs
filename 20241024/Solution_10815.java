import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_10815 {
    static int N, M;
    static int[] hands;
    static int[] questions;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        hands = new int[N];
        String[] split = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            hands[i] = Integer.parseInt(split[i]);
        }

        M = Integer.parseInt(br.readLine());
        questions = new int[M];
        split = br.readLine().split(" ");
        for(int i=0; i<M; i++) {
            questions[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(hands);

        for(int i=0; i<M; i++) {
            int low = 0;
            int high = N;
            // 각 카드가 questions[i], hands 안에 있는지 확인.
            while(low + 1 < high) {
                int mid = (low + high) / 2;

                if(check(questions[i], hands[mid])) { // mid보다 더 크다면
                    low = mid;
                } else {
                    high = mid;
                }
            }
            if(hands[low] == questions[i]) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }

    }

    static boolean check(int number, int mid) {
        if(number >= mid) {
            return true;
        }
        return false;
    }
}
