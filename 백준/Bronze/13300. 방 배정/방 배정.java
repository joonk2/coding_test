/*
[조건]
1. 한 방에 인원제한은 K명
2. 같은 학년 & 같은 성별일 것
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    static int N, K, S, Y, cnt;
    static int[][] room;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        room = new int[2][7];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            S = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            room[S][Y]++;
        }

        cnt = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 7; j++) {
                cnt += room[i][j] / K;
                if (room[i][j] % K != 0) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);


    }
}