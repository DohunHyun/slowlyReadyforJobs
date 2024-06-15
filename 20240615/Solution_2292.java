import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt() - 1;

        int answer = 1;

        int temp = 6;
        while(N > 0) {
            N -= temp;
            temp += 6;
            answer++;
        }

        System.out.println(answer);
    }
}