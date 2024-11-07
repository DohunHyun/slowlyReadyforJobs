import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long count = 1;
        long sum = 0;
        while(sum < S) {
            sum += count;
            if(sum > S) {
                break;
            }
            count++;
        }

        System.out.println(count - 1);
    }
}
