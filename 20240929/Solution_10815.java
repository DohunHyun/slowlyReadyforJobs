import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_10815 {
    static int N, M;
    static int[] cards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        cards = new int[N];

        String[] split = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            cards[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(cards);

        M = Integer.parseInt(br.readLine());

        split = br.readLine().split(" ");
        for(int i=0; i<M; i++) {
            int answer = binarySearch(Integer.parseInt(split[i]));
            bw.write(answer + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static int binarySearch(int num) {
        int left = 0;
        int right = N-1;

        while(left <= right) {
            int middle = (left+right) / 2;
            int middleValue = cards[middle];

            if (num > middleValue) {
                left = middle + 1;
            } else if(num < middleValue) {
                right = middle - 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
