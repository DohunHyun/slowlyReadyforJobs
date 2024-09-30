import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2792 {
    static int N, M, max;
    static int[] colors;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]); // 아이들 수
        M = Integer.parseInt(split[1]); // 색상 수
        colors = new int[M];

        for(int i=0; i<M; i++) {
            colors[i] = Integer.parseInt(br.readLine());
            if(max < colors[i]) {
                max = colors[i];
            }
        }

        System.out.println(binarySearch());
    }

    // 최소 질투심 값을 찾는 이진탐색
    static int binarySearch() {
        int min = Integer.MAX_VALUE;
        int left = 1;
        int right = max; // 하나의 보석중 개수가 가장 많은 색의 보석 개수

        while(left <= right) {
            int mid = (left + right) / 2; // 질투심 값
            int sum = 0; // 사람 숫자

            for(int i=0; i<colors.length; i++) {
                // 현재 질투심 = mid
                // 현재 질투심을 성립하게 할 수 있는 최소 인원 구하기
                // 각 색생별로 질투심 만큼 소모해서 각각 사람에게 나눠준다.
                // 나누어 떨어지면 딱 맞지만 아니라면 사람 1명 더 필요
                int people = 0;
                if(colors[i] % mid == 0) {
                    people += colors[i] / mid;
                } else {
                    people += colors[i] / mid + 1;
                }
                sum += people;
            }

            if(N >= sum) { // 현재 설정한 인원 안에서 해결 가능
                min = Math.min(min, mid);
                right = mid - 1; // 최솟값을 찾기 위해서니까 왼쪽으로 다시 검색
            } else { // 인원 부족 >> 더 많이씩 나눠주기 > 질투심 증가
                left = mid + 1;
            }
        }
        return min;
    }
}
