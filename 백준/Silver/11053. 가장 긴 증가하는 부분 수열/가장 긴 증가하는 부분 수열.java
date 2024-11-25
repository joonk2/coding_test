import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp
        for (int i = 1; i < N+1; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        // dp 배열에서 최댓값
        int max_sum = 0;
        for (int i = 1; i < N+1; i++) {
            max_sum = Math.max(max_sum, dp[i]);
        }

        System.out.println(max_sum);


    }
}