import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    static int N, S, cnt = 0;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 계산
        for (int r = 1; r < N+1; r++) {
            combination(0,0,r,0);
        }

        System.out.println(cnt);


    }


    static void combination(int start, int depth, int r, int sum) {
        if (depth == r) {
            if (sum == S) {
                cnt++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            combination(i+1, depth+1, r, sum+arr[i]);
        }

    }




}