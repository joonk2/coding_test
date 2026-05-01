import java.io.*;
import java.util.*;
 
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
        int[] lastday = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
 
        for (int test_case = 1; test_case <= T; test_case++) {
            String date = br.readLine();
 
            String year = date.substring(0, 4);
            String month = date.substring(4, 6);
            String day = date.substring(6, 8);
 
            int m = Integer.parseInt(month);
            int d = Integer.parseInt(day);
 
            String answer;
 
            if (m >= 0 && m <= 12 && d > 0 && d <= lastday[m]) {
                answer = year + "/" + month + "/" + day;
            } else {
                answer = "-1";
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}