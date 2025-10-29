import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


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
		int[] reverse = new int[N];
		for (int i = 0; i < N; i++) {
			reverse[i] = original[N-1-i];
		}
		
		int[] original_extended = new int[N*2];
		int[] reverse_extended = new int[N*2];
		for (int i = 0; i < N*2; i++) {
			original_extended[i] = original[i%N];
			reverse_extended[i] = reverse[i%N];
		}
		
		lets_see(original_extended, reverse_extended, target, N);
	}
	
	
	
	
	
	static void lets_see(int[] original_extended, int[] reverse_extended, int[] target, int N) {
		boolean is_good_puzzle = false;
		for (int i = 0; i < N; i++) {
			boolean is_matching_o = true;
			boolean is_matching_r = true;
			for (int j = i; j < N+i; j++) {
				if (original_extended[j] != target[j-i]) {
					is_matching_o = false;
					break;
				}
			}
			for (int j = i; j < N+i; j++) {
				if (reverse_extended[j] != target[j-i]) {
					is_matching_r = false;
					break;
				}
			}
			// check
			if (is_matching_o == true || is_matching_r == true) {
				is_good_puzzle = true;
				break;
			}
		}
		if (is_good_puzzle) {
			System.out.println("good puzzle");
		}
		else {
			System.out.println("bad puzzle");
		}
	}
	
	
	
}