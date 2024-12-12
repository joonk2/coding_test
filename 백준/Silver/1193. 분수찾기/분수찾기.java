/*
X=4
4-1 -> line=2
3-2 -> line=3
X=1, line=3
1/3

X=5
5-1 -> line=2
4-2 -> line=3
X=2, line=3
2/2

X=6
6-1 -> line=2
5-2 -> line=3
X=3, line=3

X=7
7-1 -> line=2
6-2 -> line=3
4-3 -> line=4
X=1, line=4
1/4

X=8
8-1 -> line=2
7-2 -> line=3
5-3 -> line=4
X=2, line=4
2/3
 */

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
