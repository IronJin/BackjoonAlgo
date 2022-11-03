import java.util.*;
class Solution {
    //투포인터 문제
    public int solution(int n) {
        int answer = 0;
        
        
        int left = 0;
        int right = 1;
        int total = 1;
        
        while(right <= n) {
            if(total == n) {
                right++;
                total += right;
                answer++;
            }else if(total > n) {
                total -= left;
                left++;
            }else {
                right++;
                total += right;
            }
        }
        
        //System.out.println(right+" "+left);
        
        return answer;
    }
}