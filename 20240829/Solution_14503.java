import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_14503 {
	static int[][] map;
	// 북 동 남 서
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N;
	static int M;
	static int X, Y, D; // 현재 위치
	static int clear;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		N = Integer.parseInt(input.split(" ")[0]);
		M = Integer.parseInt(input.split(" ")[1]);
		map = new int[N][M];

		input = br.readLine();
		int r = Integer.parseInt(input.split(" ")[0]);
		int c = Integer.parseInt(input.split(" ")[1]);
		int d = Integer.parseInt(input.split(" ")[2]);
		// d : 방향 : 0북, 1동, 2남, 3서

		for(int i=0; i<N; i++) {
			String[] inputarray = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(inputarray[j]);
			}
		}

		clear = 0;
		X = r;
		Y = c;
		D = d;

		while(true) {
			if(!isClean(X, Y)) { // 1. 현재칸 청소안되어있으면 청소
				clean(X, Y);
			}
			if(noPlaceToCleanNearby(X, Y)) { // 2. 현재칸 주변 청소되지 않은칸이 없는 경우
				if(canGoBack(X, Y, D)) {
					goBack(X, Y, D);
					continue;
				} else {
					break;
				}
			} else { // 3. 현재칸 주변 청소되지 않은칸이 있는 경우
				turnLeft(X, Y, D);
				if(canCleanForward(X, Y, D)) {
					goForward(X, Y, D);
					continue;
				}
			}
		}

		System.out.println(clear);
	}

	// 현재 칸이 청소가 되어있는지 확인.
	// 청소가 되어있으면 2 true, 안되어있으면 0 false. 1은 벽
	static boolean isClean(int x, int y) {
		if(map[x][y] == 0) {
			return false;
		} else if(map[x][y] == 2) {
			return true;
		}
		return false;
	}

	// clean. 청소가 되어 있지 않은 땅을 청소.
	static void clean(int x, int y) {
		if(map[x][y] != 0) {
			System.out.println("오류. 청소가 되어있는데 청소 실행.");
			return;
		}
		map[x][y] = 2;
		clear++;
	}

	// noPlaceToCleanNearby 주변에 청소할 칸이 없으면 true, 있으면 false.
	static boolean noPlaceToCleanNearby(int x, int y) {
		for(int i=0; i<4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];

			if(xx>=0 && xx<N && yy>=0 && yy<M && map[xx][yy] == 0) {
				return false;
			}
		}
		return true;
	}

	// map에 좌표 x,y, 방향이 z 일때 뒤로 움직일 수 있는지
	static boolean canGoBack(int x, int y, int z) {
		int d;
		if(z == 0) d = 2;
		else if(z == 1) d = 3;
		else if(z == 2) d = 0;
		else d = 1;

		int xx = x + dx[d];
		int yy = y + dy[d];

		if(xx>=0 && xx<N && yy>=0 && yy<M && map[xx][yy] != 1) {
			return true;
		}
		return false;
	}

	// 현재 위치를 조정해야함. 0<>2 1<>3
	static void goBack(int x, int y, int z) {
		int d;
		if(z == 0) d = 2;
		else if(z == 1) d = 3;
		else if(z == 2) d = 0;
		else d = 1;

		X = x + dx[d];
		Y = y + dy[d];
	}

	// turnLeft
	static void turnLeft(int x, int y, int z) {
		if(z == 0) D = 3;
		else D--;
	}

	// canCleanForward 앞 칸이 청소가 안되어있는 빈칸인 경우 true
	static boolean canCleanForward(int x, int y, int z) {
		int xx = x + dx[z];
		int yy = y + dy[z];

		if(xx>=0 && xx<N && yy>=0 && yy<M && map[xx][yy] == 0) {
			return true;
		}
		return false;
	}

	// goForward
	static void goForward(int x, int y, int z) {
		int xx = x + dx[z];
		int yy = y + dy[z];

		if(xx>=0 && xx<N && yy>=0 && yy<M && map[xx][yy] == 0) {
			X = xx;
			Y = yy;
		}

	}
}
