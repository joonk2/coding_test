/*
1. 빙고 경우의 수 4개 생각하라
(가로,세로는 각각 5개, 대각선은 가능할 경우가 각각 1개)
2. 현재 선택중인 숫자 기록
3. 3줄되면 즉시 종료하면서 당시 선택된 숫자 출력
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    static int cnt, cnt_zero;
    static int[][] bingo = new int[5][5];
    static StringTokenizer st;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        cnt = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // cur_num
        // k = on what num, bingo is done with 3 sets?
        int k = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < 5; j++) {
                int cur_num = Integer.parseInt(st.nextToken());
                k++;

                // changing a cur_num
                mark_num(cur_num);

                // bingo check
                r_check();
                c_check();
                lr_check();
                rl_check();

                // if bingo is 3, then finish
                if (cnt >= 3) {
                    System.out.println(k);
                    return;
                }

                // reset with cnt of bingo
                cnt = 0;
            }
        }



    }

    // mark_num
    // all cur_num -> 0
    public static void mark_num(int cur_num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 ; j++) {
                if (bingo[i][j] == cur_num) {
                    bingo[i][j] = 0;
                }
            }
        }
    }

    // row check
    public static void r_check() {
        for (int i = 0; i < 5; i++) {
            cnt_zero = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == 0) {
                    cnt_zero++;
                }
            }
            if (cnt_zero == 5) {
                cnt++;
            }
        }
    }

    // col check
    public static void c_check() {
        for (int i = 0; i < 5; i++) {
            cnt_zero = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] == 0) {
                    cnt_zero++;
                }
            }
            if (cnt_zero == 5) {
                cnt++;
            }
        }
    }

    // lr check
    public static void lr_check() {
        cnt_zero = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] == 0) {
                cnt_zero++;
            }
            if (cnt_zero == 5) {
                cnt++;
            }
        }
    }

    // rl check
    public static void rl_check() {
        cnt_zero = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][4-i] == 0) {
                cnt_zero++;
            }
            if (cnt_zero == 5) {
                cnt++;
            }
        }
    }



}
