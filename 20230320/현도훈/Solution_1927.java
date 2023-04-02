import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1927 {
	static int[] array;
	static int size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		array = new int[N+1];
		size = 1;
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x > 0) {
				add(x);
			} else if(x == 0) {
				System.out.println(delete());
			}
		}
	}

	private static void add(int x) {
		int temp = size;
		array[size] = x;
		while(temp >= 1 && x < array[temp/2]) {
			swap(temp, temp/2);
			temp = temp/2;
		}
		size++;
	}

	private static int delete() {
		int num = array[1];
		int temp = 1;
		if(size <= 1) return 0;
		array[1] = array[--size];
		array[size] = 0;
		while(temp < size && temp*2+1 < array.length &&
				((array[temp] > array[temp*2] && array[temp*2] > 0)
					|| (array[temp] > array[temp*2+1] && array[temp*2+1] > 0))) {
			if(array[temp] > array[temp*2] && array[temp*2] > 0) {
				if(array[temp*2] > array[temp*2+1] && array[temp*2+1] > 0) {
					swap(temp, temp*2+1);
					temp = temp*2+1;
				} else {
					swap(temp, temp*2);
					temp = temp*2;
				}
			} else if(array[temp] > array[temp*2+1] && array[temp*2+1] > 0) {
				swap(temp, temp*2+1);
				temp = temp*2+1;
			}
		}

		return num;
	}

	private static void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
