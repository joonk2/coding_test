import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // arr
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp
        int[] dp = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            dp[i] = 1;
        }

        // calculating dp
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        // res
        int max_length = 0;
        for (int i = 1; i < N+1; i++) {
            max_length = Math.max(max_length, dp[i]);
        }

        System.out.println(max_length);


    }
}