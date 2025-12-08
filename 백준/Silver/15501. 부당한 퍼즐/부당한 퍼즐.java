import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s1 = br.readLine().split(" ");
		String[] s2 = br.readLine().split(" ");
		int[] original = new int[N];
		int[] target = new int[N];
		
		for (int i = 0; i < N; i++) {
			original[i] = Integer.parseInt(s1[i]);
			target[i] = Integer.parseInt(s2[i]);
		}
		
		// 회전배열을 시작할 기준값의 idx 탐색
		// original[0]을 target[idx]에서 기준값으로 시작하자
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if (target[i] == original[0]) {
				idx = i;
			}
		}
		
		boolean clock_ok = true;
		boolean clockwise_ok = true;
		for (int i = 0; i < N; i++) {
			int clock_i = (idx + i) % N;
			int clockwise_i = (idx - i + N) % N;
			
			if (target[clock_i] != original[i]) {
				clock_ok = false;
			}
			if (target[clockwise_i] != original[i]) {
				clockwise_ok = false;
			}
		}
		
		// result
		if (clock_ok || clockwise_ok) {
			System.out.println("good puzzle");
		}
		else {
			System.out.println("bad puzzle");
		}
		
		
	}
}
