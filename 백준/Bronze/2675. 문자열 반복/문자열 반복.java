import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] S = br.readLine().split(" ");
            int cnt = Integer.parseInt(S[0]);
            String word = S[1];

            StringBuilder sb = new StringBuilder();

            // word의 각 문자에 대해 cnt만큼 반복
            // 너무 중요 --> for (char ch : word.toCharArray())
            for (char ch : word.toCharArray()) {
                for (int j = 0; j < cnt; j++) {
                    sb.append(ch);
                }
            }

            // 출력
            System.out.println(sb);

        }


    }
}