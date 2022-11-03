import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int max = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            max = Math.max(arr[i],max);
        }
        
        for(int i = 1 ; ; i++) {
            
            int cur = max * i;
            boolean pos = true;
            
            for(int j = 0 ; j < arr.length ; j++) {
                if(cur % arr[j] != 0) {
                    pos = false;
                    break;
                }
            }
            
            if(pos == true) {
                answer = cur;
                break;
            } 
            
        }
        
        return answer;
    }
}