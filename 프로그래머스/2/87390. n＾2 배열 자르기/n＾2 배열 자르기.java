class Solution {
    public int[] solution(int n, long left, long right) {
        int[] arr = new int[(int) (right-left) + 1];
        
        int idx = 0;
        while (left <= right) {
            int mod = (int) (left / n);
            int remainder = (int) (left % n);
            
            if (mod < remainder) {
                arr[idx] = remainder + 1;
                left++;
                idx++;
            }
            else if (mod >= remainder) {
                arr[idx] = mod + 1;
                left++;
                idx++;
            }
        }
        
        
        
        
        return arr;
    }
}