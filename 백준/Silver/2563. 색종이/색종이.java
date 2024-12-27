import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[][] arr = new boolean[101][101];

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            for (int j = X; j < 10 + X; j++) {
                for (int k = Y; k < 10 + Y; k++) {
                    if (!arr[j][k]) {
                        arr[j][k] = true;
                        cnt++;
                    }
                }
            }

            
            
        }
        System.out.println(cnt);

        

    }
}