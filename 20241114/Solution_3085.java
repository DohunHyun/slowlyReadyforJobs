import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3085 {
    static int[] dr = {-1, 0, 1, 0}; // 위 오 아 왼
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[][] map = new String[N][N];
        int max = 0;

        for(int i=0; i<N; i++) {
            String[] split = br.readLine().split("");
            for(int j=0; j<N; j++) {
                map[i][j] = split[j];
            }
        }
        max = count(0, map);

        // 인접한 다른 색이랑 교환해보고
        // 최대 값 구해보고
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<4; k++) {
                    int rr = i + dr[k];
                    int cc = j + dc[k];

                    if(rr >= 0 && rr < N && cc >= 0 && cc < N && !map[i][j].equals(map[rr][cc])) {
                        String temp = map[i][j];
                        map[i][j] = map[rr][cc];
                        map[rr][cc] = temp;

                        max = count(max, map);

                        temp = map[i][j];
                        map[i][j] = map[rr][cc];
                        map[rr][cc] = temp;
                    }
                }
            }
        }

        System.out.println(max);
    }

    static int count(int max, String[][] map) {
        // map을 보면서 최대로 이어지는 개수 구하기
        int maxlength = 0;

        for(int i=0; i<map.length; i++) {
            String now = map[i][0];
            int temp = 0;
            for(int j=0; j<map.length; j++) {
                if(now.equals(map[i][j])) {
                    temp++;
                } else {
                    if(temp > maxlength) {
                        maxlength = temp;
                    }
                    temp = 1;
                    now = map[i][j];
                }
            }
            if(temp > maxlength) {
                maxlength = temp;
            }
        }


        for(int i=0; i<map.length; i++) {
            String now = map[0][i];
            int temp = 0;
            for(int j=0; j<map.length; j++) {
                if(now.equals(map[j][i])) {
                    temp++;
                } else {
                    if(temp > maxlength) {
                        maxlength = temp;
                    }
                    temp = 1;
                    now = map[j][i];
                }
            }
            if(temp > maxlength) {
                maxlength = temp;
            }
        }

        if(max > maxlength) {
            maxlength = max;
        }

        return maxlength;
    }
}
