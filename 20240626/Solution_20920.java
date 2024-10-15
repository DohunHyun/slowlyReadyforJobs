import java.io.*;
import java.util.*;

public class Solution_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        HashMap<String, Integer> word = new HashMap<>();

        for(int i=0; i<N; i++) {
            String input = br.readLine();
            if(input.length() >= M) {
                word.put(input, word.getOrDefault(input, 0) + 1);
            }
        }

        List<String> words = new ArrayList<>(word.keySet());
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(word.get(o1) == word.get(o2)) { // 빈도수 같으면
                    if(o1.length() == o2.length()) { // 글자 길이 같으면
//                        return o1.charAt(0) - o2.charAt(0);
                        return o1.compareTo(o2);
                    }
                    return o2.length() - o1.length();
                }
                return word.get(o2) - word.get(o1);
            }
        });

        for(String string : words) {
            bw.write(string + "\n");
        }

//        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(word.entrySet());
//        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                if(o2.getValue().equals(o1.getValue())) {
//                    if(o2.getKey().length() == o1.getKey().length()) {
//                        return o1.getKey().charAt(0) - o2.getKey().charAt(0);
//                    }
//                    return o2.getKey().length() - o1.getKey().length();
//                }
//                return o2.getValue() - o1.getValue();
//            }
//        });
//
//        for(Map.Entry<String, Integer> entry : entryList) {
//            bw.write(entry.getKey() + "\n");
//        }

        bw.flush();
        bw.close();
        br.close();
    }
}
