import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String[] dial = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        int cnt = 0;

        for (char ch : word.toCharArray()) {
            for (int i = 0; i < dial.length; i++) {
                if (dial[i].contains(String.valueOf(ch))) {
                    cnt += i + 3;
                }
            }
        }

        System.out.println(cnt);
    }
}

