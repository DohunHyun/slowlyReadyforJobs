import java.util.Scanner;

public class Solution {
	static int answer = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] time = new int[N];
		int[] money = new int[N];

		for(int i=0; i<N; i++) {
			time[i] = sc.nextInt();
			money[i] = sc.nextInt();
		}

		search(0, 0, 0, time, money);
		System.out.println(answer);
	}

	public static void search(int index, int max, int working, int[] time, int[] money) {
		if(index == time.length) { // 종료조건
			answer = max > answer ? max : answer;
			return;
		}

		if(working == 0) { // 일 안하고 있을때, 일 하거나 안하거나
			if(index + time[index] <= time.length) { // 남은 일수랑 제작일수 비교
				search(index+1, max + money[index], time[index]-1, time, money);
			}
			// 제작 안하고 넘어가는 경우
			search(index+1, max, 0, time, money);
		} else { // 지금 일 중일때
			search(index+1, max, working-1, time, money);
		}
	}
}
