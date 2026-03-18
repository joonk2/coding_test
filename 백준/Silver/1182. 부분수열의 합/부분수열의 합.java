import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N, S;
	static int cnt = 0;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NS = br.readLine().split(" ");
		String[] s_arr = br.readLine().split(" ");
		N = Integer.parseInt(NS[0]);
		S = Integer.parseInt(NS[1]);
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s_arr[i]);
		}
		
		// 1. 초기 탐색 시작
		for (int i = 0; i < N; i++) {
			back_tracking(i+1, arr[i]);
		}
		
		// 3. 출력
		System.out.println(cnt);
	}
	
	

	// 2. 조합 (부분집합의 합을 구하기 위함)
	static void back_tracking(int depth, int sum) {
		
		// 2-1. 최대깊이 도달시
		if (depth == N) {
			if (sum == S) cnt++;
			return;
		}
		
		// 2-2. 아직 도달 못했을때
		
		// a. 선택
		back_tracking(depth + 1, sum + arr[depth]);
		
		// b. 미선택
		back_tracking(depth + 1, sum);
	}
	
	
}