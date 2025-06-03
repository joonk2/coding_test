import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String[] AB = br.readLine().split(" ");
			
			int A = Integer.parseInt(AB[0]);
			int B = Integer.parseInt(AB[1]);
			bw.write((A+B) + "\n");
		}
		bw.flush();
		bw.close();
		
		
	}
}