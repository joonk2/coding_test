import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


//import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 5;
		char[][] matrix = new char[N][15];
		
		for (int r = 0; r < N; r++) {
			String words = br.readLine();
			for (int c = 0; c < words.length(); c++) {
				matrix[r][c] = words.charAt(c);
			}
		}
		
		
		
		for (int c = 0; c < 15; c++) {
			for (int r = 0; r < N; r++) {
				if (matrix[r][c] != '\0') {
					System.out.print(matrix[r][c]);
				}
			}
		}
		
		
	}
}