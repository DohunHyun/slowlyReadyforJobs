import java.io.*;

public class Solution_17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 길 크기
        int M = Integer.parseInt(br.readLine()); // 가로등 개수

        int[] lights = new int[M];
        String[] split = br.readLine().split(" ");
        for(int i=0; i<M; i++) {
            lights[i] = Integer.parseInt(split[i]);
        }

        // 이분탐색
        int start = 1;
        int end = N;
        int answer = 0;

        while(start <= end) {
            int mid = (start + end) / 2;
            int temp = 0;
            for(int light : lights) {
                if(light - mid > temp) {
                    start = mid + 1;
                    break;
                }
                temp = light + mid;
            }

            if(temp < N) {
                start = mid + 1;
                continue;
            }

            answer = mid;
            end = mid - 1;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
