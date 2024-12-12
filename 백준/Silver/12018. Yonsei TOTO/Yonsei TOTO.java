/*
우선 정원미달일 경우 최소 등록 마일리지는 1,

필요한 마일리지는
25, 20, 1, 14
36은 마일리지 모자라서 못쓴다
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().trim().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        ArrayList<Integer> li = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] secondLine = br.readLine().trim().split(" ");
            int P = Integer.parseInt(secondLine[0]);
            int L = Integer.parseInt(secondLine[1]);

            String[] point_arr = br.readLine().trim().split(" ");
            int[] point = new int[P];
            for (int j = 0; j < P; j++) {
                point[j] = Integer.parseInt(point_arr[j]);
            }

            // asc;
            Arrays.sort(point);

            int threshold;
            if (P >= L) {
                threshold = point[P-L];
            }
            else {
                threshold = 1;
            }

            li.add(threshold);



        }

        // asc
        Collections.sort(li);

        int cnt = 0;
        for (int i : li) {
            if (m-i >= 0) {
                cnt++;
                m -= i;
            }
            else {
                break;
            }
        }


        System.out.println(cnt);




    }
}