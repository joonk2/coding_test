import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

class Solution {
    static boolean[] visited;
    static int N;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        answer = bfs(begin, target, words);
        return answer;
    }
    
    
    static int bfs(String begin, String target, String[] words) {
        Queue<int[]> q = new LinkedList<>();
        N = words.length;
        visited = new boolean[N];
        
        // 1글자 다른 단어를 q에 최초 1회 삽입
        for (int i = 0; i < N; i++) {
            if (!visited[i] && if_one_word_is_different(begin, words[i])) {
                q.add(new int[] {i, 1});
                visited[i] = true;
            }
        }
        
        // 탐색
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int idx = cur[0];
            int dist = cur[1];
            
            if (words[idx].equals(target)) {
                return dist;
            }
            
            for (int i = 0; i < N; i++) {
                if (!visited[i] && if_one_word_is_different(words[idx], words[i])) {
                    q.add(new int[] {i, dist+1});
                    visited[i] = true;
                }
            }
                
        }
        
        
     return 0;   
    }
    
    
    
    
    
    static boolean if_one_word_is_different(String s1, String s2) {
        int temp_cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                temp_cnt++;
            }
            if (temp_cnt > 1) {
                return false;
            }
        }
        
        return true;
    }
    
    
    
}