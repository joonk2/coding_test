/*
dist 배열을 먼저 만든다
그 후 arr 배열을 만들고 정렬을 한다
HashMap으로 순위 찾기
순위는 역순 for 문으로 찾는다

등수가 같으면 pass
ex) 1,1,1, 6
이면 6은 4등이 된다
*/



import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// 정렬
import java.util.Arrays;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dist = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] w_h = br.readLine().split(" ");
			int w = Integer.parseInt(w_h[0]);
			int h = Integer.parseInt(w_h[1]);
			int val = (w*w) + (h*h);
			dist[i][0] = val;
			dist[i][1] = i+1;
		}
		
		// 정렬
		Arrays.sort(dist, (a,b) -> {
			// 모든 숫자가 같지 않다면 -> 내림차순
			if (a[0] != b[0]) {
				return Integer.compare(b[0], a[0]);
			}
			// 모든 숫자가 같다면 등수를 내림차순
			return Integer.compare(a[1], b[1]);
		});
		
		
		
		// 결과
		for (int i = 0; i < N; i++) {
			System.out.println(dist[i][1]);
		}
		
		
		
		
	}
}