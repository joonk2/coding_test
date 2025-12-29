import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	static boolean win(char[] b, char c) {
		int[][] lines = {
				{0,1,2}, {3,4,5}, {6,7,8},
				{0,3,6}, {1,4,7}, {2,5,8},
				{0,4,8}, {2,4,6}
		};
		
		for (int[] line : lines) {
			if (b[line[0]] == c && b[line[1]] == c && b[line[2]] == c) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String str = br.readLine();
			if (str.equals("end")) break;
			char[] board = str.toCharArray();
			
			int x = 0;
			int o = 0;
			for (char c : board) {
				if (c == 'X') x++;
				if (c == 'O') o++;
			}
			
			boolean x_win = win(board, 'X');
			boolean o_win = win(board, 'O');
			
			boolean valid = true;
			
			// 개수 규칙 -> x가 선공이니 더 많아야한다
			if (!(x == o || x == o+1)) valid = false;
			
			// 둘다 이기는 경우
			if (x_win && o_win) valid = false;
			
			// x가 이겼는데 개수가 안맞다
			if (x_win && x != o+1) valid = false;
			
			// o가 이겼는데 개수가 안맞다
			if (o_win && x != o) valid = false;
			
			// 아무도 안 이겼는데 판이 안찼다
			if (!x_win && !o_win && x + o != 9) valid = false;
			
			
			if (valid) {
				System.out.println("valid");
			}
			else System.out.println("invalid");
		}
	}
	
	
	
	
	static void lets_figure_out_the_answer(char[] arr) {
		// 1번째 요소가 X가 아니라면 invalid
		if (arr[0] != 'X') {
			System.out.println("invalid");
			return;
		}
		
		int idx_circle = 999;
		int idx_point = 999;
		for (int i = 1; i < 9; i++) {
			if (arr[i] == 'O' && idx_circle == 999) {
				idx_circle = i;
			}
			if (arr[i] == '.' && idx_point == 999) {
				idx_point = i;
			}
		}
		
		// 만약 .이 O보다 먼저 나오면 invalid
		if (idx_point < idx_circle) {
			System.out.println("invalid");
			return;
		}
	
		
		
		// 판별 알고리즘
		for (int i = 0; i < 9; i++) {
			// 왼위 -> 오아래
			if (i == 0 && arr[0] == arr[4] && arr[4] == arr[8] && arr[8] == arr[0]) {
				System.out.println("valid");
				return;
			}
			// 위에서 아래
			if (i < 9 && i + 3 < 9 && i + 6 < 9) {
				if (arr[i] == arr[i+3] && arr[i+3] == arr[i+6] && arr[i+6] == arr[i]) {
					System.out.println("valid");
					return;
				}
			}
			// 오위 -> 왼아래
			if (i == 2 && arr[2] == arr[4] && arr[4] == arr[6] && arr[6] == arr[2]) {
				System.out.println("valid");
				return;
			}
			// 직선 
		}
		
		
	}
	
	
	
	
	
}