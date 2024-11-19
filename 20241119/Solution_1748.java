import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        for(int i=1; i<=N; i++) {
            int temp = 0;
            int now = i;

            while(true) {
                if(now / 10 >= 1) {
                    temp++;
                    now /= 10;
                } else {
                    break;
                }
            }
            answer += temp + 1;
        }

        System.out.println(answer);
    }
}
