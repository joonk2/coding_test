import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // A, B, C 입력 값
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 출력 값
        System.out.println((A+B)%C);
        System.out.println( ((A%C) + (B%C)) % C );
        System.out.println( (A*B)%C );
        System.out.println( ((A%C)*(B%C)) % C );
    }
}
