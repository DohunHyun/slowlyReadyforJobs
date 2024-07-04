import java.io.*;

public class Solution_19941 {
    static int N, K, answer;
    static String[] table;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);

        table = br.readLine().split("");
        answer = 0;

        for(int i=0; i<N; i++) {
            if(table[i].equals("P")) {
                boolean isleft = false;
                for(int j=i-K; j<i; j++) {
                    if(j >= 0) {
                        if(table[j].equals("H")) {
                            table[j] = "E";
                            answer++;
                            isleft = true;
                            break;
                        }
                    }
                }
                if(!isleft) {
                    for(int j=i+1; j<=i+K; j++) {
                        if(j<N) {
                            if(table[j].equals("H")) {
                                table[j] = "E";
                                answer++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
