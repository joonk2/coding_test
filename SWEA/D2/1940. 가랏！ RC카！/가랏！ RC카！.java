import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Solution {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			
			// 최종 이동한 거리, 현재 속도
			int total_dist = 0;
			int cur_speed = 0;
			for (int i = 0; i < N; i++) {
				// 현재 움직인 거리
				int cur_move = 0;
				String[] arr = br.readLine().split(" ");
				int button = 0;
				int temp_speed = 0;
				
				if (arr.length == 1) {
					button = Integer.parseInt(arr[0]);
				}
				else {
					button = Integer.parseInt(arr[0]);
					temp_speed = Integer.parseInt(arr[1]);
				}
				
				// button
				if (button == 0) {
					cur_move = cur_speed;
				}
				else if (button == 1) {
					cur_speed += temp_speed;
					cur_move = cur_speed;
				}
				else if (button == 2) {
					if (temp_speed > cur_speed) {
						cur_speed = 0;
					}
					else {
						cur_speed -= temp_speed;
					}
					cur_move = cur_speed;
				}
				
				// 최종 거리 합산
				total_dist += cur_move;
			}
			
			System.out.println("#" + tc + " " + total_dist);
			
			
			
			
		}
		
		
	}
}