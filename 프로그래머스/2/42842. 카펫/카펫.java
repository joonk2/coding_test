class Solution {
    public int[] solution(int brown, int yellow) {
        
        
        int total =  brown + yellow;
        
        int sqrt = 1;
        while (sqrt * sqrt <= total) {
            if (sqrt * sqrt == total) {
                break;
            }
            sqrt++;
        }
        
        
        int row = 0;
        int col = 0;
        int min_diff = Integer.MAX_VALUE;
        for (int i = total; i >= sqrt; i--) {
        	    if (total % i == 0) {
                    int r = i;
                    int c = total / i;
                    if ( (r-2) * (c-2) == yellow ) {
                        row = r;
                        col = c;
                        break;
                    }
                }
        }
        
        int[] answer = new int[2];
        answer[0] = row;
        answer[1] = col;
        return answer;
    }
}