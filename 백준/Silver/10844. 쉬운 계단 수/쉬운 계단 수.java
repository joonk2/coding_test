// 1 2 3 4 5 6 7 8 9

// 10 12
// 21 23
// 32 34
// 43 45
// 54 56
// 65 67
// 76 78
// 87 89
// 98

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MOD = 1000000000;

        // dp[i][j]: 길이가 i인 계단 수 중 끝자리가 j인 수의 개수
        long[][] dp = new long[N+1][10];


        // stair(length == 1)
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }


        // dp 채우기
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][1];
                }

                else if (j == 9) {
                    dp[i][j] = dp[i-1][8];
                }
                else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                }

                dp[i][j] %= MOD;

            }
        }



        long res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + dp[N][i]) % MOD;
        }

        // print
        System.out.println(res);



    }
}