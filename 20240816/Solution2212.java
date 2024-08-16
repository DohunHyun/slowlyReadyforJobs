import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2212 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] sensors = new int[N];

        String[] split = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            sensors[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(sensors);

        int[] diff = new int[N-1];
        for(int i=0; i<N-1; i++) {
            diff[i] = sensors[i+1] - sensors[i];
        }

        Arrays.sort(diff);

        int answer = 0;
        for(int i=0; i<N-K; i++) {
            answer += diff[i];
        }

        System.out.println(answer);
    }
}
