import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] parents;
    static boolean[] v;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // graph
        graph = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        // link
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        parents = new int[N+1];
        v = new boolean[N+1];

        // start
        dfs(1);

        // print parents
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N+1; i++) {
            sb.append(parents[i]).append('\n');
        }
        System.out.print(sb);

        
    }





    // DFS
    static void dfs(int i) {
        v[i] = true;
        for (int n : graph[i]) {
            if (!v[n]) {
                parents[n] = i;
                dfs(n);
            }
        }
    }





}