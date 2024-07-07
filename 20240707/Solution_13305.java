import java.io.*;

public class Solution_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] roads = new int[N-1];
        int[] price = new int[N];

        String[] split = br.readLine().split(" ");
        for(int i=0; i<N-1; i++) {
            roads[i] = Integer.parseInt(split[i]);
        }

        split = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            price[i] = Integer.parseInt(split[i]);
        }

        long sum = 0;
        long minPrice = price[0];

        for(int i=0; i<N-1; i++) {
            if(price[i] < minPrice) {
                minPrice = price[i];
            }

            sum += minPrice * roads[i];
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
