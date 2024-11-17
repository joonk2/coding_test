import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(Solution(N));
    }


    private static int Solution(int N) {
        int room = 1;
        int cnt = 1;

        if (N == 1) {
            return 1;
        }

        while (N > room) {
            room += (cnt*6);
            cnt++;
        }

        return cnt;
    }


}

