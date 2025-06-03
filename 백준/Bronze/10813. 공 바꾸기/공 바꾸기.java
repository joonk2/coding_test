import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

//import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		int box_size = ++N;
//		System.out.println(box_size);
		
		int[] box = new int[box_size];
		for (int i = 0; i < box_size; i++) {
			box[i] = i;
		}
//		System.out.println(Arrays.toString(box));
		
		for (int k = 0; k < M; k++) {
			String[] ij = br.readLine().split(" ");
			int i = Integer.parseInt(ij[0]);
			int j = Integer.parseInt(ij[1]);
			int temp = box[i];
			box[i] = box[j];
			box[j] = temp;
		}
//		System.out.println(Arrays.toString(box));
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < box_size; i++) {
			sb.append(box[i] + " ");
		}
		System.out.println(sb);
	}
}