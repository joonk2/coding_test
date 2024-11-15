import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int start = N;
        int cnt = 0;

        while (true) {
            int a = start / 10;
            int b = start % 10;
            int c = a + b;
            start = (b * 10) + (c % 10);
            cnt++;

            if (start == N) {
                break;
            }

        }
        System.out.println(cnt);
        br.close();


    }
}