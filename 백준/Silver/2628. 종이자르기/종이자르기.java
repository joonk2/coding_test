/*
1. 종이의 경계 포함 (0,X), (0,Y)
2. size()-1 범위를 통해 맨끝 연속값 거리 계산 get(i+1) - get(i)
3. 정렬시 다음과 같이 된다

첫 번째 명령 0 3: row_cut에 3 추가 -> [0,10,3]
두 번째 명령 1 4: col_cut에 4 추가 -> [0,8,4]
세 번째 명령 0 2: row_cut에 2 추가 -> [0,10,3,2]
그리고 ASC;
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static StringTokenizer st;
    static int X, Y, N;
    static int max_X, max_Y;
    static ArrayList<Integer> row_cut = new ArrayList<>();
    static ArrayList<Integer> col_cut = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        // from start to end
        row_cut.add(0);
        row_cut.add(Y);
        col_cut.add(0);
        col_cut.add(X);

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int type = Integer.parseInt(st.nextToken());

            if (type == 0) {
                row_cut.add(Integer.parseInt(st.nextToken()));
            }
            else if (type == 1) {
                col_cut.add(Integer.parseInt(st.nextToken()));
            }

        }

        // Arrangement
        Collections.sort(row_cut);
        Collections.sort(col_cut);

        rowCut();
        colCut();

        System.out.println(max_X * max_Y);

        br.close();



    }

    

    public static void rowCut() {
        for (int i = 0; i < row_cut.size()-1; i++) {
            int dist = row_cut.get(i+1) - row_cut.get(i);

            max_X = Math.max(max_X, dist);
        }
    }


    public static void colCut() {
        for (int i = 0; i < col_cut.size()-1; i++) {
            int dist = col_cut.get(i+1) - col_cut.get(i);

            max_Y = Math.max(max_Y, dist);
        }
    }


    
}