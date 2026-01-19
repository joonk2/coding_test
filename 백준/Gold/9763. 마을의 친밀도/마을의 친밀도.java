/*
중간인 B를 먼저 고정한다
A를 먼저 고른 후에, C를 고른다
*/

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
			arr[i][2] = Integer.parseInt(str[2]);
		}
		
		int answer = Integer.MAX_VALUE;
		// B를 중심으로 고정
		for (int B = 0; B < N; B++) {
			int A = Integer.MAX_VALUE;
			int C = Integer.MAX_VALUE;
			// B -> 다른 모든 점들의 거리
			for (int i = 0; i < N; i++) {
				// 같은 점이면 skip
				if (B == i) continue;
				
				int dist = Math.abs(arr[B][0] - arr[i][0])
						+ Math.abs(arr[B][1] - arr[i][1])
						+ Math.abs(arr[B][2] - arr[i][2]);
				
				// 갱신 (왼쪽 먼저, 그다음 오른쪽)
				if (dist < A) {
					C = A;
					A = dist;
				}
				else if (dist < C) {
					C = dist;
				}
			}
			answer = Math.min(answer, A + C);
			
			// 조기종료
			if (answer == 2) break;
		}
		System.out.println(answer);
	}
}