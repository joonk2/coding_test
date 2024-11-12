import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0, K = 5;
        for (int i = 0; i < K; i++) {
            int score = Integer.parseInt(br.readLine());
            if (score < 40) {
                score = 40;
            }
            sum += score;
        }
        System.out.println(sum/K);
    }
}
