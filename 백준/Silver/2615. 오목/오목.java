/*
한 점{0,0}을 기준으로 8방향이 아닌 4방향만 탐색하자
ㅡ ㅣ / \ 
*/



import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][][] Gomoku = {
			// 6목이면 실패라서 마지막에 틀리기 위한 배열도 하나 넣자
			
			// 왼 -> 오
			{ {0,1}, {0,2}, {0,3}, {0,4} },
			
			// 위 -> 아래
			{ {1,0}, {2,0}, {3,0}, {4,0} },
			
			// 오위 -> 왼아
			{ {1,-1}, {2,-2}, {3,-3}, {4,-4} },
			
			// 왼위 -> 오아
			{ {1,1}, {2,2}, {3,3}, {4,4} },
	};
	
	static int[][] arr;
	static int N;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 19;
		arr = new int[N][N];
		for (int r = 0; r < N; r++) {
			String[] cols = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(cols[c]);
			}
		}
		lets_find_the_answer();
	}
	
	
	
	
	
    static void lets_find_the_answer() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (arr[r][c] == 0) continue;
                int stone = arr[r][c];

                for (int[][] gomoku_pos : Gomoku) {
                    boolean check = true;

                    // 5목 확인
                    for (int i = 0; i < 4; i++) {
                        int nr = r + gomoku_pos[i][0];
                        int nc = c + gomoku_pos[i][1];

                        if (nr < 0 || nr >= N || nc < 0 || nc >= N || arr[nr][nc] != stone) {
                            check = false;
                            break;
                        }
                    }

                    if (!check) continue;

                    // 5목 앞/뒤 돌 확인 (6목 방지)
                    int prev_r = r - gomoku_pos[0][0];
                    int prev_c = c - gomoku_pos[0][1];
                    int end_r  = r + gomoku_pos[3][0] + (gomoku_pos[1][0] - gomoku_pos[0][0]);
                    int end_c  = c + gomoku_pos[3][1] + (gomoku_pos[1][1] - gomoku_pos[0][1]);

                    if ((prev_r >= 0 && prev_r < N && prev_c >= 0 && prev_c < N && arr[prev_r][prev_c] == stone) ||
                        (end_r >= 0 && end_r < N && end_c >= 0 && end_c < N && arr[end_r][end_c] == stone)) {
                        continue;
                    }

                    
                    // result
                    if (check) {
                    	int winner = arr[r][c];
                    	int answer_r = r+1;
                    	int answer_c = c+1;
                    	
                    	
                    	// 오위 -> 왼아일때
                    	if (gomoku_pos[0][0] == 1 && gomoku_pos[0][1] == -1) {
                    		answer_r = r+4 + 1;
                    		answer_c = c-4 + 1;
                    	}
                    	
                    	System.out.println(winner);
                    	System.out.println(answer_r + " " + answer_c);
                    	return;
                    }
                    
                }
            }
        }
        System.out.println(0);
    }
}