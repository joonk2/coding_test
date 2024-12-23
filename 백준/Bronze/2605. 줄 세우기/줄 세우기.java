/*
[ (0,1) ]
[(0,2) (0,1) ]
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr.add(i-num, i+1);
        }


        for (int a : arr) {
            System.out.print(a + " ");
        }


    }
}