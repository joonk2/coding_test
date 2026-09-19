import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {
	static int[][][] sequence = {
			// 9
			{
				{1, 1, 1},
				{1, 0, 1},
				{1, 1, 1},
				{0, 0, 1},
				{1, 1, 1}
			},
			
			// 8
			{
				{1, 1, 1},
				{1, 0, 1},
				{1, 1, 1},
				{1, 0, 1},
				{1, 1, 1}
			},
			
			// 7
			{
				{1, 1, 1},
				{1, 0, 1},
				{0, 0, 1},
				{0, 0, 1},
				{0, 0, 1}
			},
			
			// 6
			{
				{1, 1, 1},
				{1, 0, 0},
				{1, 1, 1},
				{1, 0, 1},
				{1, 1, 1}
			},
			
			// 5
			{
				{1, 1, 1},
				{1, 0, 0},
				{1, 1, 1},
				{0, 0, 1},
				{1, 1, 1}
			},
			
			// 4
			{
				{1, 0, 1},
				{1, 0, 1},
				{1, 1, 1},
				{0, 0, 1},
				{0, 0, 1}
			},
			
			// 3
			{
				{1, 1, 1},
				{0, 0, 1},
				{1, 1, 1},
				{0, 0, 1},
				{1, 1, 1}
			},
			
			// 2
			{
				{1, 1, 1},
				{0, 0, 1},
				{1, 1, 1},
				{1, 0, 0},
				{1, 1, 1}
			},
			
			// 1
			{
				{0, 1, 0},
				{1, 1, 0},
				{0, 1, 0},
				{0, 1, 0},
				{1, 1, 1}
			},
			
			// 0
			{
				{1, 1, 1},
				{1, 0, 1},
				{1, 0, 1},
				{1, 0, 1},
				{1, 1, 1}
			}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			
			boolean[][] visited = new boolean[5][3];
			int times = 10;
			for (int i = 0; i < times; i++) {
				String[] arr = br.readLine().split(" ");
				
				// 검사
				int row = arr.length;
				int col = arr[0].length();
				for (int r = 0; r < row; r++) {
					for (int c = 0; c < col; c++) {
						int cur = arr[r].charAt(c) - '0';
						if (cur != sequence[i][r][c]) {
							visited[r][c] = true;
						}
					}
				}
			}
			
			// 오류난 곳 표시
			int[][] res = new int[5][3];
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 3; c++) {
					if (visited[r][c]) {
						res[r][c] = 1;
					}
				}
			}
			
			// 결과 출력
			System.out.println("#" + tc);
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 3; c++) {
					System.out.print(res[r][c]);
				}
				System.out.println();
			}
		}
	}
}