import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {
	static String[][] sequence = {
		    // 9
		    {"111", "101", "111", "001", "111"},

		    // 8
		    {"111", "101", "111", "101", "111"},

		    // 7
		    {"111", "101", "001", "001", "001"},

		    // 6
		    {"111", "100", "111", "101", "111"},

		    // 5
		    {"111", "100", "111", "001", "111"},

		    // 4
		    {"101", "101", "111", "001", "001"},

		    // 3
		    {"111", "001", "111", "001", "111"},

		    // 2
		    {"111", "001", "111", "100", "111"},

		    // 1
		    {"010", "110", "010", "010", "111"},

		    // 0
		    {"111", "101", "101", "101", "111"}
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
						char cur = arr[r].charAt(c);
						if (cur != sequence[i][r].charAt(c)) {
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