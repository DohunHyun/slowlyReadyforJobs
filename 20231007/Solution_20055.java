import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_20055 {
	static int N, K;
	static Belt[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		array = new Belt[2*N];
		// 객체 배열 만들땐 초기화 해줘야함
		for(int i=0; i<N*2; i++) {
			array[i] = new Belt();
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<2*N; i++) {
			array[i].durability = Integer.parseInt(st.nextToken());
		}

		boolean keepGoing = true;
		int stage = 1;

		while(keepGoing) {
			rotate();
			go();
			add();

			if(numberOf0() >= K) {
				keepGoing = false;
			} else {
				stage++;
			}
		}

		System.out.println(stage);
	}

	// 컨베이어벨트가 한칸 전진한다.
	static void rotate() {
		Belt[] temp = new Belt[N*2];
		temp[0] = array[N*2-1];
		for(int i=1; i<N*2; i++) {
			temp[i] = array[i-1];

			// 로봇 떨어지기
			if(i==N-1) {
				temp[i].isRobot = false;
			}
		}

		array = temp;
	}

	// 로봇들이 앞으로 한칸 이동
	static void go() {
		// 가장 앞에 있는 로봇부터,
		// 앞으로 이동 가능하면 이동.
		// 앞에 로봇이 없거나, 내구도가 1 이상이거나
		// 로봇이 이동하면 내구도는 감소한다.
		for(int i=N-2; i>=0; i--) {
			// 로봇이 있으면
			if(array[i].isRobot) {
				// 앞 로봇이 없고 내구도 괜찮으면 이동
				if(!array[i+1].isRobot && array[i+1].durability >= 1) {
					array[i].isRobot = false;
					array[i+1].isRobot = true;
					array[i+1].durability--;

					// 내리는 위치로 이동한 경우 바로 내린다.
					if(i+1 == N-1) {
						array[i+1].isRobot = false;
					}
				}
			}
		}
	}

	// 올리는 칸에 로봇올리기
	static void add() {
		if(array[0].durability != 0 ){
			array[0].isRobot = true;
			array[0].durability--;
		}
	}

	// 내구도가 0인 칸 개수
	static int numberOf0() {
		int count = 0;

		for(int i=0; i<N*2; i++) {
			if(array[i].durability == 0) count++;
		}
		return count;
	}

	static class Belt {
		int durability;
		boolean isRobot;

		Belt() {
			this.durability = 0;
			this.isRobot = false;
		}

		Belt(int durability, boolean isRobot) {
			this.durability = durability;
			this.isRobot = isRobot;
		}
	}
}
