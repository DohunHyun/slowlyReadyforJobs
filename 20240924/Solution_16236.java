import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_16236 {
    static int N, answer, nowSize, eatCount;
    static int sharkR, sharkC;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        answer = 0; // 이동 거리
        nowSize = 2; // 현재 상어 크기, 초기 크기 2
        eatCount = 0; // 현재 먹은 물고기 수

        // map 저장 및 상어 초기 위치 설정
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                if (map[i][j] == 9) { // 상어 초기 위치
                    sharkR = i;
                    sharkC = j;
                    map[i][j] = 0; // 상어가 이동하면 빈칸으로 만듬
                }
            }
        }

        while (true) {
            int[] result = bfs(); // BFS를 통해 가장 가까운 물고기 탐색
            if (result == null) { // 더 이상 먹을 수 있는 물고기가 없으면 종료
                break;
            }

            // 상어의 위치를 물고기의 위치로 이동
            sharkR = result[0];
            sharkC = result[1];
            int dist = result[2];
            answer += dist;

            // 먹은 물고기 수 증가
            eatCount++;
            if (eatCount == nowSize) {
                nowSize++; // 상어 크기 증가
                eatCount = 0;
            }
        }

        System.out.println(answer); // 총 이동 거리 출력
    }

    static int[] bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][N];
        queue.add(new int[]{sharkR, sharkC, 0}); // 상어의 초기 위치 및 이동 거리(0)
        visited[sharkR][sharkC] = true;

        int minDist = Integer.MAX_VALUE;
        int[] targetFish = null;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];

            if (dist > minDist) {
                break; // 더 멀리 있는 물고기는 탐색하지 않음
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                    if (map[nr][nc] <= nowSize) { // 상어 크기 이하만 지나갈 수 있음
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc, dist + 1});

                        if (map[nr][nc] > 0 && map[nr][nc] < nowSize) {
                            if (dist + 1 < minDist) { // 가장 가까운 물고기 찾기
                                minDist = dist + 1;
                                targetFish = new int[]{nr, nc, dist + 1};
                            } else if (dist + 1 == minDist) {
                                // 거리가 같을 경우 위쪽, 왼쪽에 있는 물고기를 우선
                                if (targetFish[0] > nr || (targetFish[0] == nr && targetFish[1] > nc)) {
                                    targetFish = new int[]{nr, nc, dist + 1};
                                }
                            }
                        }
                    }
                }
            }
        }

        if (targetFish != null) {
            map[targetFish[0]][targetFish[1]] = 0; // 물고기를 먹은 위치를 빈칸으로 만듦
        }

        return targetFish;
    }
}
