import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken()); // 피로도
        int B= Integer.parseInt(st.nextToken()); // 처리 가능한 업무량
        int C = Integer.parseInt(st.nextToken()); // 휴식
        int M = Integer.parseInt(st.nextToken()); // 피로도 한계

        int fatigue = 0;
        int sum_work = 0;


        // 24시간 동안 작업
        for ( int i = 0; i < 24; i++) {
            if (fatigue + A <= M) {
                fatigue += A;
                sum_work += B;
            }
            else {
                fatigue -= C;
                if (fatigue < 0) {
                    fatigue = 0;
                }
            }
        }

        System.out.println(sum_work);

    }
}