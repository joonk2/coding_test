import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N, K;
	static int[] w;
	static int answer = 0;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		N = Integer.parseInt(NK[0]);
		K = Integer.parseInt(NK[1]);
		String[] arr = br.readLine().split(" ");
		w = new int[N];
		for (int i = 0; i < N; i++) {
			w[i] = Integer.parseInt(arr[i]);
		}
		visited = new boolean[N];
		back_tracking(0, 500);
		System.out.println(answer);
	}
	
	
	
	
	static void back_tracking(int idx, int cw) {
		if (idx == N) {
			answer++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			int nw = cw + w[i] - K;
			if (nw >= 500) {
				if (!visited[i]) {
					visited[i] = true;
					back_tracking(idx+1, nw);
					visited[i] = false;
				}
			}
		}
	}
	
}