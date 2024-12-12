import java.io.IOException;
import java.io.InputStreamReader;
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


        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 조합 계산
        for (int SeqLeng = 1; SeqLeng < N+1; SeqLeng++) {
            combination(0, 0, SeqLeng, 0);
        }

        System.out.println(cnt);



    }

    static void combination(int start, int depth, int SeqLeng, int sum) {
        if (depth == SeqLeng) {
            if (sum == S) {
                cnt++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            combination(i+1, depth+1, SeqLeng, sum+arr[i]);
        }

    }


}
