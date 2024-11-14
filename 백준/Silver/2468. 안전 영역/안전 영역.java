import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] graph;
    static boolean[][] v;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        int max_height = 0;

        // 그래프 입력 및 최대 높이 찾기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                max_height = Math.max(max_height, graph[i][j]);
            }
        }

        int max_safe_zone = 0;
        // 각 높이마다 안전 영역 탐색
        for (int height = 0; height <= max_height; height++) {
            v = new boolean[N][N];
            int cnt_safezone = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 안전 영역 탐색 시작
                    if (!v[i][j] && graph[i][j] > height) {
                        dfs(i, j, height);
                        cnt_safezone++;
                    }
                }
            }

            max_safe_zone = Math.max(max_safe_zone, cnt_safezone);
        }
        System.out.println(max_safe_zone);


    // main 메서드 닫는 괄호
    }





    // DFS 함수
    static void dfs(int x, int y, int height) {
        v[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !v[nx][ny] && graph[nx][ny] > height) {
                dfs(nx, ny, height);
            }
        }
    }



// class 닫는 괄호
}