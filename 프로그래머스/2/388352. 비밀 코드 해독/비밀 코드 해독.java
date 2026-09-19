class Solution {
    static int answer = 0;
    
    
    public int solution(int n, int[][] q, int[] ans) {
        // 오름차순 정렬이기에 위치가 다른 중복이 불가능이라 P가 아니라 C
        // 그래서 최악의 연산 (30C5 * 10 * 5 * 5) -> 약 3560만 (충분히 1억 연산 이내 통과)
        
        
        // 1. 조합 생성기 작동시작
        boolean[] visited = new boolean[n+1];
        int[] my_comb = new int[5];
        int idx = 0;
        for (int i = 1; i < n+1; i++) {
            int num = i;
            visited[idx] = true;
            my_comb[idx] = num;
            comb_maker(num+1, idx+1, my_comb, visited, n, q, ans);
            visited[idx] = false;
        }
        
        // 2. 가능한 조합의 갯수 반환
        return answer;
    }
    
    
    
    // 3. 함수 (조합 생성기)
    static void comb_maker(int num, int idx, int[] my_comb, boolean[] visited, int n, int[][] q, int[] ans) {
        
        // 3-1. 임의의 조합에 숫자 5개 다 채웠다면?
        if (idx == 5) {
            // 3-1-a. 가능한 조합이면 answer++
            if (is_valid(my_comb, q, ans)) {
                answer++;
            }
            // 3-1-b. 검사후 종료
            return;
        }
        
        // 3-2. 가지치기 (불가능한 조합일떄)
        if (num + 4 - idx > n) return;
        
        // 3-3. 그외는 조합 생성
        for (int next_num = num; next_num < n+1; next_num++) {
            visited[next_num] = true;
            my_comb[idx] = next_num;
            comb_maker(next_num+1, idx+1, my_comb, visited, n, q, ans);
            visited[next_num] = false;
        }
    }
    
    
    
    
    // 4. 함수 (가능한 조합인지 검사)
    static boolean is_valid(int[] my_comb, int[][] q, int[] ans) {
        int row = q.length;
        int col = q[0].length;
        for (int r = 0; r < row; r++) {
            int req_cnt = ans[r];
            int cnt = 0;
            
            // 4-1. 입력한 정수들과 내 조합 각각 비교 
            for (int c = 0; c < col; c++) {
                for (int k = 0; k < my_comb.length; k++) {
                    if (q[r][c] == my_comb[k]) cnt++;
                }
            }
            // 4-2. 만약 필요한 암호횟수와 나의 암호갯수가 일치안하면 -> false
            if (req_cnt != cnt) return false;
        }
        
        // 4-3. 필요한 암호횟수와 나의 암호갯수가 전부 일치시 -> true
        return true; 
    }
    
    
}