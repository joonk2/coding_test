import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.List;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] s_arr = br.readLine().split(" ");
			int[] team_cnt = new int[201];
			List<Integer>[] lst = new ArrayList[201];
			for (int i = 1; i < 201; i++) {
				lst[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < N; i++) {
				int temp_num = Integer.parseInt(s_arr[i]);
				team_cnt[temp_num]++;
			}
			
			int score = 1;
			for (int i = 0; i < N; i++) {
				int temp_num = Integer.parseInt(s_arr[i]);
				if (team_cnt[temp_num] == 6) {
					lst[temp_num].add(score);
					score++;
				}
			}
			
			who_is_the_winner(team_cnt, lst);
		}
	}
	
	
	
	static void who_is_the_winner(int[] team_cnt, List<Integer>[] lst) {
		int rank = -999;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < 201; i++) {
			if (team_cnt[i] == 6) {
				int temp_sum = 0;
				for (int j = 0; j < 4; j++) {
					temp_sum += lst[i].get(j);
				}
				
				if (rank == -999 || min > temp_sum) {
					min = temp_sum;
					rank = i;
				}
				else if (min == temp_sum) {
					if (lst[rank].get(4) > lst[i].get(4)) {
						rank = i;
					}
				}
			}
		}
		System.out.println(rank);
	}
	
};