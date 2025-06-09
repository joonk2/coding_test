import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		int[][] matrix_N = new int[N][M];
		int[][] matrix_M = new int[N][M];

		// 첫 번째 행렬 입력
		for (int i = 0; i < N; i++) {
			String[] col = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				matrix_N[i][j] = Integer.parseInt(col[j]);
			}
		}

		// 두 번째 행렬 입력
		for (int i = 0; i < N; i++) {
			String[] col = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				matrix_M[i][j] = Integer.parseInt(col[j]);
			}
		}

		// 두 행렬의 합
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < M; j++) {
				sb.append(matrix_N[i][j] + matrix_M[i][j]).append(" ");
			}
			System.out.println(sb.toString().trim());
		}
	}
}
