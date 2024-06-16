import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] spec = new int[N][2];

        for(int i=0; i<N; i++) {
            String[] split = br.readLine().split(" ");
            spec[i][0] = Integer.parseInt(split[0]);
            spec[i][1] = Integer.parseInt(split[1]);
        }

        for(int i=0; i<N; i++) {
            int count = 1;
            for(int j=0; j<N; j++) {
                if(spec[i][0] < spec[j][0] && spec[i][1] < spec[j][1]) {
                    count++;
                }
            }
            System.out.print(count + " ");
        }
    }
}