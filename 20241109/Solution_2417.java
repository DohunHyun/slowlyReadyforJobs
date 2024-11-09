import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long low = 0;
        long high = Long.MAX_VALUE;

        if(N == 0) {
            System.out.println(0);
            return;
        }

        while(low + 1 < high) {
            long mid = (low + high) / 2;

            if(Math.pow(mid, 2) >= N) {
                high = mid;
            } else {
                low = mid;
            }
        }
        System.out.println(high);
    }
}
