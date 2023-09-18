import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_21608 {
	static int N;
	static int[][] classroom;
	static HashMap<Integer, Set<Integer>> friends;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		classroom = new int[N][N];
		int[] students = new int[N*N];
		friends = new HashMap(); // 선호 친구 저장

		// 입력
		for(int i=0; i<N*N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			students[i] = student;
			friends.put(student, new HashSet<>());
			for(int j=0; j<4; j++) {
				friends.get(student).add(Integer.parseInt(st.nextToken()));
			}
		}

		// 학생 순서대로 students 하나하나 자리에 둔다.
		for(int i=0; i<N*N; i++) {
			// 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
			// 우선 전체 자리중에 비어있는칸을 찾고,
			// 이 비어있는 애들중에 인접하는곳에 선호하는 학생의 수를 체크.

			// 주변에 좋아하는 학생이 제일 많은 칸
			HashSet<Seat> mostNearLikeSeats = findMoreLikeSeat(students[i], findEmptySeats());
			if(mostNearLikeSeats.size() > 1) {
				// 그중에 주변에 빈칸이 많은 자리로 정해줘야한다.
				HashSet<Seat> mostNearEmptySeats = findNearEmptySeats(mostNearLikeSeats);
				if(mostNearEmptySeats.size() > 1) {
					// 빈칸이 많은 자리가 여러개이면,
					// 행의번호가 작은, 열의번호가 작은 자리로 정한다.
					Seat temp = findSeatByThirdWay(mostNearEmptySeats);
					classroom[temp.x][temp.y] = students[i];
				} else {
					Seat temp = mostNearEmptySeats.iterator().next();
					classroom[temp.x][temp.y] = students[i];
				}
			} else {
				Seat temp = mostNearLikeSeats.iterator().next();
				classroom[temp.x][temp.y] = students[i];
			}
		}

		// 만족도 구하기
		System.out.println(calcSatisfaction());
	}

	// 만족도 계산
	static int calcSatisfaction() {
		int total = 0;

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				total += Math.pow(10, numberOfLikeFriends(i, j)-1);
			}
		}

		return total;
	}

	// 인접한 곳에 몇 명의 선호 친구가 있는지 리턴
	static int numberOfLikeFriends(int x, int y) {
		int student = classroom[x][y];
		int count = 0;

		for(int i=0; i<4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];

			if(xx>=0 && xx<N && yy>=0 && yy<N && classroom[xx][yy] !=0) {
				if(friends.get(student).contains(classroom[xx][yy])) {
					count++;
				}
			}
		}
		return count;
	}

	// 주어진 자리들 중에 행의 번호가 작은, 열의 번호가 작은 자리 리턴
	static Seat findSeatByThirdWay(HashSet seats) {
		Iterator iterator = seats.iterator();
		Seat temp = (Seat)iterator.next();
		Seat returnSeat = temp;
		int x = temp.x;
		int y = temp.y;

		while(iterator.hasNext()) {
			temp = (Seat)iterator.next();
			if(temp.x < x) {
				x = temp.x;
				y = temp.y;
				returnSeat = temp;
			} else if(temp.x == x && temp.y < y) {
				y = temp.y;
				returnSeat = temp;
			}
		}
		return returnSeat;
	}

	// 주어진 hashSet 중에 주변에 빈 자리가 가장 많은 좌석을 리턴.
	// 역시 여러개 일수있음. HashSet 리턴
	static HashSet<Seat> findNearEmptySeats(HashSet seats) {
		Iterator itor = seats.iterator();
		HashSet<Seat> returnSeats = new HashSet<>();
		int maxCount = 0;
		while(itor.hasNext()) {
			Seat tempSeat = (Seat)itor.next();
			int count = 0;
			for(int i=0; i<4; i++) {
				int xx = tempSeat.x + dx[i];
				int yy = tempSeat.y + dy[i];

				if(xx>=0 && xx<N && yy>=0 && yy<N && classroom[xx][yy]==0) {
					count++;
				}
			}

			if(maxCount < count) {
				maxCount = count;
				returnSeats = new HashSet<>();
				returnSeats.add(tempSeat);
			} else if(maxCount == count) {
				returnSeats.add(tempSeat);
			}
		}

		return returnSeats;
	}

	// 빈자리를 HashSet으로 리턴
	static HashSet<Seat> findEmptySeats() {
		HashSet emptySeats = new HashSet<Seat>();

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(classroom[i][j] == 0) {
					emptySeats.add(new Seat(i, j));
				}
			}
		}

		return emptySeats;
	}

	// 자리 찾는 학생의 번호, 비어있는 자리 정보를 받아서 선호학생이 가장 많은 자리 찾기
	// 여러개 일 수 있음. HashSet 리턴.
	static HashSet<Seat> findMoreLikeSeat(int index, HashSet<Seat> emptySeats) {
		int maxCount = 0;
		HashSet<Seat> maxSeats = new HashSet<>();
		Iterator iterator = emptySeats.iterator();

		while(iterator.hasNext()) {
			Seat checkSeat = (Seat)iterator.next();
			int count = 0; // 주변 선호 학생 수
			// 4방향 돌면서 체크
			for(int i=0; i<4; i++) {
				int xx = checkSeat.x + dx[i];
				int yy = checkSeat.y + dy[i];

				if(xx>=0 && xx<N && yy>=0 && yy<N && classroom[xx][yy] !=0) {
					if(friends.get(index).contains(classroom[xx][yy])) {
						count++;
					}
				}
			}

			if(count > maxCount) {
				maxCount = count;
				maxSeats = new HashSet<>();
				maxSeats.add(checkSeat);
			} else if(maxCount == count) {
				maxSeats.add(checkSeat);
			}
		}

		return maxSeats;
	}

	// 행, 열의 정보가 담긴 좌석 객체
	static class Seat {
		int x;
		int y;

		Seat(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
