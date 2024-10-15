import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_3758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            String[] split = br.readLine().split(" ");
            int N = Integer.parseInt(split[0]); // 팀의 개수
            int K = Integer.parseInt(split[1]); // 문제 개수
            int teamID = Integer.parseInt(split[2]); // 나의 팀 id
            int M = Integer.parseInt(split[3]); // 로그 개수
            Team[] teams = new Team[N];
            for(int i=0; i<N; i++) {
                teams[i] = new Team(i+1, K);
            }

            for(int m=0; m<M; m++) {
                split = br.readLine().split(" ");
                int i = Integer.parseInt(split[0]); // 팀 ID
                int j = Integer.parseInt(split[1]); // 문제 번호
                int s = Integer.parseInt(split[2]); // 획득 점수

                Team team = teams[i-1];
                team.scores[j] = Math.max(team.scores[j], s);
                team.submitCnt++;
                team.lastTime = m;
            }

            Arrays.sort(teams, new Comparator<Team>() {
                @Override
                public int compare(Team o1, Team o2) {
                    int o1Score = Arrays.stream(o1.scores).sum();
                    int o2Score = Arrays.stream(o2.scores).sum();
                    if(o1Score == o2Score) {
                        if(o1.submitCnt == o2.submitCnt) {
                            return Integer.compare(o1.lastTime, o2.lastTime);
                        }
                        return Integer.compare(o1.submitCnt, o2.submitCnt);
                    }
                    return Integer.compare(o2Score, o1Score);
                }
            });

            for(int i=0; i<N; i++) {
                if(teams[i].id == teamID) {
                    bw.write((i+1) + "\n");
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Team {
        int id;
        int lastTime;
        int[] scores;
        int submitCnt;

        Team(int id, int question) {
            this.id = id;
            this.scores = new int[question+1];
        }
    }
}
