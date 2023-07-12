import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_2346 {
	static int N;
	static int[] array;
	public static void main(String[] args) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sb = new StringBuilder();

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		// N = Integer.parseInt(br.readLine());
		array = new int[N];

		// StringTokenizer input = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			array[i] = sc.nextInt();
			// array[i] = Integer.parseInt(input.nextToken());
		}

		int index = 0; // 현재위치
		// sb.append(index+1).append(" ");
		System.out.print(index+1 + " "); // 첫번째 순서에 번호
		for(int i=0; i<N-1; i++) {
			int d = array[index]; // 이동해야할 숫자
			array[index] = 0; // 터진 풍선 표시

			if(d > 0) { // 우측으로 이동
				// 앞으로 이동 d 만큼
				index = goForward(d, index);
			} else {
				index = goBack(d, index);
			}
			// sb.append(index+1).append(" ");
			System.out.print(index+1 + " ");
		}
		// System.out.println(sb);
	}

	public static int goForward(int d, int index) {
		while(d != 0) {
			if(index + 1 >= N) { // 배열 사이즈 넘어가면 처음으로 이동
				index = 0;
			} else {
				index++;
			}
			if(array[index] != 0) { // 터진 적이 없다면 카운트
				d--;
			}
		}
		return index;
	}
	public static int goBack(int d, int index) {
		while(d != 0) {
			if(index - 1 < 0) {
				index = N-1;
			} else {
				index--;
			}
			if(array[index] != 0) {
				d++;
			}
		}
		return index;
	}
}
