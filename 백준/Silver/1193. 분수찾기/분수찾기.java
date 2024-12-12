import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        System.out.println(fraction(X));
    }


    public static String fraction(int X) {
        int line = 1;
        while (X > line) {
            X -= line;
            line++;
        }

        int top, bottom;
        if (line % 2 == 1) {
            bottom = X;
            top = line - X + 1;
        }

        else {
            top = X;
            bottom = line - X + 1;
        }

        return top + "/" + bottom;

    }



}