import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int[] day_of_month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day_of_week = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};


        // 누적일수 계산
        int total_days = 0;
        for (int i = 0; i < month - 1; i++) {
            total_days += day_of_month[i];
        }
        total_days += day; // 현재 월의 날짜 추가


        // 요일 계산
        // -1은 배열 인덱스로 조정 --> 1월 1일일때 d_o_w[0]이 "MON" 이기 때문
        String res = day_of_week[ (total_days - 1) % 7 ];
        System.out.println(res);




    }
}