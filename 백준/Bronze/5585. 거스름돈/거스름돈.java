/*
1. cond1 -->  5 <= K <= 15 != --> break
2. cond2 -->  2 <= K <= N != --> break
3. cond3 --> 1 1 1 1 1 일때 K=3 이면 안되는 경우다.

3. check(row, col)
 */



/*
1. 최소 잔돈 구하기
2.  1 <= money < 1000
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int mod;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// cond : 1 <= money < 1000
		if (N < 1 || N > 1000) {
			return; // end
		}
		else {
			int cnt = 0;
			N = 1000 - N;
			
			int[] coin_lst = {500, 100, 50, 10, 5, 1};
			for (int c : coin_lst) {
				cnt += N / c;
				N %= c;
				
				
			}
			
			
			
			
			System.out.println(cnt);
			
		}
	
	
	
	}
}
