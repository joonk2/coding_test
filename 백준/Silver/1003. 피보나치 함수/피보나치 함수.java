import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            fibo(N); // N에 대한 0과 1 호출 횟수 계산
            System.out.println(dp[N][0] + " " + dp[N][1]);
        }


    }


    public static Integer[] fibo(int N) {
        if (dp[N][0] == null || dp[N][1] == null) {
            dp[N][0] = fibo(N - 2)[0] + fibo(N - 1)[0];
            dp[N][1] = fibo(N - 2)[1] + fibo(N - 1)[1];
        }
        return dp[N];
    }


}