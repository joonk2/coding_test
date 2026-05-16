import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Solution {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			// 1. 초기값 채우기
			for (int i = 0; i < N; i++) {
				arr[i][0] = 1;
				arr[i][i] = 1;
			}
			
			// 2. 계산
			for (int r = 1; r < N; r++) {
				for (int c = 1; c < r+1; c++) {
					arr[r][c] = arr[r-1][c-1] + arr[r-1][c];
				}
			}
			
			
			// 3. 출력
			System.out.println("#" + tc);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < r+1; c++) {
					System.out.print(arr[r][c] + " ");
				}
				System.out.println();
			}
			
			
		}
		
		
	}
}