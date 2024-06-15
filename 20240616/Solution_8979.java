import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int K = Integer.parseInt(input.split(" ")[1]);
        int[][] medal = new int[N+1][3];

        for(int i=1; i<=N; i++) {
            String[] split = br.readLine().split(" ");
            medal[Integer.parseInt(split[0])][0] = Integer.parseInt(split[1]);
            medal[Integer.parseInt(split[0])][1] = Integer.parseInt(split[2]);
            medal[Integer.parseInt(split[0])][2] = Integer.parseInt(split[3]);
        }

        int answer = 1;
        for(int i=1; i<=N; i++) {
            if(medal[K][0] < medal[i][0]) {
                answer++;
                continue;
            }
            if(medal[K][0] == medal[i][0]) {
                if(medal[K][1] > medal[i][1]) {
                    continue;
                }
                if(medal[K][1] < medal[i][1]) {
                    answer++;
                    continue;
                }
                if(medal[K][1] == medal[i][1]) {
                    if(medal[K][2] < medal[i][2]) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}