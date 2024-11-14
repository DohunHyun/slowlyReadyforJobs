import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int E = Integer.parseInt(split[0]);
        int S = Integer.parseInt(split[1]);
        int M = Integer.parseInt(split[2]);

        int e = 1;
        int s = 1;
        int m = 1;

        int year = 1;

        while(!isSame(e, s, m, E, S, M)) {
            year++;
            e++;
            s++;
            m++;

            if(e > 15) {
                e = 1;
            }

            if(s > 28) {
                s = 1;
            }

            if(m > 19) {
                m = 1;
            }
        }

        System.out.println(year);
    }

    static boolean isSame(int e, int s, int m, int E, int S, int M) {
        return e == E && s == S && m == M;
    }
}
