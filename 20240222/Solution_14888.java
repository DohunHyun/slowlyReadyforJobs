import java.util.Scanner;

public class Solution_14888 {
	static int N;
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	static int[] array;
	static int PLUS, MINUS, MULTIPLE, DIVIDE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		array = new int[N];
		for(int i=0; i<N; i++) {
			array[i] = sc.nextInt();
		}

		PLUS = sc.nextInt();
		MINUS = sc.nextInt();
		MULTIPLE = sc.nextInt();
		DIVIDE = sc.nextInt();

		// 재귀로?
		find(PLUS, MINUS, MULTIPLE, DIVIDE, 0, new String[N-1]);

		System.out.println(MAX);
		System.out.println(MIN);

	}

	static void find(int plus, int minus, int multiple, int divide, int idx, String[] signArray) {
		if(plus+minus+multiple+divide == 0) {
			int result = calcSum(signArray);
			if(result > MAX) {
				MAX = result;
			}
			if(result < MIN) {
				MIN = result;
			}
			return;
		}

		if(plus > 0) {
			signArray[idx] = "PLUS";
			find(plus-1, minus, multiple, divide, idx+1, signArray);
		}

		if(minus > 0) {
			signArray[idx] = "MINUS";
			find(plus, minus-1, multiple, divide, idx+1, signArray);
		}

		if(multiple > 0) {
			signArray[idx] = "MULTIPLE";
			find(plus, minus, multiple-1, divide, idx+1, signArray);
		}

		if(divide > 0) {
			signArray[idx] = "DIVIDE";
			find(plus, minus, multiple, divide-1, idx+1, signArray);
		}
	}

	static int calcSum(String[] signArray) {
		int sum = array[0];

		for(int i=1; i<N; i++) {
			if(signArray[i-1].equals("PLUS")) {
				sum += array[i];
			}
			if(signArray[i-1].equals("MINUS")) {
				sum -= array[i];
			}
			if(signArray[i-1].equals("MULTIPLE")) {
				sum *= array[i];
			}
			if(signArray[i-1].equals("DIVIDE")) {
				if(sum < 0) {
					sum = ((sum*(-1)) / array[i]) * (-1);
				} else {
					sum = sum / array[i];
				}
			}
		}

		return sum;
	}
}
