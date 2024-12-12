/*
      1
    / | \
   2  |  3
    \ | /
      4
*/

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().trim().split(" ");
        int N = Integer.parseInt(S[0]);
        int M = Integer.parseInt(S[1]);
        int V = Integer.parseInt(S[2]);

        int[][] graph = new int[N+1][N+1];
        boolean[] dfs_v = new boolean[N+1];
        boolean[] bfs_v = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            String[] link = br.readLine().trim().split(" ");
            int x = Integer.parseInt(link[0]);
            int y = Integer.parseInt(link[1]);
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        // DFS
        dfs(V, N, graph, dfs_v);
        System.out.println();

        // BFS
        bfs(V, N, graph, bfs_v);


    }





    // DFS
    public static void dfs(int V, int N, int[][] graph, boolean[] dfs_v) {
        dfs_v[V] = true;
        System.out.print(V + " ");

        for (int i = 1; i < N+1; i++) {
            if (!dfs_v[i] && graph[V][i] == 1) {
                dfs(i, N, graph, dfs_v);
            }
        }
    }


    // BFS
    public static void bfs(int V, int N, int[][] graph, boolean[] bfs_v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        bfs_v[V] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int i = 1; i < N+1; i++) {
                if (!bfs_v[i] && graph[node][i] == 1) {
                    queue.add(i);
                    bfs_v[i] = true;
                }
            }
        }
    }




}