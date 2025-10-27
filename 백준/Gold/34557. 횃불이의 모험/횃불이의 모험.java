import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int r, c;
    static String[] assigned = new String[4]; // W, A, S, D
    static boolean[] pressed = new boolean[4]; // 이전 프레임의 눌림 상태
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        // 맵 입력 및 시작 위치 찾기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    r = i;
                    c = j;
                }
            }
        }

        // 각 키에 할당된 이벤트
        for (int i = 0; i < 4; i++) {
            assigned[i] = br.readLine().trim();
        }

        // 프레임 입력
        String frames = br.readLine().trim();

        simulate(frames);

        System.out.println((r + 1) + " " + (c + 1));
    }

    static void simulate(String frames) {
        for (int frame = 0; frame < M; frame++) {
            char key = frames.charAt(frame);
            int nowIdx = getIndex(key);
            boolean[] nowPressed = new boolean[4];
            nowPressed[nowIdx] = true;

            // W, A, S, D 순서로 이벤트 발생 확인
            for (int i = 0; i < 4; i++) {
                String ev = getEvent(pressed[i], nowPressed[i]);
                if (ev != null && ev.equals(assigned[i])) {
                    move(i);
                }
            }

            pressed = nowPressed; // 상태 갱신
        }
    }

    static String getEvent(boolean prev, boolean now) {
        if (!prev && now) return "Down";
        if (prev && now) return "Stay";
        if (prev && !now) return "Up";
        return null;
    }

    static int getIndex(char key) {
        if (key == 'W') return 0;
        if (key == 'A') return 1;
        if (key == 'S') return 2;
        return 3; // D
    }

    static void move(int dir) {
        int nr = r + dr[dir];
        int nc = c + dc[dir];
        if (nr < 0 || nc < 0 || nr >= N || nc >= N) return; // 맵 밖
        if (map[nr][nc] == 1) return; // 장애물
        r = nr;
        c = nc;
    }
}
