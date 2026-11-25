class Solution {
    static int answer;
    
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        
        // 1. 백트랙킹
        int idx = 0;
        int N = minerals.length;
        int cur_sum = 0;
        int dia = picks[0];
        int iron = picks[1];
        int stone = picks[2];
        back_tracking(idx, minerals, N, cur_sum, dia, iron, stone);
        
        // 3. 답 변환
        return answer;
    }
    
    
    
    
    // 2. 함수 (백트랙킹)
    static void back_tracking(int cur_idx, String[] minerals, int N, int cur_sum, int dia, int iron, int stone) {
        // 2-1. 만약 (끝점 도달했거나, dia, iron, stone 삽이 0이면 최소값 비교후 갱신)
        if (cur_idx == N || (dia == iron && iron == stone && stone == 0)) {
            answer = Math.min(cur_sum, answer);
            return;
        }
        
        
        // 2-2. 위 경우가 아닐때
        
        // 2-2-a. (dia 삽 > 0)
        if (dia > 0) {
            int new_idx = cur_idx;
            int new_sum = cur_sum;
            for (int i = 0; i < 5; i++) {
                if (new_idx == N) break;
                new_sum++;
                new_idx++;
            }
            back_tracking(new_idx, minerals, N, new_sum, dia-1, iron, stone);
        }
        
        // 2-2-b. (iron 삽 > 0) {
        if (iron > 0) {
            int new_idx = cur_idx;
            int new_sum = cur_sum;
            for (int i = 0; i < 5; i++) {
                if (new_idx == N) break;
                
                String cur_jewel = minerals[new_idx];
                if (cur_jewel.equals("diamond")) new_sum += 5;
                else if (!cur_jewel.equals("diamond")) new_sum++;
                new_idx++;
            }
            back_tracking(new_idx, minerals, N, new_sum, dia, iron-1, stone);
        }
        
        // 2-2-c. (stone 삽 > 0)
        if (stone > 0) {
            int new_sum = cur_sum;
            int new_idx = cur_idx;
            for (int i = 0; i < 5; i++) {
                if (new_idx == N) break;
                
                String cur_jewel = minerals[new_idx];
                if (cur_jewel.equals("diamond")) new_sum += 25;
                else if (cur_jewel.equals("iron")) new_sum += 5;
                else new_sum++;
                
                new_idx++;
            }
            back_tracking(new_idx, minerals, N, new_sum, dia, iron, stone-1);
        }
        
        
        
    }

    
    
}