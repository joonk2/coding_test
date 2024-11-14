import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(Fibo(N));
    }

    public static int Fibo(int N) {
        if (N <= 1) {
            return N;
        }
        return Fibo(N-2) + Fibo(N-1);
    }




}