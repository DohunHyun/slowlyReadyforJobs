import java.util.Scanner;

public class Solution_9655 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int count = 0;

		while(N > 0) {

			if(N >= 3) {
				N -= 3;
			} else {
				N -= 1;
			}

			count++;
		}
		if(count%2 == 1) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}
}
