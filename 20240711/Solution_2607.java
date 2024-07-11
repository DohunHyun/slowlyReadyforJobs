import java.io.*;

public class Solution_2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String firstWord = br.readLine();
        char[] original = firstWord.toCharArray();
        int[] originalCount = new int[26];
        for(int i=0; i<original.length; i++) {
            originalCount[original[i] - 'A']++;
        }
        int answer = 0;

        for(int i=1; i<N; i++) {
            int[] temp = originalCount.clone();
            String word = br.readLine();
            int count = 0;

            for(int j=0; j<word.length(); j++) {
                if(temp[word.charAt(j)-'A'] > 0) { // 같은 글자가 존재하면
                    count++;
                    temp[word.charAt(j)-'A']--; // 하나 깎아주고
                }
            }

            // 비교단어의 길이가 기준 단어보다 한글자 더 작을때 && 나머진 다 같을때
            if(original.length - 1 == word.length() && count == word.length()) {
                answer++;
            } else if(original.length == word.length()) { // 두 글자의 길이가 같을때
                if(original.length == count || original.length-1 == count) {
                    // 같은 글자 개수와 길이가 같거나, 한개만 다를때
                    answer++;
                }
            } else if(original.length + 1 == word.length()) { // 비교 단어의 길이가 1 클때
                if(count == original.length) {
                    // 기준 단어가 전부 다 같으면
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
