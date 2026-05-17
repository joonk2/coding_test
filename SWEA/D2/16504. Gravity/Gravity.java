import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Solution {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			
			int[] arr = new int[N];
			for (int i = 0; i < s.length; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			
			
			// 정렬은 필요없다!!! XXX
			
			// 자기보다 낮은게 오른쪽에 있을때 이동가능
			int max_move = 0;
			for (int i = 0; i < N-1; i++) {
				int cur_move = 0;
				for (int j = i+1; j < N; j++) {
					if (arr[i] > arr[j]) cur_move++;
				}
				// 갱신
				max_move = Math.max(max_move, cur_move);
			}
			
			System.out.println("#" + tc + " " + max_move);
			
			
		}
		
		
	}
}