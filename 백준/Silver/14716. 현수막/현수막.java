import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    static boolean[][] graph;
    static boolean[][] v;
    static int M, N;
    static int[] dx = {0,0, -1,1,-1,1,-1,1};
    static int[] dy = {-1,1,0,0,1,1,-1,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N][M];
        v = new boolean[N][M];
        int cnt = 0;


        // graph
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j  = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    graph[i][j] = true;
                }
                else {
                    graph[i][j] = false;
                }
            }
        }


        // dfs
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == true && !v[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        // res
        System.out.println(cnt);


    }







    public static void dfs(int x, int y) {
        v[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if(graph[nx][ny] == true && !v[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }

}