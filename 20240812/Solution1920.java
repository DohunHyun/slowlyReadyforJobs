import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1920 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] array = new int[N];
        for(int i=0; i<N; i++) {
            array[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(array);

        int M = Integer.parseInt(br.readLine());
        split = br.readLine().split(" ");
        int[] targets = new int[M];
        for(int i=0; i<M; i++) {
            targets[i] = Integer.parseInt(split[i]);
        }
        for(int i=0; i<M; i++) {
            if(Arrays.binarySearch(array, targets[i]) >= 0) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }

        }
    }
}
