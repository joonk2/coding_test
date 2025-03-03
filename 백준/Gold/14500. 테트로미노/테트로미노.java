/*
[시도한 방법]
1. 모든 모양을 다 그려주고 delta 탐색 진행 --> (실패)
2. delta 탐색 X
(테트로미노는 4방향 탐색이 아니라 미리 정의된 상대 좌표를 따라 이동해야 하므로 dx, dy를 사용불가)



*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][][] TETROMINOS = {
        // I 모양
        {{0,0}, {0,1}, {0,2}, {0,3}}, {{0,0}, {1,0}, {2,0}, {3,0}},
        // O 모양
        {{0,0}, {0,1}, {1,0}, {1,1}},
        // L 모양
        {{0,0}, {1,0}, {2,0}, {2,1}}, {{0,0}, {0,1}, {0,2}, {1,0}}, 
        {{0,0}, {0,1}, {1,1}, {2,1}}, {{0,2}, {1,0}, {1,1}, {1,2}}, 
        {{0,0}, {0,1}, {1,0}, {2,0}}, {{0,0}, {1,0}, {1,1}, {1,2}}, 
        {{0,1}, {1,1}, {2,0}, {2,1}}, {{0,0}, {0,1}, {0,2}, {1,2}}, 
        // Z 모양
        {{0,0}, {0,1}, {1,1}, {1,2}}, {{0,1}, {1,0}, {1,1}, {2,0}}, 
        {{0,1}, {0,2}, {1,0}, {1,1}}, {{0,0}, {1,0}, {1,1}, {2,1}}, 
        // T 모양
        {{0,0}, {0,1}, {0,2}, {1,1}}, {{0,0}, {1,0}, {1,1}, {2,0}}, 
        {{0,1}, {1,0}, {1,1}, {1,2}}, {{0,1}, {1,0}, {1,1}, {2,1}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 줄 입력
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // 보드 입력
        int[][] board = new int[N][M];
        for (int y = 0; y < N; y++) {
            String[] row = br.readLine().split(" ");
            for (int x = 0; x < M; x++) {
                board[y][x] = Integer.parseInt(row[x]);
            }
        }

        int maxSum = 0;

        // 모든 위치에서 테트로미노 배치 시도
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                for (int[][] tetromino : TETROMINOS) {
                    int currentSum = 0;
                    boolean valid = true;

                    for (int[] pos : tetromino) {
                        int nx = x + pos[0];
                        int ny = y + pos[1];
 
                        if (ny < 0 || ny > N-1 || nx < 0 || nx > M-1) {
                            valid = false;
                            break;
                        }
                        currentSum += board[ny][nx];
                    }

                    if (valid == true) {
                    	maxSum = Math.max(maxSum, currentSum);
                    }
                
                
                }
            }
        }

        System.out.println(maxSum);
    }
}
