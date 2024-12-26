/*
10x10 종이 1번
6x6 종이 2

1111111111
1111111111
1112222221
1112222221
1112222221
1112222221
1112222221
1112222221
1111111111
1111111111

*/

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[1001][1001];
        int N = Integer.parseInt(br.readLine());

        // 색종이를 구분하기 위한 각 번호 k (1부터 시작)
        for (int k = 1; k < N+1; k++) {
            st = new StringTokenizer(br.readLine().trim());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            for (int i = X; i < X + W; i++) {
                for (int j = Y; j < Y + H; j++) {
                    arr[i][j] = k;
                }
            }


        }



        for (int k = 1; k < N+1; k++) {
            int cnt = 0;
            for (int i = 0; i < 1001; i++) {
                for (int j = 0; j < 1001; j++) {
                    if (arr[i][j] == k) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);


        }




    }
}
