import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	static int[][] arr;
	static int[] moonduri;
	static int N, answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			String[] rgb = br.readLine().split(" ");
			int r = Integer.parseInt(rgb[0]);
			int g = Integer.parseInt(rgb[1]);
			int b = Integer.parseInt(rgb[2]);
			arr[i][0] = r;
			arr[i][1] = g;
			arr[i][2] = b;
		}
		String[] moonduri_arr = br.readLine().split(" ");
		moonduri = new int[3];
		for (int i = 0; i < 3; i++) {
			moonduri[i] = Integer.parseInt(moonduri_arr[i]);
		}

		
		answer = Integer.MAX_VALUE;
		back_tracking(0,0,0,0,0);
		System.out.println(answer);
	}
	
	
	
	
	static void back_tracking(int idx, int cnt, int r, int g, int b) {
		// 갯수 있을때 고르기 (최소 2개 이상, 단 7개 전부 고를 필요 X)
		if (cnt >= 2 && cnt <= 7) {
			int avg_r = r / cnt;
			int avg_g = g / cnt;
			int avg_b = b / cnt;
			
			int temp_sum = Math.abs(avg_r - moonduri[0])
							+ Math.abs(avg_g - moonduri[1])
							+ Math.abs(avg_b - moonduri[2]);
			
			answer = Math.min(answer, temp_sum);
		}
		
		
		// 2. 끝지점 도달 or 7개일때 종료
		if (cnt == 7 || idx == N) return;
		
		
		
		// 선택
		back_tracking(idx+1, cnt+1, r + arr[idx][0], g + arr[idx][1], b + arr[idx][2]);
		
		// 미선택
		back_tracking(idx+1, cnt, r, g, b);
	}
	
	
}