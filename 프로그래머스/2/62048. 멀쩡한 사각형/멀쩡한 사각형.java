class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        long my_gcd = gcd(w, h);
        long to_minus = ( (long) w+h ) - my_gcd;
        answer = ( (long) w*h ) - to_minus;
        
        return answer;
    }
    
    
    static long gcd(int w, int h) {
        long a = Math.max(w, h);
        long b = Math.min(w, h);
        long res = 0;
        
        while (b != 0) {
            long remainder = (long) (a % b);
            a = b;
            b = remainder;
        }
        res = a;
        return res;
    }
    
    
}