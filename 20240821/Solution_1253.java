import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        String[] split = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(numbers);

        int result = 0;

        for(int i=0; i<N; i++) {
            int left = 0;
            int right = N-1;

            while (true) {
                if(left == i) left++;
                else if (right == i) right--;

                if(left >= right) break;

                if(numbers[left] + numbers[right] > numbers[i]) right--;
                else if(numbers[left] + numbers[right] < numbers[i]) left++;
                else {
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
