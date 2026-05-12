import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class Solution {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String[] NMK = br.readLine().split(" ");
			String[] t_arr = br.readLine().split(" ");
			
			int N = Integer.parseInt(NMK[0]);
			int M = Integer.parseInt(NMK[1]);
			int K = Integer.parseInt(NMK[2]);
			int[] t = new int[N];
			for (int i = 0; i < N; i++) {
				t[i] = Integer.parseInt(t_arr[i]);
			}
			
			
			// 1-1. 1중반복문
			Arrays.sort(t);
			
			// 1-2. 초기 갯수 확보
			int extra = 0;
			int prev_mod = 0;
			boolean can_you_offer = true;
			for (int i = 0; i < N; i++) {
				int cur_time = t[i];
				
				// 2-1. 제작시간보다 사람이 더 빨리오면 불가능
				if (cur_time < M) {
					can_you_offer = false;
					break;
				}
				
				// 2-2. 사람이 재때 맞춰올떄
				
				// 2-3. 몫을 활용해 나눠줄 수 있나 보자 
				int cur_mod = cur_time / M;
				if (cur_mod > prev_mod) {
					
					// 2-3-a. 이전 시간의 생산량과 겹치지 않게 차감
					int cur_extra = (cur_mod - prev_mod) * K;
					extra += cur_extra;
					extra--;
					
					// 2-3-b. 갱신
					prev_mod = cur_mod;
				}
				else if (cur_mod <= prev_mod) {
					if (extra >= 1) {
						extra--;
					}
					else if (extra < 1) {
						can_you_offer = false;
						break;
					}
				}
			}
			// 3. 출력
			if (can_you_offer) {
				System.out.println("#" + tc + " " + "Possible");
			}
			else if (!can_you_offer) {
				System.out.println("#" + tc + " " + "Impossible");
			}
			
		}
		
		
	}
}