class Solution {
    static int[] answer;
    static int[] discount_rate = {10, 20, 30, 40};
    static int m;
    static int max_membership;
    static int max_price_sum;
    
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        m = emoticons.length;
        max_membership = 0;
        max_price_sum = 0;
        int[] selected_discount_rate =  new int[m];
        
        back_tracking(0, users, emoticons, selected_discount_rate);
        answer[0] = max_membership;
        answer[1] = max_price_sum;
        
        return answer;
    }
    
    
    static void back_tracking(int idx, int[][] users, int[] emoticons, int[] selected_discount_rate) {
        // 최대 깊이 도달시 -> 계산하고 종료
        if (idx == m) {
            calculate(users, emoticons, selected_discount_rate);
            return;
        }
        
        // 최대깊이 도달 못했으면 계속 탐색
        for (int i = 0; i < 4; i++) {
            selected_discount_rate[idx] = discount_rate[i];
            back_tracking(idx+1, users, emoticons, selected_discount_rate);
        }

    }
    

    
    static void calculate(int[][] users, int[] emoticons, int[] selected_discount_rate) {
        int cur_membership = 0;
        int cur_price_sum = 0;
        
        for (int[] u : users) {
            int limit_discount = u[0];
            int limit_price_sum = u[1];
            
            int temp_price_sum = 0;
            for (int i = 0; i < m; i++) {
                int cur_discount = selected_discount_rate[i];
                
                // 현재 할인율이 더 낮다면 넘겨쁘리
                if (cur_discount < limit_discount) continue;
                
                // 안그렇다면
                int rate = 100 - cur_discount;
                int temp_price = (emoticons[i] * rate) / 100;
                temp_price_sum += temp_price;
            }
            
            // 확인 -> 임시가격합이 내가 허용한 가격합보다 이상이면 플러스 가입
            // 그게 아니라면 그냥 현재 가격합에 임시가격합을 누적 합산
            if (temp_price_sum >= limit_price_sum) {
                cur_membership++;
            }
            else if (temp_price_sum < limit_price_sum) {
                cur_price_sum += temp_price_sum;
            }
        }
        
        // 최종확인 -> 갱신
        // 우선순위를 본다
        // 1순위 플러스가입
        // 2순위 최대 구매 가격
        // 플러스 가입자수가 더 클때는, 최대 가입자수, 최대 가격 갱신
        // 플러스가입자수가 같을때는, 최대 구매가격이 제일 높아야겠네?
        
        if (max_membership < cur_membership) {
            max_membership = cur_membership;
            max_price_sum = cur_price_sum;
        }
        else if (max_membership == cur_membership) {
            if (max_price_sum < cur_price_sum) {
                max_price_sum = cur_price_sum;
            }
        }
    }
    
    
    
}