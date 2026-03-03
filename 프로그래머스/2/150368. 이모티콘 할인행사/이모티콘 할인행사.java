class Solution {
    static int[] discounted_price_rate = {10, 20, 30, 40};
    static int m;
    static int max_membership, max_price;
    static int[] discount_rate = {10, 20, 30, 40};
    
    static int[] answer;
    
    
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        
        m = emoticons.length;
        int[] selected_discount_rate = new int[m];
        
        max_membership = 0;
        max_price = 0;
        back_tracking(0, selected_discount_rate, users, emoticons);
        
        answer[0] = max_membership;
        answer[1] = max_price;

        return answer;
    }
    
    
    
    
    static void back_tracking(int idx, int[] selected_discount_rate, int[][] users, int[] emoticons) {
        
        // 끝지점 도달시
        if (idx == m) {
            calculate(selected_discount_rate, users, emoticons);
            return;
        }
        
        // 아직 끝지점 아니라면
        for (int i = 0; i < 4; i++) {
            selected_discount_rate[idx] = discount_rate[i];
            back_tracking(idx+1, selected_discount_rate, users, emoticons);
        }
        
    }
    
    
    
    static void calculate(int[] selected_discount_rate, int[][] users, int[] emoticons) {
        int cur_membership = 0;
        int cur_price_sum = 0;
        
        for (int[] u : users) {
            int limit_discount = u[0];
            int limit_price = u[1];
            int temp_price_sum = 0;
            
            for (int i = 0; i < m; i++) {
                // 현재 할인율
                int cur_discount_rate = selected_discount_rate[i];
                
                // (내가 허용하는 할인율 > 현재 할인율) -> skip
                if (limit_discount > cur_discount_rate) continue;
                
                // 현재 할인율이 더 싸면
                int rate = (100 - cur_discount_rate);
                int temp_price = (emoticons[i] * rate) / 100;
                temp_price_sum += temp_price;
            }
            
            // (현재 총가격 >= limit_price) -> 멤버쉽 추가
            if (temp_price_sum >= limit_price) {
                cur_membership++;
            }
            // 그렇지 않다면 -> 구매가격 추가
            else if (temp_price_sum < limit_price) {
                cur_price_sum += temp_price_sum;
            }
        }
        
        // 최종 비교
        // 멤버쉽 가입이 1순위, 구매가 2순위
        if (max_membership < cur_membership) {
            max_membership = cur_membership;
            max_price = cur_price_sum;
        }
        else if (max_membership == cur_membership) {
            if (max_price < cur_price_sum) {
                max_price = cur_price_sum;
            }
        }
        
        
    }
    
    
    
}