import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();


        // arr A
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }


        // arr B
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }


        // res
        int res = converter(N,A,B);
        System.out.println(res);
    }






    public static int converter(int N, List<Integer> A, List<Integer> B) {
        Collections.sort(A);

        int sum = 0;

        for (int i = 0; i < N; i++) {
            int x = A.get(i);
            int y = Collections.max(B);
            B.remove(Integer.valueOf(y));

            sum += (x * y);
        }

        return sum;
    }




}