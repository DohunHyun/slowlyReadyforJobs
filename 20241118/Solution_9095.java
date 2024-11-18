import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_9095 {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] inputs = new int[T];

        for(int i=0; i<T; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<T; i++) {
            // inputs[i] 에 대해서 모든 경우의 수 구해보기
            int number = inputs[i];
            answer = 0;
            dfs(number);
            System.out.println(answer);
        }
    }
    static void dfs(int number) {
        if(number == 0) {
            answer++;
            return;
        }

        if(number < 0) {
            return;
        }

        dfs(number - 1);
        dfs(number - 2);
        dfs(number - 3);
    }
}
