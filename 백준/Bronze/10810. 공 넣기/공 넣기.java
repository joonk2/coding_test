import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		int[] box = new int[N+1];
		
		for (int x = 0; x < M; x++) {
			String[] ijk = br.readLine().split(" ");
			int i = Integer.parseInt(ijk[0]);
			int j = Integer.parseInt(ijk[1]);
			int k = Integer.parseInt(ijk[2]);
			for (int y = i; y < j+1; y++) {
				box[y] = k;
			}
		}
		
//		System.out.println(Arrays.toString(box));
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N+1; i++) {
			sb.append(box[i] + " ");
		}
		System.out.println(sb);
		
	}
}