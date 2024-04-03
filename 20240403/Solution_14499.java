import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] dice = new int[6]; // 처음 주사위는 모드 0이 쓰여져있다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstInputLine = br.readLine();
        String[] firstinputArray = firstInputLine.split(" ");

        int N = Integer.parseInt(firstinputArray[0]);
        int M = Integer.parseInt(firstinputArray[1]);
        int X = Integer.parseInt(firstinputArray[2]);
        int Y = Integer.parseInt(firstinputArray[3]);
        int K = Integer.parseInt(firstinputArray[4]);

        int[][] map = new int[N][M];

        for(int i=0; i<N; i++) {
            String[] mapNumber = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(mapNumber[j]);
            }
        }

        int[] command = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        // 지도에 있는 칸이 0 이면, 주사위 바닥면이 지도에 복사.
        // 지도에 있는 칸이 0이 아니면, 지도 칸에 숫자가 주사위에 바닥면으로 복사되고, 지도 칸은 0이 된다.
        // 출력은 이동할때마다 주사위에 윗면 숫자 출력.
        // 만약 바깥으로 이동하면 무시, 출력도 안함.

        // 주사위 굴리기 시작.
        for(int i=0; i<K; i++) {
            int[] clone = dice.clone();
            if(command[i] == 1) { // 동쪽
                if(Y+1 >= M) {
                    continue;
                }
                dice[0] = clone[4];
                dice[2] = clone[5];
                dice[4] = clone[2];
                dice[5] = clone[0];
                Y++;
            } else if(command[i] == 2) { // 서쪽
                if(Y-1 < 0) {
                    continue;
                }
                dice[0] = clone[5];
                dice[2] = clone[4];
                dice[4] = clone[0];
                dice[5] = clone[2];
                Y--;
            } else if(command[i] == 4) { // 남쪽
                if(X+1 >= N) {
                    continue;
                }
                dice[0] = clone[3];
                dice[1] = clone[0];
                dice[2] = clone[1];
                dice[3] = clone[2];
                X++;
            } else if(command[i] == 3) { // 북쪽
                if(X-1 < 0) {
                    continue;
                }
                dice[0] = clone[1];
                dice[1] = clone[2];
                dice[2] = clone[3];
                dice[3] = clone[0];
                X--;
            } else {
                System.out.println("방향 숫자 이상 오류");
            }

            if(map[X][Y] == 0) {
                map[X][Y] = dice[2];
            } else {
                dice[2] = map[X][Y];
                map[X][Y] = 0;
            }
            System.out.println(dice[0]);
        }


    }
}