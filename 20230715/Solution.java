import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int[] dr = {0,1,0,-1}; // 방향
    static int[] dc = {1,0,-1,0}; // 방향

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T =  sc.nextInt();  //케이스 개수
        for (int tc = 1; tc <= T; tc++) { // 케이스 개수 만큼 반복
            int N = sc.nextInt(); // 사각형 크기 N
            int[][] map = new int[N][N]; //2차원 배열 생성

            int cr = 0; //행 숫자
            int cc = 0; //렬 숫자

            int input = 1; //첫번째로 입력하는 숫자
            map[cr][cc] = input; //해당하는 위치에 숫자 입력
            input++; //입력 후 숫자 올려주기

            for (int i = 0; i < 2*N-1; i++) { // 2N-1 만큼 반복. 방향이 바뀌는 횟수다.
                while(true) { //한 방향이 유지될때까지 계속 반복
                    int nr = cr + dr[i%4]; // 처음은 +(0,1) -> 우측으로 진행
                    int nc = cc + dc[i%4]; // 두번째 +(1,0) v 아래로 방향 진행
                                           // 세번째 +(0,-1) <- 왼쪽으로 진행
                                           // 네번째 +(-1,0) ^ 위로 방향 진행
                    //System.out.println(nr + " " + nc);
                    if(nr >= 0 && nc >=0 && nr < N && nc < N && map[nr][nc] == 0) {
                        // nr 이 0보다 크면서 nc가 0보다 크고 -> 마이너스 까지 안가야하고
                        // nr<N, nc<N -> 최대값보단 작아야하고
                        // map[][]==0 -> 이미 뭔가 들어 있으면 안된다.

                        map[nr][nc] = input; // 위 세가지 조건이 되면 그 자리에 값을 넣고
                        //System.out.println(map[nr][nc]);
                        input++; //인풋 값 하나 올려주고
                    } else { //조건이 안되면 방향을 바꿔줘야하니깐 break로 와일문 나가주고
                        break;
                    }
                    cr = nr; //위치 업데이트
                    cc = nc;
                }


            }

            System.out.println("#" + tc);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }

            sb.delete(sb.length()-1, sb.length());
            System.out.println(sb);
        }


    }
}