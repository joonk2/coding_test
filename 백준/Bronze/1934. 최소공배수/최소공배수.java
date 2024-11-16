import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int div = gcd(A, B);
            sb.append(A*B / div + "\n");
        }

        System.out.println(sb.toString());
    }

    
    
    
    
    private static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        else {
            return gcd(B, A % B);
        }
    }




}