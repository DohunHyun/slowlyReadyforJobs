import java.io.*;

public class Solution_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int X = Integer.parseInt(input.split(" ")[1]);

        int[] visitors = new int[N];

        String[] split = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            visitors[i] = Integer.parseInt(split[i]);
        }

        int sum = 0;
        for(int i=0; i<X; i++) {
            sum += visitors[i];
        }

        int max = sum;
        int count = 1;
        for(int i=X; i<N; i++) {
            sum += visitors[i] - visitors[i-X];

            if(sum > max) {
                max = sum;
                count = 1;
            } else if(sum == max) {
                count++;
            }
        }

        if(max == 0) {
            bw.write("SAD");
        } else {
            bw.write(max + "\n" + count);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
