import java.util.Scanner;

public class Solution {
    static int[] locationArray;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case=1; test_case<=T; test_case++) {
            int size = sc.nextInt();
            
            answer = 0; // 퀸을 넣을수 있는 경우의 수
            locationArray = new int[size]; // 퀸을 넣은 곳은 나타내는 배열
            findQueen(size, 0);

            System.out.println("#" + test_case + " " + answer);

        }
    }

    static void findQueen(int size, int num_queen) {
        if(size == num_queen) { //퀸을 다 썻을때 즉 성공한 케이스 
            answer++;
            return;
        }
        for(int i=0; i<size; i++) {
            locationArray[num_queen] = i;
            if(isPossibleQueen(num_queen)) { //이 자리에 i를 넣을수 있으면
                findQueen(size, num_queen+1);
            } else { //못넣으면

            }
        }

    }

    private static boolean isPossibleQueen(int num_queen) {
        for(int j=0; j<num_queen; j++) { //num_queen은 이제까지 쓰인 퀸의 개수
            if(locationArray[num_queen] == locationArray[j] ||
                    Math.abs(num_queen-j) == Math.abs(locationArray[num_queen] - locationArray[j])) {
                return false;
            }

        }
        return true;
    }
}
