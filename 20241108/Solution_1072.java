import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        long X = Integer.parseInt(split[0]); // 게임 횟수
        long Y = Integer.parseInt(split[1]); // 이긴 횟수
        long Z = 100 * Y / X;
        if(Z >= 99) {
            System.out.println(-1);
            return;
        }

        long low = 0;
        long high = 1000000000;
        while(low + 1 < high) {
            long mid = (low + high) / 2;
            long z = (100 * (Y + mid)) / (X + mid);
            if(z > Z) {
                high = mid;
            } else {
                low = mid;
            }
        }
        System.out.println(high);
    }
}
