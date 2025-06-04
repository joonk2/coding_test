import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		int size = ++N;
		int[] box = new int[size];
//		System.out.println(Arrays.toString(box));
		
		for (int i = 0; i < size; i++) {
			box[i] = i;
		}
		
		for (int k = 0; k < M; k++) {
			String[] ij = br.readLine().split(" ");
			int i = Integer.parseInt(ij[0]);
			int j = Integer.parseInt(ij[1]);
			
			while (i < j) {
				int temp = box[i];
				box[i] = box[j];
				box[j] = temp;
				i++;
				j--;
			}
			
		}
//		System.out.println(Arrays.toString(box));
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < size; i++) {
			if (i != size-1) {
				sb.append(box[i] + " ");
			}
			else {
				sb.append(box[i]);
			}
			
		}
		System.out.println(sb);
		
	}
}