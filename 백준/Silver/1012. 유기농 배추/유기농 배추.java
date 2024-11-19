import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N,M,K;
    static int[][] graph;
    static boolean[][] v;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new int[N][M];
            v = new boolean[N][M];

            // 배추 위치 설정
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                // [행][열]
                graph[y][x] =1;
            }

            int res = 0;


            // 배추밭 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 1 && !v[i][j]) {
                        dfs(i,j);
                        res++;
                    }
                }
            }


            sb.append(res).append('\n');


        }
        System.out.println(sb);


    }





    public static void dfs(int x, int y) {
        v[x][y] = true; // 현재 칸 방문처리

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (graph[nx][ny] == 1 && !v[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }



}