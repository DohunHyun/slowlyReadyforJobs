import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        String L = split[0];
        String R = split[1];

        int answer = 0;

        if(L.length() == R.length()) {
            int i=0;
            while (i < L.length() && L.charAt(i) == R.charAt(i)) {
                if(L.charAt(i) == '8') {
                    answer++;
                }
                i++;
            }
        }
        System.out.println(answer);
    }
}
