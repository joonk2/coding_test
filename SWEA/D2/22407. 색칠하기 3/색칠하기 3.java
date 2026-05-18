import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            int red_sr = sc.nextInt();
            int red_sc = sc.nextInt();
            int red_er = sc.nextInt();
            int red_ec = sc.nextInt();

            int blue_sr = sc.nextInt();
            int blue_sc = sc.nextInt();
            int blue_er = sc.nextInt();
            int blue_ec = sc.nextInt();

            // min 직접 구현
            int end_r;
            if (red_er < blue_er) {
                end_r = red_er;
            } else {
                end_r = blue_er;
            }

            int end_c;
            if (red_ec < blue_ec) {
                end_c = red_ec;
            } else {
                end_c = blue_ec;
            }

            // max 직접 구현
            int start_r;
            if (red_sr > blue_sr) {
                start_r = red_sr;
            } else {
                start_r = blue_sr;
            }

            int start_c;
            if (red_sc > blue_sc) {
                start_c = red_sc;
            } else {
                start_c = blue_sc;
            }

            // 겹치는 크기 계산
            int row = end_r - start_r + 1;
            int col = end_c - start_c + 1;

            // 안 겹치면 0
            if (row <= 0 || col <= 0) {
                row = 0;
                col = 0;
            }

            System.out.println("#" + tc + " " + col + " " + row);
        }
    }
}