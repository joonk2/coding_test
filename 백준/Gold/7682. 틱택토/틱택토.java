import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
	static int[][] lines = {
			{0,1,2}, {3,4,5}, {6,7,8},
			{0,3,6}, {1,4,7}, {2,5,8},
			{0,4,8}, {2,4,6}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String str = br.readLine();
			if (str.equals("end")) break;
			char[] arr = str.toCharArray();
			
			int cnt_X = 0;
			int cnt_O = 0;
			for (int i = 0; i < 9; i++) {
				if (arr[i] == 'X') cnt_X++;
				if (arr[i] == 'O') cnt_O++;
			}
			
			boolean valid = true;
			boolean win_X = win(arr, 'X');
			boolean win_O = win(arr, 'O');
			

			
			// 게임 규칙 (갯수가 같거나 || X 갯수 > O 갯수)
			if ( !(cnt_X == cnt_O || cnt_X == cnt_O + 1) ) valid = false;
			
			// 둘다 안이겼는데 게임이 안 끝났을 때 -> .(놓을 수 있는 곳) 남았을 떄
			if (!win_X && !win_O && cnt_X + cnt_O != 9) valid = false;
			
			// X가 이겼는데 돌 갯수가 안 맞을 때
			if (win_X && cnt_X != cnt_O + 1) valid = false;
			
			// O가 이겼는데 돌 갯수가 안 맞을 때
			if (win_O && cnt_O != cnt_X) valid = false;
			
			
			// ------------- 결과 -----------------
			if (valid) {
				System.out.println("valid");
			}
			else System.out.println("invalid");
		}
	}
	
	
	
	static boolean win(char[] arr, char ch) {
		for (int[] line : lines) {
			if (arr[line[0]] == ch && arr[line[1]] == ch && arr[line[2]] == ch) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
