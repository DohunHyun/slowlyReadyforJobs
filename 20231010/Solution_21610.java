import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_21610 {
	static int N, M;
	static int[][] map;
	static ArrayList<Cloud> visited;
	static boolean[][] visitedMap;
	static int[] orderDirection;
	static int[] orderDistance;
	static int totalAmountOfWater;
	static ArrayList<Cloud> cloudArray;
	// 이동 방향 <
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new ArrayList<>();
		visitedMap = new boolean[N][N];
		orderDirection = new int[M];
		orderDistance = new int[M];
		totalAmountOfWater = 0;
		cloudArray = new ArrayList<>();

		// 물의 양 저장
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 명령 저장
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			orderDirection[i] = Integer.parseInt(st.nextToken());
			orderDistance[i] = Integer.parseInt(st.nextToken());
		}

		// 스킬 실행
		castingSkill();

		// M번의 명량 실행
		for(int i=0; i<M; i++) {
			moveCloud(orderDirection[i], orderDistance[i]);
			rain();
			removeCloud();
			copyWater();
			makeCloud();
		}

		System.out.println(calcRain());

	}

	static class Cloud {
		int x;
		int y;

		Cloud(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void castingSkill() {
		cloudArray.add(new Cloud(N-1,0));
		cloudArray.add(new Cloud(N-1,1));
		cloudArray.add(new Cloud(N-2,0));
		cloudArray.add(new Cloud(N-2,1));
	}

	static void moveCloud(int direction, int distance) {
		cloudArray.forEach(cloud -> {
			int xx = cloud.x + (distance * dx[direction-1]);
			int yy = cloud.y + (distance * dy[direction-1]);
			// 이동할때 그 방향이 경계를 넘어서는지 확인.
			if(xx >= N) {
				while(xx >= N) {
					xx -= N;
				}
			}
			if(yy >= N) {
				while(yy >= N) {
					yy -= N;
				}
			}
			if(xx < 0) {
				while(xx < 0) {
					xx += N;
				}
			}
			if(yy < 0) {
				while(yy < 0) {
					yy += N;
				}
			}

			cloud.x = xx;
			cloud.y = yy;
		});
	}

	static void rain() {
		for(int i=0; i<cloudArray.size(); i++) {
			map[cloudArray.get(i).x][cloudArray.get(i).y]++;
			// 비왔던 땅 저장. 물복사버그 마법
			visited.add(new Cloud(cloudArray.get(i).x, cloudArray.get(i).y));
			visitedMap[cloudArray.get(i).x][cloudArray.get(i).y] = true;
		}
	}

	static void removeCloud() {
		cloudArray = new ArrayList<>();
	}

	static void copyWater() {
		// 비가 왔던 땅에 대각선 방향으로 1인 거리의 칸 중 물이 있는 칸 개수만큼 증가시킨다.
		// for(Cloud cloud : visited) {
		visited.forEach(cloud -> {
			if(cloud.x-1 >= 0 && cloud.y-1 >=0) {
				if(map[cloud.x-1][cloud.y-1] > 0) map[cloud.x][cloud.y]++;
			}
			if(cloud.x-1 >= 0 && cloud.y+1 < N) {
				if(map[cloud.x-1][cloud.y+1] > 0) map[cloud.x][cloud.y]++;
			}
			if(cloud.x+1 < N && cloud.y-1 >= 0) {
				if(map[cloud.x+1][cloud.y-1] > 0) map[cloud.x][cloud.y]++;
			}
			if(cloud.x+1 < N && cloud.y+1 < N) {
				if(map[cloud.x+1][cloud.y+1] > 0) map[cloud.x][cloud.y]++;
			}
		// }
		});
	}

	// 물이 2 이상인 땅 구름 생성
	static void makeCloud() {
		cloudArray = new ArrayList<>();

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] >= 2 && !visitedMap[i][j]) {
					cloudArray.add(new Cloud(i, j));
					map[i][j] -= 2;
				}
			}
		}

		visited = new ArrayList<>();
		visitedMap = new boolean[N][N];
	}

	static int calcRain() {
		int amount = 0;

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				amount += map[i][j];
			}
		}

		return amount;
	}
}
