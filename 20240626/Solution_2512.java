import java.io.*;

public class Solution_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        String[] split = br.readLine().split(" ");

        int max = 0;
        for(int i=0; i<N; i++) {
            list[i] = Integer.parseInt(split[i]);
            if(list[i] > max) {
                max = list[i];
            }
        }

        int M = Integer.parseInt(br.readLine());
        while(true) {
            int temp = 0;
            for(int i=0; i<N; i++) {
                if(list[i] > max) {
                    list[i]--;
                }
                temp += list[i];
            }

            if(temp <= M) {
                break;
            }
            max--;
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
