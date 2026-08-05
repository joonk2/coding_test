class Solution {
    public boolean predictTheWinner(int[] nums) {
        int N = nums.length;
        int sum_p1 = 0;
        int sum_p2 = 0;
        int s = 0;
        int e = N-1;
        int turn = 0;
        
        // 1. 조합 (2^20)
        boolean answer = comb(nums, s, e, sum_p1, sum_p2, turn);

        // 2. 결과 (p1이 이겼다면 true)
        if (answer) {
            return true;
        }
        // 3. p2가 이겼다면 false
        return false;
    }


    // 4. 조합 함수
    static boolean comb(int[] nums, int s, int e, int sum_p1, int sum_p2, int turn) {
        // 4-1. 만약 모든 차례가 끝났다면?
        if (s > e) {
            // 4-1-a. p1의 점수가 크거나 같다면?
            if (sum_p1 >= sum_p2) {
                return true;
            }
            // 4-1-b. p2의 점수가 더 크다면?
            return false;
        }
        
        // 4-2. p1부터 먼저 시작
        if (turn % 2 == 0) {
            
            // 4-2-a. 왼쪽 선택 (왼쪽 인덱스 증가)
            boolean left = comb(nums, s+1, e, sum_p1 + nums[s], sum_p2, turn+1);

            // 4-2-b. 오른쪽 선택 (오른쪽 인덱스 감소)
            boolean right = comb(nums, s, e-1, sum_p1 + nums[e], sum_p2, turn+1);

            // 4-2-c. p1은 왼쪽에서 출발하나 오른쪽에서 출발하나 많은 경로 중에 1개만이라도 이기면 됨
            if (left == true || right == true) {
                return true;
            }
        }
        // 4-3. p2 차례
        else if (turn % 2 == 1) {

            // 4-3-a. 왼쪽 차례 (왼쪽 인덱스 증가)
            boolean left = comb(nums, s+1, e, sum_p1, sum_p2 + nums[s], turn+1);

            // 4-3-b. 오른쪽 차례 (오른쪽 인덱스 감소)
            boolean right = comb(nums, s, e-1, sum_p1, sum_p2 + nums[e], turn+1);

            // 4-3-c. p1이 이길려면 p2 차례의 left, right 재귀도 둘다 true일것
            if (left == true && right == true) {
                return true;
            }
        }

        // 4-4. 어떤 경우라도 p1이 이길 수 없다면?
        return false;
    }

}