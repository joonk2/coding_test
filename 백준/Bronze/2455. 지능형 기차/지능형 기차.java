import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int res = 0;

        for (int i = 1; i < 5; i++) {
            String[] S = br.readLine().split(" ");
            int out = Integer.parseInt(S[0]);
            int in = Integer.parseInt(S[1]);

            sum += in;
            sum -= out;
            res = Math.max(res, sum);
        }

        System.out.println(res);


    }
}