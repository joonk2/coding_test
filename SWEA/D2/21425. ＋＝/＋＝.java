import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Solution {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String[] arr = br.readLine().split(" ");
			
			int A = Integer.parseInt(arr[0]);
			int B = Integer.parseInt(arr[1]);
			int N = Integer.parseInt(arr[2]);
			
			int x = A;
			int y = B;
			int cnt = 0;
			
			while (true) {
				if (x > N || y > N) break;
				
				if (x < y) {
					x += y;
				}
				else if (x >= y) {
					y += x;
				}
				cnt++;
			}
			
			System.out.println(cnt);
			
		}
		
		
	}
}